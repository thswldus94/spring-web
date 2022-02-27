package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.domain.Member;
import com.sonjy1994.hellospring.domain.User;
import com.sonjy1994.hellospring.repository.MemberRepository;
import com.sonjy1994.hellospring.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// 스프링이 뜰때 서비스임을 인지하고 스프링 컨테이너에 등록
// @Service
// jpa는 트랜잭션 필요함
@Transactional
public class UserService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final UserRepository userRepository;

    // consturct 역할
    // Autowired는 생성자에 적어줘야 함
    // @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
    * 회원 가입
    * */
    public Long join(User user) {
        // 중복 이름은 안됨 걸러내야됨
        validateDuplicateUser(user);

        userRepository.save(user);
        return user.getIdx();
    }

    // 로그인
    public Boolean login(User user) {
        // userRepository.login(user);
        Optional<User> opt = userRepository.findByUserId(user.getUserId());

        if (!opt.isPresent()) {
            return false;
        }

        User userInfo = opt.get();
        return user.getPassword().equals(userInfo.getPassword());
    }

    private void validateDuplicateUser(User user) {
        userRepository.findByUserId(user.getUserId())
        .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원임!!");
        });
    }

    public List<User> findMembers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(String userId) {
        return userRepository.findByUserId(userId);
    }
}

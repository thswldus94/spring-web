package com.sonjy1994.hellospring.controller;

import com.sonjy1994.hellospring.domain.Member;
import com.sonjy1994.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Controller라는 어노테이션을 보고 스프링 컨테이너에 담김

@Controller
public class MemberController {

    private final MemberService memberService;

    // 스프링에서 자동으로 여기저기서 가져다쓸 수 있도록 생성해둠
    // Autowired는 생성자에 적어줘야 함
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

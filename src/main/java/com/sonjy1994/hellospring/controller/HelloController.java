package com.sonjy1994.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // URL route 부분 /hello 요청했을때를 의미한다
    @GetMapping("hello")
    public String hello(Model model) {
        // laravel 에서 view에 넘길 때 데이터 설정 해 주는것과 비슷함
        // key와 value를 설정해서 넘겨줌
        model.addAttribute("data", "good afternoon sonjy1994?! 안녕히 주무셨어요? ^^");
        
        // resources/templates 에서 hello.html 을 찾는다.
        return "hello";
    }

    @GetMapping("param-mvc")
    public String paramMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "param-mvc-tpl";
    }

    @GetMapping("param-string")
    // http body 그대로 리턴해줄때 사용 view 사용하지 않고 json 등으로 리턴해줄때 사용함
    @ResponseBody
    public String paramString(@RequestParam("name") String name) {
        return "string으로 다이렉트 출력 했습니다!: " + name;
    }

    @GetMapping("param-api")
    @ResponseBody
    public Hello paramApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        // 객체 자체를 넘겨주는데
        // ResponseBody가 붙어있으면 json으로 리턴됩니다
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

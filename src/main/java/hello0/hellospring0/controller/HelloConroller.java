package hello0.hellospring0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloConroller {

    @GetMapping("hello")    //hello로 웹 접속하면 자동으로 해당 파일을 통해 접속
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //templates>hello.html로 가서 실행을 시켜
    }


    @GetMapping("hello-mvc")    //외부에서 request param 전달 받은 경우
    public String hellomvc(@RequestParam(value="name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //Body부에 직접 넣어주겠다. annotation
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;    // hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    // 객체로 반환하면 객체가 JSON형태로 변환됨
    //객체
    static class Hello{
        private String name;
        // 프로퍼티 접근 방식
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    }
}

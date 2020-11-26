package com.neusoft.redbag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hehe")
//    @RequestMapping
    public String sayHello() {
        return "Hello 伏黑惠的老婆";
    }
}

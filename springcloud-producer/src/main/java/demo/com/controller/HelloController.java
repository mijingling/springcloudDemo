package demo.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hi")
    public String hi() {
        return "Hi Spring Cloud";
    }
	
	@RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }
	
}

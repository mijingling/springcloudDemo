package demo.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.com.feign.HelloClient;

@RestController
public class ConsumerController {

    @Autowired
    HelloClient helloClient;
	
    @RequestMapping("/hi")
    public String hi(){
    	return helloClient.hi()+"##from consumer##";
    }
    
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloClient.hello(name)+"##from consumer##";
    }

}
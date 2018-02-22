package demo.com.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-producer")
public interface HelloClient {
	
	@RequestMapping(value="/hi")
	String hi();
	
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
	
}

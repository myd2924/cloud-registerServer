package com.myd.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/16 18:03
 * @Description:
 */
@SpringBootApplication
@RestController
public class UserApplication {

    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public UserApplication(WebClient.Builder webClientBuilder,
                           ReactorLoadBalancerExchangeFilterFunction lbFunction){
        this.lbFunction = lbFunction;
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @RequestMapping("/hi")
    public Mono<String> hi(@RequestParam(value = "name",defaultValue = "mary") String name){
        return loadBalancedWebClientBuilder.build()
                .get()
                .uri("http://sayHello/greeting")
                .retrieve().bodyToMono(String.class)
                .map(greet->String.format("%s,%s!",greet,name));

    }

    @RequestMapping("/hello")
    public Mono<String> hello(@RequestParam(value = "name", defaultValue = "John") String name){
        return WebClient.builder()
                .filter(lbFunction)
                .build().get().uri("http://sayHello/greeting")
                .retrieve().bodyToMono(String.class)
                .map(greet->String.format("%s,%s!",greet,name));
    }


}

package com.myd.common.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/16 19:24
 * @Description:
 */
@LoadBalancerClient(name = "sayHello",configuration = SayHelloConfiguration.class)
@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}

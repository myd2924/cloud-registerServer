package com.myd.common.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/16 18:05
 * @Description:
 */
@Configuration
public class SayHelloConfiguration {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier(){
        return new MyServiceInstanceListSupplier("sayHello");
    }
}

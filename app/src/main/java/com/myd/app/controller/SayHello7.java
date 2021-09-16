package com.myd.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/16 17:51
 * @Description:
 */
@RestController
public class SayHello7 {

    private static Logger LOG = LoggerFactory.getLogger(SayHello7.class);

    @GetMapping("/greeting")
    public String greet(){
        LOG.info("access/greeting!");
        final List<String> greeting = Arrays.asList("Hi there", "greeting", "Salutations");
        Random rand = new Random();
        final int nextInt = rand.nextInt(greeting.size());
        return greeting.get(nextInt);
    }

    @GetMapping("/")
    public String home() {
        LOG.info("Access /");
        return "Hi!";
    }

}

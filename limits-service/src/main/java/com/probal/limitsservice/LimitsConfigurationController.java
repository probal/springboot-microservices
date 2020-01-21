package com.probal.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.probal.limitsservice.Bean.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration() {
        LimitsConfiguration limitsConfiguration = new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
        return limitsConfiguration;
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitsConfiguration retrieveConfiguration() {
        throw new RuntimeException("Service Not Available");
    }

    public LimitsConfiguration fallbackRetrieveConfiguration() {
        return new LimitsConfiguration(7777,7);
    }

}

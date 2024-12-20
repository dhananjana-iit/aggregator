package org.iit.cc.aggregator;

import org.iit.cc.aggregator.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class AggregatorApplication {

    @Autowired
    private AggregatorService aggregatorService;

    public static void main(String[] args) {
        SpringApplication.run(AggregatorApplication.class, args);
    }

    @Scheduled(cron = "0 30 0 * * ?")
    public void syncDoctors(){
        aggregatorService.fetchAndSaveDoctors();
    }

}

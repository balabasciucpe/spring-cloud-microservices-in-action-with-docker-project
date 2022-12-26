package com.balabasciuc.springmicroservicesinaction.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;


@SpringBootApplication
@EnableEurekaClient
@RefreshScope
//@EnableBinding(Sink.class)
public class StudentServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

}

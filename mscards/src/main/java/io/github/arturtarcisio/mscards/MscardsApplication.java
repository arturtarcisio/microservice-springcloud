package io.github.arturtarcisio.mscards;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
@Slf4j
public class MscardsApplication {

	public static void main(String[] args) {
		log.info("Informação: {}", "teste info");
		log.error("Informação: {}", "teste error");
		log.warn("Informação: {}", "teste warn");
		SpringApplication.run(MscardsApplication.class, args);
	}

}

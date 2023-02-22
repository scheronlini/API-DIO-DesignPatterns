package com.scheronlini.DIOPadroesdeProjetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioPadroesDeProjetosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioPadroesDeProjetosApplication.class, args);
	}

}

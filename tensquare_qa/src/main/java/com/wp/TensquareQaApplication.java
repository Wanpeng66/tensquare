package com.wp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import com.wp.util.IdWorker;
@SpringBootApplication
@EnableDiscoveryClient
public class TensquareQaApplication {

	public static void main(String[] args) {
		SpringApplication.run( TensquareQaApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}

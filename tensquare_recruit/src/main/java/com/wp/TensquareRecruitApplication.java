package com.wp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.wp.util.IdWorker;
@SpringBootApplication
public class TensquareRecruitApplication {

	public static void main(String[] args) {
		SpringApplication.run( TensquareRecruitApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}

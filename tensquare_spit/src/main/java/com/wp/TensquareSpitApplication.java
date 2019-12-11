package com.wp;

import com.wp.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TensquareSpitApplication {

    public static void main( String[] args ) {
        SpringApplication.run( TensquareSpitApplication.class, args );
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(  );
    }

}

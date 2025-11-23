package com.arcade.coreboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class CoreBootApplication {

    static void main(String[] args) {
        SpringApplication.run(CoreBootApplication.class, args);
    }

}

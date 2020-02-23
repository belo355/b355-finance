package com.b355;

import com.b355.model.Credito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class B355Application {

	public static void main(String[] args) {
		SpringApplication.run(B355Application.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan(Credito.class.getPackage().getName());
		context.refresh();
	}

			}

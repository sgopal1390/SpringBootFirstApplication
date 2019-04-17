<<<<<<< HEAD
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.*")
public class SpringBootFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFinalApplication.class, args);
	}
	
}
=======
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFinalApplication.class, args);
	}
}
>>>>>>> a3d697e27e4f4183d394d7fe3e4eab24dac29800

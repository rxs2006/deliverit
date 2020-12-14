package br.com.deliver.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.deliver.it")
public class DeliveritApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveritApplication.class, args);
	}

}

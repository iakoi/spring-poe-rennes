package poe.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		String toPrint = "";
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				toPrint += "Fizz";
			}
			if (i % 5 == 0) {
				toPrint += "Buzz";
			}
			System.out.println(toPrint.isEmpty() ? i : toPrint);
			toPrint = "";
		}
		SpringApplication.run(Application.class, args);
	}
}
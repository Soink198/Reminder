package com.reminder.reminder;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reminder.reminder.run.Run;

@SpringBootApplication
public class ReminderApplication {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ReminderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReminderApplication.class, args);

		WelcomeMsg welcomeMsg = new WelcomeMsg();
		System.out.println(welcomeMsg.getMsg());

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 10);
			log.info("Run info complete! " + run);

		};
	}
}

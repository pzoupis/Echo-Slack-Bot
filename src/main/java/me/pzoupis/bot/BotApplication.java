package me.pzoupis.bot;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotApplication {

	private final static Logger LOGGER = Logger.getLogger(BotApplication.class.getName());
	public static void main(String[] args) {
		LOGGER.info("Bot application is starting...");
		SpringApplication.run(BotApplication.class, args);
	}
}

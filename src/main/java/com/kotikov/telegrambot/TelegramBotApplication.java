package com.kotikov.telegrambot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
/**
 * @Author Kotikov_ev
 * @version 1.0
 * For starting application please run main method
 * @see Bot
 */
@SpringBootApplication
public class TelegramBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(TelegramBotApplication.class);
	}

}

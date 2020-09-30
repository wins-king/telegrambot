package com.kotikov.telegrambot.config;

import com.kotikov.telegrambot.Bot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Getter @Setter
@Configuration
@ConfigurationProperties(value = "telegrambot")
public class BotConfig {
    private String botname;

    private String token;

    @Bean
    public Bot TelegramBot(){
        Bot telegramBot = new Bot();
        telegramBot.setBotname(this.botname);
        telegramBot.setToken(this.token);
        try {
            new TelegramBotsApi().registerBot(telegramBot);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
        return telegramBot;
    }
}

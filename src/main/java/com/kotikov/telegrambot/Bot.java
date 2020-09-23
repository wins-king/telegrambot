package com.kotikov.telegrambot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {

    @Value("${telegrambot.token}")
    private String token;
    @Value("${telegrambot.name}")
    private String botname;

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
    }

    @Override
    public String getBotUsername() {
        return this.botname;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }
}

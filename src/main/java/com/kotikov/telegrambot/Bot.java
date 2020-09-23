package com.kotikov.telegrambot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
    }

    @Override
    public String getBotUsername() {
        return "KotikovEvgenTelegramBot";
    }

    @Override
    public String getBotToken() {
        return "1337804692:AAGLyrUobRx7T1sqwiOqeFEdm8W61bqK2rI";
    }
}

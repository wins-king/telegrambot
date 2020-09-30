package com.kotikov.telegrambot;

import com.kotikov.telegrambot.enums.MsgType;
import com.kotikov.telegrambot.model.City;
import com.kotikov.telegrambot.service.CityService;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Setter
public class Bot extends TelegramLongPollingBot {

    @Autowired
    private CityService cityService;

    private String botname;

    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        if(message!=null && message.hasText()){
            switch (message.getText()) {
                case "/start":
                    sendMessage.setText("Pls enter city name. For example, Moscow. To call up a hint send /help ");
                    break;
                case "/help":
                    sendMessage.setText("Just enter city name. It's easy. To help you, we will add a keyboard below.");
                    setKeyboard(sendMessage);
                    break;
                default:
                    sendMessage.setText(cityService.responseMsg(message, MsgType.CITY_INFO));
                    break;
            }
        }else{
            sendMessage.setText(cityService.responseMsg(message, MsgType.UNSUPPORTABLE));
        }
        try{
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    private void setKeyboard(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        List<City> listCities = cityService.getAll();
        if(listCities!=null){
            listCities.forEach(city -> {
                keyboardFirstRow.add(city.getName());
            });
        }else{
            keyboardFirstRow.add("/start");
            keyboardFirstRow.add("/help");
        }
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
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

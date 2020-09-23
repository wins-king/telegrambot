package com.kotikov.telegrambot.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@Configurable
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql:https//remotemysql.com:3306/vj455irAWH");
        dataSourceBuilder.username("vj455irAWH");
        dataSourceBuilder.password("UiBUCvMqe2");
        return dataSourceBuilder.build();
    }
}

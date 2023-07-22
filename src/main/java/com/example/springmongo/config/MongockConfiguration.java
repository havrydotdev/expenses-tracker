package com.example.springmongo.config;

import io.mongock.driver.api.driver.ConnectionDriver;
import io.mongock.driver.mongodb.springdata.v4.SpringDataMongoV4Driver;
import io.mongock.runner.springboot.MongockSpringboot;
import io.mongock.runner.springboot.base.MongockInitializingBeanRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MongockConfiguration {
    @Bean
    public MongockInitializingBeanRunner mongockInitializingBeanRunner(ConnectionDriver driver, ApplicationContext applicationContext) {
        return MongockSpringboot.builder()
                .setDriver(driver)
                .addMigrationClass(ExpenseChangeUnit.class)
                .setSpringContext(applicationContext)
                .buildInitializingBeanRunner();
    }
}

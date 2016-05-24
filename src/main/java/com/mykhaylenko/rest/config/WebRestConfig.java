package com.mykhaylenko.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by Pavlo.Mykhaylenko on 5/5/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.mykhaylenko.rest.controller")
public class WebRestConfig extends WebMvcConfigurerAdapter{

//    @Bean
//    public ViewResolver viewResolver(ContentNegotiationManager negotiationManager) {
//        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
//        viewResolver.setContentNegotiationManager(negotiationManager);
//        return viewResolver;
//    }
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.defaultContentType(MediaType.APPLICATION_JSON);
//    }
//
//    @Bean
//    public ViewResolver beanNameViewResolver() {
//        return new BeanNameViewResolver();
//    }
//
//    @Bean
//    public View mappingToJson() {
//        return new MappingJackson2JsonView();
//    }
}

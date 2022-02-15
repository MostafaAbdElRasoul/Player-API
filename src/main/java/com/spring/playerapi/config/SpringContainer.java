package com.spring.playerapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@ComponentScan("com.spring")
@PropertySource({"classpath:sql.properties"})
public class SpringContainer {

}

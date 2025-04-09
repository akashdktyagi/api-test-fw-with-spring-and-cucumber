package com.natyalabs.glue.config;

import com.natyalabs.Main;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(classes = {Main.class})
@ActiveProfiles("dev1")
@Slf4j
public class CucumberSpringConfiguration {
}

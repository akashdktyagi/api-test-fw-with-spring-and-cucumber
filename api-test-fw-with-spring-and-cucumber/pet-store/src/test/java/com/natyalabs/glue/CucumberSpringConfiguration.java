package com.natyalabs.glue;

import com.natyalabs.Main;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@CucumberContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
@ActiveProfiles("dev1")
@Slf4j
public class CucumberSpringConfiguration {
}

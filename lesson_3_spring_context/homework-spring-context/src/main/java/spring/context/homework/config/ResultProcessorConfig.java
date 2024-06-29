package spring.context.homework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("spring.context.homework")
@Import(PropertiesConfiguration.class)
public class ResultProcessorConfig {
}

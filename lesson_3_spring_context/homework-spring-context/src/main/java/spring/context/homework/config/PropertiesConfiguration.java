package spring.context.homework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:result-processor.properties")
public class PropertiesConfiguration {
}

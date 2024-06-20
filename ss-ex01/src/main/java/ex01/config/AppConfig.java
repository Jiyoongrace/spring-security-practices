package ex01.config;

import ex01.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class AppConfig {
    @Bean
    public Filter myFilter() {
        return new MyFilter();
    }
}

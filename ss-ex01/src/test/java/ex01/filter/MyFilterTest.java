package ex01.filter;

import ex01.config.AppConfig;
import ex01.config.WebConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={WebConfig.class, AppConfig.class})
public class MyFilterTest {
}

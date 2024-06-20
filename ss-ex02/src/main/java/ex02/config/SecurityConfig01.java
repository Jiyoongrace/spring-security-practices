package ex02.config;

import ex02.filter.MySecurityFilter01;
import ex02.filter.MySecurityFilter02;
import ex02.filter.MySecurityFilter03;
import ex02.filter.MySecurityFilter04;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.AntPathMatcher;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig01 {
    @Bean
    public FilterChainProxy springSecurityFilterChain() {
        List<SecurityFilterChain> securityFilterChains = Arrays.asList(
                new SecurityFilterChain() {
                    @Override
                    public boolean matches(HttpServletRequest request) {
                        String uri = request.getRequestURI().replaceAll(request.getContextPath(), "");
                        return new AntPathMatcher().match("/assets/**", uri);
                    }

                    @Override
                    public List<Filter> getFilters() {
                        return List.of();
                    }
                },
                new SecurityFilterChain() {
                    @Override
                    public boolean matches(HttpServletRequest request) {
                        String uri = request.getRequestURI().replaceAll(request.getContextPath(), "");
                        return new AntPathMatcher().match("/**", uri);
                    }

                    @Override
                    public List<Filter> getFilters() {
                        return Arrays.asList(
                                mySecurityFilter01(),
                                mySecurityFilter02(),
                                mySecurityFilter03()

                        );
                    }
                }
        );
        return new FilterChainProxy(securityFilterChains);
    }

    @Bean
    public MySecurityFilter01 mySecurityFilter01() {
        return new MySecurityFilter01();
    }

    @Bean
    public MySecurityFilter02 mySecurityFilter02() {
        return new MySecurityFilter02();
    }

    @Bean
    public MySecurityFilter03 mySecurityFilter03() {
        return new MySecurityFilter03();
    }
}

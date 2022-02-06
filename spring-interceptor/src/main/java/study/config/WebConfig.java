package study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import study.interceptor.FirstInterceptor;
import study.interceptor.SecondInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor())
            .order(1)
            .addPathPatterns("/sample/**")
            .excludePathPatterns("/css/**", "/*.ico");

        registry.addInterceptor(new SecondInterceptor())
            .order(2)
            .addPathPatterns("/sample/**")
            .excludePathPatterns("/css/**", "/*.ico");
    }
}

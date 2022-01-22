package study.servletfilter.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import study.servletfilter.filter.FirstFilter;
import study.servletfilter.filter.SecondFilter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<Filter> firstFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new FirstFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/sample/*");

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> secondFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new SecondFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/sample/*");

        return filterRegistrationBean;
    }
}

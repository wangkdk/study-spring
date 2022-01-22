package study.servletfilter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("first filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
        IOException,
        ServletException {
        log.info("first filter doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        log.info("request uri: {}", httpRequest.getRequestURI());

        String status = httpRequest.getParameter("status");
        if (!status.equals("pass")) {
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("first filter destroy");
    }
}

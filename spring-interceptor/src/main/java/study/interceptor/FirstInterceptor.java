package study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstInterceptor implements HandlerInterceptor {

    private static final String PARAM = "param";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
        Exception {
        log.info("first interceptor preHandle");

        String status = request.getParameter("status");
        if (!status.equals("pass")) {
            return false;
        }

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod)handler;
            log.info("hm: {}", hm.getMethod());
        }

        request.setAttribute(PARAM, "preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        log.info("first interceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex) throws Exception {
        log.info("first interceptor afterCompletion");

        if (ex != null) {
            log.error("first interceptor afterCompletion error: ", ex);
        }

        String param = (String)request.getAttribute(PARAM);
        log.info("param : {}", param);
    }
}

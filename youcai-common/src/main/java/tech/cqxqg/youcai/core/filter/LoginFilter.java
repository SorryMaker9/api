package tech.cqxqg.youcai.core.filter;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 如果是OPTIONS则结束请求
        if (HttpMethod.OPTIONS.toString().equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
            ((HttpServletResponse) response).setStatus(HttpStatus.OK.value());
            return;
        }
        try {

            // TODO 登录拦截，设置userId，直接RequestContext.getUserId();
            RequestContext.setUserId("admin");
            chain.doFilter(request, response);
        } finally {
            RequestContext.clear();
        }
    }

}

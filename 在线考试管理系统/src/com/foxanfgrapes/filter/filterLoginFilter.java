package com.foxanfgrapes.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class filterLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String URI = request.getRequestURI();
        if (URI.indexOf("login") != -1 || "/myWeb/".equals(URI) || "/myWeb".equals(URI)) {
            chain.doFilter(req, resp);
            return;
        }
        if (request.getSession(false) == null) {
            request.getRequestDispatcher("/login_Error.html").forward(req, resp);
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

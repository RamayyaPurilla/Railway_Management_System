package com.example.irctc.Config;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AdminApiKeyFilter implements Filter {

    private static final String ADMIN_API_KEY = "SECRET_ADMIN_KEY_123";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        if (path.startsWith("/api/admin/")) {
            String key = req.getHeader("X-API-KEY");

            if (key == null || !ADMIN_API_KEY.equals(key)) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("Unauthorized: Invalid API Key");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}

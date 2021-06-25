package ru.litvinov.diplom.filters;

import javax.servlet.*;
import java.io.IOException;

public class CharFilter implements Filter {

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "windows-1251";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {

        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }
        response.setContentType("text/html; charset=windows-1251");
        response.setCharacterEncoding("windows-1251");
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}
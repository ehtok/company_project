package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static Сonstant.Constants.*;

@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
        response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

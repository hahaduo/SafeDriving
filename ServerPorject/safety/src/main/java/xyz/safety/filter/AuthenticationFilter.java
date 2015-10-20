package xyz.safety.filter;

import xyz.safety.vo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lihongjun on 15/10/15.
 */

@WebFilter("/login/loginok")
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("lihj-18:filter is initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        Users user = (Users)req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(request.getServletContext().getContextPath()+"/login/signon");
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}

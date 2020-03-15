package by.itcollege.web;

import by.itcollege.entity.Role;
import by.itcollege.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/car/save", filterName = "CarSavingFilter")
public class CarSavingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
            if (user != null && user.getRole() == Role.CLIENT) {
                ((HttpServletResponse) servletResponse).sendRedirect("/request/save");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

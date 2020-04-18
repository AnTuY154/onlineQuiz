/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Darkness_King
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String reqURI = req.getRequestURI();
        // go throw file css or js or imge
        if (reqURI.endsWith(".css") || reqURI.endsWith(".js") || reqURI.endsWith(".jpg") || reqURI.endsWith(".gif")) {
     
            chain.doFilter(request, response);
        } 
        else if (!reqURI.endsWith("/Login") && isAuthenticated(req) == false && !reqURI.endsWith("/register")) {
        
            resp.sendRedirect("Login");
        } else {
         
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("name") == null) {
            return false;
        } else {
            return true;
        }
    }
}

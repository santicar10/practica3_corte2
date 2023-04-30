package com.example.practica3_corte2.filter;

import com.example.practica3_corte2.swervice.LoginService;
import com.example.practica3_corte2.swervice.impl.LoginServiceSessionImp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/productos"})//url que deseamos aplique el filtro
public class LoginFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImp();
        Optional<String> username = service.getUsername((HttpServletRequest) request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "No estás autorizado para ingresar a esta página!");
        }
    }
}


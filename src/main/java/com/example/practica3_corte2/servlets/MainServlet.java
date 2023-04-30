package com.example.practica3_corte2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "main-servlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metodoHTTP=request.getMethod();
        String requestURI=request.getRequestURI();
        String requestURL=request.getRequestURL().toString();
        String contextPath=request.getContextPath();
        String servletPath=request.getServletPath();
        String ipClinete=request.getRemoteAddr();
        String ip=request.getLocalAddr();
        int port=request.getLocalPort();
        String scheme=request.getScheme();
        String host=request.getHeader("host");
        String url=scheme + "://" + host + contextPath + servletPath;
        String url2=scheme + "://" + ip + ":" + port + contextPath + servletPath;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
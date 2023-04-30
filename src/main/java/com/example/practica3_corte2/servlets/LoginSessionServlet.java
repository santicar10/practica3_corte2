package com.example.practica3_corte2.servlets;

import com.example.practica3_corte2.swervice.LoginService;
import com.example.practica3_corte2.swervice.impl.LoginServiceSessionImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "LoginSessionServlet", value = "/loginsession")
public class LoginSessionServlet extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceSessionImp();
        Optional<String> httpOptional = auth.getUsername(req);
        if (httpOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Hola " + httpOptional.get() +
                        "</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Hola " + httpOptional.get() + " has iniciado sesión con éxito!</h1>");
                out.println("<p><a href='" + req.getContextPath() +
                        "'>volver</a></p>");
                out.println("<p><a href='" + req.getContextPath() +
                        "/logout'>cerrar sesión</a></p>");
                out.println(" </body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/loginsession");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
    }


}


package com.example.practica3_corte2.servlets;

import com.example.practica3_corte2.model.Product;
import com.example.practica3_corte2.swervice.ProductService;
import com.example.practica3_corte2.swervice.impl.ProductServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceImp();
        List<Product> products = service.listar();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(products);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Product producto = mapper.readValue(jsonStream, Product.class);
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Detalle de producto desde json</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Detalle de producto desde json!</h1>");
            out.println("<ul>");
            out.println("<li>Id: "+ producto.getId() + "</li>");
            out.println("<li>Nombre: " + producto.getName() + "</li>");
            out.println("<li>Tipo: " + producto.getTipo() + "</li>");
            out.println("<li>Precio: " + producto.getPrice() + "</li>");
            out.println("</ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}

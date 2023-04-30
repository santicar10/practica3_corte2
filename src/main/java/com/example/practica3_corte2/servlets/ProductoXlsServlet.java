package com.example.practica3_corte2.servlets;

import com.example.practica3_corte2.model.Product;
import com.example.practica3_corte2.swervice.ProductService;
import com.example.practica3_corte2.swervice.impl.ProductServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls","/productos.html","/productos"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service=new ProductServiceImp();
        List<Product> products=service.listar();
        response.setContentType("text/html;charset=UTF-8");
        String servletPath = request.getServletPath();
        Boolean esXls=servletPath.endsWith(".xls");
        if (esXls){
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        }
        try (PrintWriter out=response.getWriter()){
            if (!esXls){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <meta charset=\"UTF-8\">");
                out.println("       <title>listado de productos</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Listado de productos</h1>");
                out.println("       <p><a href=\""+request.getContextPath()+"/productos.xls"+"\">exportar a xls</a></p>");
                out.println("       <p><a href=\""+request.getContextPath()+"/productos.json"+"\">mostrar json</a></p>");
            }
            out.println("       <table>");
            out.println("           <tr>");
            out.println("               <th>id</th>");
            out.println("               <th>nombre</th>");
            out.println("               <th>tipo</th>");
            out.println("               <th>precio</th>");
            out.println("           </tr>");
            products.forEach(p->{
                out.println("           <tr>");
                out.println("               <th>"+p.getId()+"</th>");
                out.println("               <th>"+p.getName()+"</th>");
                out.println("               <th>"+p.getTipo()+"</th>");
                out.println("               <th>"+p.getPrice()+"</th>");
                out.println("           </tr>");
            });
            if (!esXls) {
                out.println("       </table>");
                out.println("   </body>");
                out.println("</html>");
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}

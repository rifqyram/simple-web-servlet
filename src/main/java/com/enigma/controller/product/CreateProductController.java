package com.enigma.controller.product;

import com.enigma.dao.impl.ProductDAO;
import com.enigma.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class CreateProductController extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("components/product/formCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("productName");
        Long price = Long.parseUnsignedLong(req.getParameter("productPrice"));
        Integer stock = Integer.parseInt(req.getParameter("stock"));

        Product product = new Product(name, price, stock, Date.valueOf(LocalDate.now()), null);
        productDAO.save(product);
        resp.sendRedirect("products");
    }
}

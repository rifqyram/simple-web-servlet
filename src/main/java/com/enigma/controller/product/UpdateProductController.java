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

public class UpdateProductController extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseUnsignedLong(req.getParameter("productId"));
        Product product = productDAO.getById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("components/product/formUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseUnsignedLong(req.getParameter("productId"));
        String name = req.getParameter("productName");
        Long price = Long.parseUnsignedLong(req.getParameter("productPrice"));
        Integer stock = Integer.parseInt(req.getParameter("stock"));

        Product product = new Product(id, name, price, stock, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        System.out.println(product);
        productDAO.update(product);
        resp.sendRedirect("products");
    }
}

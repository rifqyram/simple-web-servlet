package com.enigma.controller.customer;

import com.enigma.dao.impl.CustomerDAO;
import com.enigma.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCustomerController extends HttpServlet {

    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new CustomerDAO();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerDAO.findAll();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("components/customer/customer.jsp").forward(req, resp);
    }
}

package com.enigma.controller.customer;

import com.enigma.dao.impl.CustomerDAO;
import com.enigma.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class CreateCustomerController extends HttpServlet {

    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new CustomerDAO();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("components/customer/formCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("customerName");
        String address = req.getParameter("customerAddress");
        String phone = req.getParameter("customerPhone");
        String birthDate = req.getParameter("customerBirthDate");

        Customer customer = new Customer(
                name,
                address,
                phone,
                Date.valueOf(birthDate),
                true,
                Date.valueOf(LocalDate.now()),
                null);
        customerDAO.save(customer);
        resp.sendRedirect("customers");
    }
}

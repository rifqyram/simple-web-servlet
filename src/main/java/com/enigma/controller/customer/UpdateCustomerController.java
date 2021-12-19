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

public class UpdateCustomerController extends HttpServlet {

    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new CustomerDAO();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseUnsignedLong(req.getParameter("customerId"));
        Customer customer = customerDAO.getById(id);
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("components/customer/formUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseUnsignedLong(req.getParameter("customerId"));
        String name = req.getParameter("customerName");
        String address = req.getParameter("customerAddress");
        String phone = req.getParameter("customerPhone");
        String birthDate = req.getParameter("customerBirthDate");
        boolean status = req.getParameter( "customerStatus" ) != null;

        Customer customer = new Customer(
                id,
                name,
                address,
                phone,
                Date.valueOf(birthDate),
                status,
                Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now()));

        customerDAO.update(customer);
        resp.sendRedirect("customers");
    }
}

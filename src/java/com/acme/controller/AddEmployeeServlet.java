package com.acme.controller;

import com.acme.model.DBManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployeeServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String empName = request.getParameter("emp_name");
        String empDesignation = request.getParameter("emp_designation");
        String reportingManager = request.getParameter("reporting_manager");
        
        boolean flag = DBManager.addEmployee(empName, empDesignation, reportingManager);
        if(flag)
        {
            request.setAttribute("destination", "success.html");
        }
        else
        {
            request.setAttribute("destination", "fail.html");
        }
        
        RequestDispatcher view = request.getRequestDispatcher("RedirectServlet");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}

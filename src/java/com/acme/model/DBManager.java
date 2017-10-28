package com.acme.model;

import com.acme.controller.DatabaseContextListener;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class DBManager
{
    private static String dbUrl, dbUser, dbPassword;
    
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            dbUrl = DatabaseContextListener.getDbUrl();
            dbUser = DatabaseContextListener.getDbUser();
            dbPassword = DatabaseContextListener.getDbPassword();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean addEmployee(String empName, String empDesignation, String reportingManager)
    {
        boolean flag = false;
        try
        {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement st = con.prepareStatement("INSERT INTO employee VALUES(?,?,?)");
            st.setString(1, empName);
            st.setString(2, empDesignation);
            st.setString(3, reportingManager);
            st.executeUpdate();
            con.close();
            flag = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public static String getAllEmployeesJSON()
    {
        String json = null;
        try
        {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement st = con.prepareStatement("SELECT * FROM employee");
            ResultSet rs = st.executeQuery();
            if(rs != null)
            {
                ArrayList<Employee> employees = new ArrayList<>();
                while(rs.next())
                {
                    employees.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3)));
                }
                
                json = new Gson().toJson(employees);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return json;
    }
}

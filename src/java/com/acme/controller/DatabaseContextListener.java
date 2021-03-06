package com.acme.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseContextListener implements ServletContextListener
{
    private static String dbUrl, dbUser, dbPassword;
    
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext sc = sce.getServletContext();
        dbUrl = sc.getInitParameter("dbUrl");
        dbUser = sc.getInitParameter("dbUser");
        dbPassword = sc.getInitParameter("dbPassword");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String getDbUrl()
    {
        return dbUrl;
    }
    
    public static String getDbUser()
    {
        return dbUser;
    }
    
    public static String getDbPassword()
    {
        return dbPassword;
    }
}

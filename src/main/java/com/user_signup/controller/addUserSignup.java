package com.user_signup.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


@WebServlet("/add")
public class addUserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addUserSignup() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x= request.getParameter("name");
		String y= request.getParameter("email");
		String z= request.getParameter("mobile");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", "root", "test");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("Insert into registration values('"+x+"','"+y+"','"+z+"')");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

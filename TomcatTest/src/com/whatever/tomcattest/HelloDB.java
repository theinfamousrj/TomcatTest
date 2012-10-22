package com.whatever.tomcattest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Driver;

/**
 * Servlet implementation class HelloDB
 */
@WebServlet("/HelloDB")
public class HelloDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBConnect conn = new DBConnect();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloDB() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		try {
			conn.readDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println(conn.getTheResults());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//anything that goes to Post will automatically be sent to Get.
		this.doGet(request, response);
	}

}

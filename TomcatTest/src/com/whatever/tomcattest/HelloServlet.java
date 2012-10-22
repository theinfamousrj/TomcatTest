package com.whatever.tomcattest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestClass tc = new TestClass();
		
		tc.setTheString("Yes, this did work.");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>\n" +
					"<BODY>\n" +
					"<h1>HELLO THERE!</h1>\n" +
					"<p>" +
					tc.getTheString() +
					"</p>\n" +
					"</BODY>\n" +
					"</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//anything that goes to Post will automatically be sent to Get.
		this.doGet(request, response);
	}

}

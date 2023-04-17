package com.incapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.incapp.model.DAO;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String n=request.getParameter("name");
			
			DAO db=new DAO();
			ArrayList<HashMap> users=db.getUsersLikeName(n);
			db.closeConnection();
			
			RequestDispatcher rd=request.getRequestDispatcher("ProductDetails.jsp");
			request.setAttribute("users", users);
			rd.forward(request, response);
		}catch (Exception e) {
			response.sendRedirect("ExpPage.jsp");
		}
	}

}

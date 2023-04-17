package com.incapp.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			HttpSession session=request.getSession(false);
			if(session==null) {
				session.setAttribute("msg", "Please Login First!");
				response.sendRedirect("Login.jsp");
			}else {
				String companyname=request.getParameter("companyname");
				String name=request.getParameter("name");
				int price=Integer.parseInt(request.getParameter("price"));
				String description=request.getParameter("description");
				
				HashMap<String, Object> user=new HashMap<>();
				user.put("companyname", companyname);
				user.put("name", name);
				user.put("price", price);
				user.put("description", description);
				
				DAO db=new DAO();
				String result=db.addProduct(user);
				db.closeConnection();
				
				session.setAttribute("msg", result);
				response.sendRedirect("AdminHome.jsp");
			}
		}catch (Exception e) 
		
		{
			response.sendRedirect("ExpPage.jsp");

		}
	}

}

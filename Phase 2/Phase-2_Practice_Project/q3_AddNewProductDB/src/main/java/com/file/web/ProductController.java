package com.file.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.file.web.dao.ProductDAO;
import com.file.web.model.Product;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Create a dispatcher and get the Product id from index.js
		// Create Product DAO to get the data from the database
		// Inside Product DAO Create Product object and save the data from the Database in it
		// Pass the Product object to showProduct.jsp to the user to see it.

		try {
			RequestDispatcher reqDis = request.getRequestDispatcher("showProducts.jsp");
			int pid = Integer.parseInt(request.getParameter("pid"));
			// Create Product DAO to get the data from the database
			// Inside Product DAO Create Product object and save the data from the Database in it
			ProductDAO pDAO = new ProductDAO();
			Product prd = pDAO.getProduct(pid);
			// Pass the Product object to showProduct.jsp to the user to see it.
			request.setAttribute("product", prd);
			reqDis.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher reqDisforID = request.getRequestDispatcher("index.jsp");
			request.setAttribute("idMessage", "Please Product ID must be a posative number only.");
			reqDisforID.forward(request, response);

		}

	}

}

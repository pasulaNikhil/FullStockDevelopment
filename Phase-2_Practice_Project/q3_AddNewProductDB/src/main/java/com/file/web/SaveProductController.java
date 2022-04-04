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
public class SaveProductController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		 Create a dispatcher and get the Product id,Product name, Product company from user (index.js)
//		 Create Product DAO to save the entered data into the database 
//		 Inside Product DAO Create Product object and save the data from the user in it
//		 Notify the user if the product saved successfully/not, exist/not
//		 Alert the user, if the Product ID entered was a letters instead of positive numbers.


		RequestDispatcher reqDisforID = request.getRequestDispatcher("index.jsp");

		try {
			// Create a dispatcher and get the Product id,Product name, Product company from user (index.js)
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String scompany = request.getParameter("scompany");
			
			// Create Product DAO to save the entered data into the database 
			ProductDAO pDAO = new ProductDAO();
			// Inside Product DAO Create Product object and save the data from the user in it
			Product checkresult = pDAO.saveProduct(sid, sname, scompany);

			if (checkresult == null) {
				// Notify the user if the product saved successfully/not, exist/not 
				RequestDispatcher reqDis = request.getRequestDispatcher("index.jsp");
				request.setAttribute("message", "The Product added successfully");
				reqDis.forward(request, response);

			} else {
				// Notify the user if the product exist/not 
				System.out.println("it is already exist");
				RequestDispatcher reqDis = request.getRequestDispatcher("index.jsp");
				request.setAttribute("message", "The Product already exists! ");
				reqDis.forward(request, response);
			}

		} catch (Exception e) {
			// Alert the user, if the Product ID entered was a letters instead of positive numbers.
			request.setAttribute("idMessage", "Please Product id must be a posative a number only.");

			reqDisforID.forward(request, response);

		}


	}

}

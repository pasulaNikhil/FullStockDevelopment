package com.file.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.file.web.model.Product;

public class ProductDAO {


//	Create product method :
//	1-Connect to the database 
//	2-Execute a query to get data from the database
//	3-Save the data in a new product object.
//	4-Return the product to be used in the (Product Controller)
	
	public Product getProduct(int pid) {
		Product product = new Product();

		try {
			//1-Connect to the database 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connectionToDB = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ecommerce?createDatabaseIfNotExist=true", "root", "Abc@123");
			Statement st = connectionToDB.createStatement();
			//2-Execute a query to get data from the database
			ResultSet resultData = st.executeQuery("select * from eproduct where id=" + pid + ";");

			if (resultData.next()) {
				//3-Save the data in a new product object.
				product.setId(resultData.getInt("id"));
				product.setName(resultData.getString("name"));
				product.setCompany(resultData.getString("company"));
			}

		} catch (SQLException e) {
			System.out.println("sql problem:" + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//4-Return the product to be used in the (Product Controller)
		return product;

	}

	
	
	
//	Save new product:
//		1-Get the data from the product object (Created in the saveProductController)
//		2-Connect to the database 
//		3-Execute a query to see if the project exist already in database or not
//		4-If product exist, return the product and notify the user(Product exist)
//		5-If not, then save the data in a new product object.
		
	public Product saveProduct(int id, String sname, String scompany) {

		Product product = new Product(id, sname, scompany);
		//1-Get the data from the product object (Created in the saveProductController)
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getCompany());

		try {
			//2-Connect to the database 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ecommerce?createDatabaseIfNotExist=true", "root", "Abc@123");
			Statement st = connection.createStatement();
			//3-Execute a query to see if the project exist already in database or not
			ResultSet resultData = st.executeQuery("select * from eproduct where id=" + product.getId() + ";");
			//4-If product exist, return the product and notify the user(Product exist)
			if (resultData.next()) {
				return product;
			}  else {
				//5-If not, then save the data in a new product object.
				int result = st.executeUpdate("INSERT INTO eproduct(id,name,company) VALUES (" + product.getId() + ",'"
						+ product.getName() + "','" + product.getCompany() + "');");
			}

		} catch (SQLException e) {
			System.out.println("Sorry the is a problem with database" + e);

		} catch (ClassNotFoundException ee) {
			// TODO: handle exception
			System.out.println("Sorry class not found"+ee);
		}

		return null;

	}

}

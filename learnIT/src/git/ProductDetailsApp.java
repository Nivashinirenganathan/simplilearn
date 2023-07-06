package git;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDetailsApp {
	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/ecommerce";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "Nivashini@#85";
	public static void main(String[] args) {
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the database connection
			Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

			// Create a BufferedReader to read user input
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Prompt the user to enter the product ID
			System.out.print("Enter Product ID: ");
			int productId = Integer.parseInt(reader.readLine());

			// Prepare the SQL query
			String sql = "SELECT * FROM product WHERE product_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, productId);

			// Execute the query and retrieve the result set
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// Product found, display the details
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");

			    System.out.println("Product Details:");
				System.out.println("Product ID: " + productId);
				System.out.println("Product Name: " + name);
				System.out.println("Description: " + description);
				System.out.println("Product Price: $" + price);
			} else {
				// Product not found
				System.out.println("Product not found");
			}

			// Close the resources
			resultSet.close();
			statement.close();
			connection.close();
		} 
		catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}

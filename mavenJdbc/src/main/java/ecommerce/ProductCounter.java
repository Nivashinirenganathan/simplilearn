package ecommerce;
import java.sql.*;
public class ProductCounter {
	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/ecommerce";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "Nivashini@#85";

	public static void main(String[] args) {
		String productType = "Electronics"; // Replace this with the product type you want to count

		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
			String sql = "SELECT COUNT(*) AS product_count FROM products WHERE Product_Type = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, productType);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt("product_count");
				System.out.println("Number of products with similar type '" + productType + "': " + count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



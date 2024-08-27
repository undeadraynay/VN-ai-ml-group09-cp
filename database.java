package Inventory;
import java.sql.*;
import java.util.*;


public class database {

	public static void main(String[] args) throws Exception {
		//insert();
		delete();
		

	}
	public static void insert(){
        String url = "jdbc:mysql://localhost:3306/Inventory";
        String username = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            
            String query = "Insert into electronics values(?, ?, ?, ?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(query);
            Scanner sc = new Scanner(System.in);

            String product_code,product_name;
            int serial_number,stock,average_stock;
            float mrp;
            
            
            
            average_stock = 0;
            
            System.out.println("Enter the name of the Product: ");
            product_name = sc.next();
            
            System.out.println("Enter the product code : ");
            product_code= sc.next();

            System.out.println("Enter the number of units required: ");
            stock = sc.nextInt();

            System.out.println("Enter Mrp of the products: ");
            mrp = sc.nextInt();

            serial_number = 0;

            ps.setInt(1, serial_number);
            ps.setString(2, product_code);
            ps.setString(3, product_name);
            ps.setInt(4, stock);
            ps.setFloat(5,average_stock);
            ps.setFloat(6,mrp);
            
            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Data inserted successfully");
                //read();
            } else {
                System.out.println("Data not inserted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
	public static void delete(){
        String url = "jdbc:mysql://localhost:3306/Inventory";
        String username = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);
            
            String query = "delete from electronics where product_code =?";
            PreparedStatement ps = conn.prepareStatement(query);
            
           String product_code;
           
            System.out.println("Enter the product code for the product to be deleted: ");
            product_code = sc.next();
            
            ps.setString(1, product_code);
        
            int rowsAffected = ps.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Data deleted successfully");
                //read();
            } else {
                System.out.println("Data not deleted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


	}
}


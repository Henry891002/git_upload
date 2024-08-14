package com.cathaybk.practice.nt00550339.b;

import java.sql.*;
import java.time.chrono.MinguoChronology;
import java.util.*;

public class CarDatabaseManager {

	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER = "student";

	private static final String PASSWORD = "student123456";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("請選擇以下指令輸入: select, insert, update, delete");

		String command = scanner.nextLine();

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

			switch (command.toLowerCase()) {

			case "select":

				query(connection, scanner);

				break;

			case "insert":

				insert(connection, scanner);

				break;

			case "update":

				update(connection, scanner);

				break;

			case "delete":

				delete(connection, scanner);

				break;

			default:

				System.out.println("無效的指令");

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	private static void query(Connection connection,Scanner scanner) throws SQLException {
    	 System.out.println("請輸入製造商 (留空表示不指定):");
         String manufacturer = scanner.nextLine().trim();
         
         System.out.println("請輸入類型 (留空表示不指定):");
         String type = scanner.nextLine().trim();
         
         StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM CARS WHERE 1=1");
         List<Object> parameters = new ArrayList<>();
         
         if (!manufacturer.isEmpty()) {
             sqlBuilder.append(" AND MANUFACTURER = ?");
             parameters.add(manufacturer);
         }
         if (!type.isEmpty()) {
             sqlBuilder.append(" AND TYPE = ?");
             parameters.add(type);
         }
         String sql = sqlBuilder.toString();
         
         try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
             for (int i = 0; i < parameters.size(); i++) {
                 pstmt.setObject(i + 1, parameters.get(i));
                 }
             try (ResultSet rs = pstmt.executeQuery()) {
                 List<Map<String, Object>> cars = new ArrayList<>();
                 ResultSetMetaData metaData = rs.getMetaData();
                 int columnCount = metaData.getColumnCount();
                 
             while (rs.next()) {
                 Map<String, Object> row = new HashMap<>();
                 for (int i = 1; i <= columnCount; i++) {
                 row.put(metaData.getColumnName(i), rs.getObject(i));
                     }
                     cars.add(row);
                 }
          // Print results
             if (cars.isEmpty()) {
                 System.out.println("沒有符合條件的資料");
             } else {
                 for (Map<String, Object> car : cars) {
                     System.out.println(car);
              }
            }
           }
         }
	}
	private static void insert(Connection connection, Scanner scanner) throws SQLException {

		System.out.println("請輸入製造商:");

		String manufacturer = scanner.nextLine();

		System.out.println("請輸入類型:");

		String type = scanner.nextLine();

		System.out.println("請輸入最低價格:");

		double minPrice = scanner.nextDouble();

		System.out.println("請輸入價格:");

		double price = scanner.nextDouble();

		String sql = "INSERT INTO CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) VALUES (?, ?, ?, ?)";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setString(1, manufacturer);

			pstmt.setString(2, type);

			pstmt.setDouble(3, minPrice);

			pstmt.setDouble(4, price);

			int rowsInserted = pstmt.executeUpdate();

			System.out.println("插入成功, 影響行數: " + rowsInserted);

		}

	}

	private static void update(Connection connection, Scanner scanner) throws SQLException {
		
		System.out.println("請輸入最低價格:");
	    String MINPRICE = scanner.nextLine();

	    System.out.println("請輸入價格:");
	    String PRICE1 = scanner.nextLine() ;
		
		
		System.out.println("請輸入要更新的製造商:");
	    String manufacturer = scanner.nextLine();

	    System.out.println("請輸入要更新的類型:");
	    String type = scanner.nextLine();

	    

		String sql = "UPDATE CARS SET MIN_PRICE=?,PRICE = ? WHERE MANUFACTURER = ? AND TYPE= ? ";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setString(1, MINPRICE);

			pstmt.setString(2, PRICE1);
			
			pstmt.setString(3, manufacturer);
			
			pstmt.setString(4,type );

			int rowsUpdated = pstmt.executeUpdate();

			
			if (rowsUpdated > 0) {
	            System.out.println("更新成功, 影響行數: " + rowsUpdated);
	        } else {
	            System.out.println("沒有找到符合條件的資料來更新");
	        }
		}

	}

	private static void delete(Connection connection, Scanner scanner) throws SQLException {
	    // 提示用戶輸入主鍵值
	    System.out.println("請輸入要刪除的製造商:");
	    String manufacturer = scanner.nextLine().trim();

	    System.out.println("請輸入要刪除的類型:");
	    String type = scanner.nextLine().trim();

	    // 驗證主鍵輸入
	    if (manufacturer.isEmpty() || type.isEmpty()) {
	        System.out.println("製造商和類型不能為空。");
	        return;
	    }

	    // 刪除記錄的 SQL 語句
	    String sql = "DELETE FROM CARS WHERE MANUFACTURER = ? AND TYPE = ?";

	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        // 設置主鍵值
	        pstmt.setString(1, manufacturer); // 設置第一個佔位符
	        pstmt.setString(2, type);          // 設置第二個佔位符

	        // 執行刪除操作
	        int rowsDeleted = pstmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("刪除成功, 影響行數: " + rowsDeleted);
	        } else {
	            System.out.println("沒有找到符合條件的資料來刪除");
	        }
	    } catch (SQLException e) {
	        System.err.println("SQL 錯誤: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}


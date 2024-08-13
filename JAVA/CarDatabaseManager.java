package com.cathaybk.practice.nt00550339.b;

import java.sql.*;

import java.util.*;
import java.util.Scanner;

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

                    query(connection);

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

    
  

    private static void query(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入查詢條件
        System.out.print("請輸入製造商 (Manufacturer): ");
        String manufacturer = scanner.nextLine();

        System.out.print("請輸入類型 (Type): ");
        String type = scanner.nextLine();

        // 使用WHERE子句來查詢特定條件
        String sql = "SELECT * FROM CARS WHERE Manufacturer = ? AND TYPE = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, manufacturer);
            pstmt.setString(2, type);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("找不到符合條件的資料");
                    return;
                }

                // 逐行輸出符合條件的資料
                while (rs.next()) {
                    System.out.println("Manufacturer: " + rs.getString("Manufacturer"));
                    System.out.println("Type: " + rs.getString("Type"));
                    System.out.println("Min.Price: " + rs.getDouble("Min.Price"));
                    System.out.println("Price: " + rs.getDouble("Price"));
                    System.out.println("-------------------------");
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

        System.out.println("請輸入要更新的製造商:");

        String manufacturer = scanner.nextLine();

        System.out.println("請輸入新價格:");

        double newPrice = scanner.nextDouble();



        String sql = "UPDATE CARS SET PRICE = ? WHERE MANUFACTURER = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setDouble(1, newPrice);

            pstmt.setString(2, manufacturer);

            int rowsUpdated = pstmt.executeUpdate();

            System.out.println("更新成功, 影響行數: " + rowsUpdated);

        }

    }



    private static void delete(Connection connection, Scanner scanner) throws SQLException {

        System.out.println("請輸入要刪除的製造商:");

        String manufacturer = scanner.nextLine();



        String sql = "DELETE FROM CARS WHERE MANUFACTURER = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, manufacturer);

            int rowsDeleted = pstmt.executeUpdate();

            System.out.println("刪除成功, 影響行數: " + rowsDeleted);

        }

    }

}
 
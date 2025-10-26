package com.example.buggy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; // Unused import to trigger warning
import java.util.ArrayList;
import java.util.List;

public class App {

    private static String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static String USER = "root"; // Hardcoded credential
    private static String PASS = "password"; // Hardcoded credential

    public static void main(String[] args) {
        App app = new App();
        app.processData("select * from users where name = '" + args[0] + "'");
    }

    // SQL injection vulnerability
    public void processData(String query) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("User: " + name);
            }

            conn.close(); // No finally block for cleanup

        } catch (Exception e) {
            e.printStackTrace(); // Should use proper logging
        }
    }

    public int riskyCalculation(Integer a, Integer b) {
        return a + b; // Potential NPE
    }

    public void inefficientLoop() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(i) + list.get(j)); // Inefficient nested loop
            }
        }
    }
}

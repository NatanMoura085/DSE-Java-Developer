package org.example.TechniquesSQLInjection;

import java.sql.*;

public class DatabaseExample {
    public void queryDatabase(String userInput) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "user", "password");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userInput);  // Previne SQL Injection
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }
}

package org.example.domain.DAO;

import org.example.domain.model.Plant;
import org.example.infrastructure.DatabaseConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PlantDAO {

    private static String url;
    private static String username;
    private static String password;

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo 'application.properties'.");

            }

            Properties properties = new Properties();
            properties.load(input);

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void insertPlant(Plant plant) throws SQLException {
        String query = "INSERT INTO plants (code, description) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, plant.getCode());
            stmt.setString(2, plant.getDescription());
            stmt.executeUpdate();
        }
    }

    public void updatePlant(Plant plant) throws SQLException {
        String query = "UPDATE plants SET description = ? WHERE code = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, plant.getDescription());
            stmt.setInt(2, plant.getCode());
            stmt.executeUpdate();
        }
    }

    public void deletePlant(int code) throws SQLException {
        String query = "DELETE FROM plants WHERE code = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, code);
            stmt.executeUpdate();
        }
    }

    public Plant getPlantByCode(int code) throws SQLException {
        String query = "SELECT * FROM plants WHERE code = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Plant(rs.getInt("code"), rs.getString("description"));
            }
            return null;
        }
    }

    public List<Plant> getAllPlants() throws SQLException {
        List<Plant> plants = new ArrayList<>();
        String query = "SELECT * FROM plants";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                plants.add(new Plant(rs.getInt("code"), rs.getString("description")));
            }
        }
        return plants;
    }
}

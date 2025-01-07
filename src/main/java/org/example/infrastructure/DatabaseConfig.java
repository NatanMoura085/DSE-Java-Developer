package org.example.infrastructure;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {

    // Variáveis para armazenar as configurações do banco de dados
    private static String url;
    private static String username;
    private static String password;

    static {
        // Carregar as propriedades do arquivo application.properties
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

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

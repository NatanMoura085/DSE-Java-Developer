package org.example.infrastructure;

import org.example.domain.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    // Método para salvar um usuário no banco de dados
    public void save(User user) {
        String sql = "INSERT INTO users (name, email, address, phone, isAdmin) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone());
            statement.setBoolean(5, user.isAdmin());  // Garantindo que o valor de isAdmin seja salvo

            statement.executeUpdate(); // Executa a inserção
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para encontrar um usuário pelo ID
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Se o usuário for encontrado, cria o objeto User
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getBoolean("isAdmin") // Agora inclui o campo isAdmin
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    // Método para atualizar um usuário
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, address = ?, phone = ?, isAdmin = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone());
            statement.setBoolean(5, user.isAdmin());  // Garantindo que o valor de isAdmin seja atualizado
            statement.setInt(6, user.getId());

            statement.executeUpdate(); // Executa a atualização
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um usuário
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate(); // Executa a exclusão
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

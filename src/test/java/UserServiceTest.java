import org.example.domain.model.User;
import org.example.domain.service.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testAddUser() {
        UserService service = new UserService();
        User user = new User( 1,"John", "john@example.com", "123 St", "12345",false);
        assertTrue(service.addUser(user));
    }

    @Test
    public void testDeleteUser() {
        UserService service = new UserService();
        User user = new User(2, "Admin", "admin@example.com", "123 St", "12345",true);
        service.addUser(user);
        assertTrue(service.deleteUser("admin@example.com", true));
    }
}
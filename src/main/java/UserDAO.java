import java.util.List;

public interface UserDAO {
    User createUser (User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUserById(User user);
    void addRoleToUser(int idUser, int idRole);
}
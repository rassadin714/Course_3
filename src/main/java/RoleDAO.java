import java.util.List;

public interface RoleDAO {
    void createRole (Role role);
    Role getRoleById(int id);
    List<Role> getAllRoles();
    void updateRoleById(Role role);
    void deleteRoleById(Role role);
    List<User> getRoleUsers(int id);
}

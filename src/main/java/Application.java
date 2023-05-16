import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();
        Scanner scanner = new Scanner(System.in);


        List<User> userList1 = userDAO.getAllUsers();
        System.out.println(userList1);


        System.out.println("Введите id пользователя");
        int id_user = scanner.nextInt();
        User user = userDAO.getUserById(id_user);
        System.out.println(user);


        System.out.println("Введите id роли ");
        int id_role = scanner.nextInt();
        List<User> userList = roleDAO.getRoleUsers(id_role);
        System.out.println(userList);


        System.out.println("Введите id пользователя для удаления");
        id_user = scanner.nextInt();
        User user1 = userDAO.getUserById(id_user);
        userDAO.deleteUserById(user1);
        System.out.println(userDAO.getAllUsers().contains(user1));


        User user2 = new User("Misha", "Michael", "Rassadin", List.of(new Role(1), new Role(2)));
        userDAO.createUser(user1);
        System.out.println(userDAO.getAllUsers().contains(user2));


        System.out.println("Введите id пользователя для редактирования");
        int idUser2 = scanner.nextInt();
        System.out.println("Введите id роли для присвоения пользователю");
        int idRole2 = scanner.nextInt();
        userDAO.addRoleToUser(idUser2, idRole2);
        System.out.println(userDAO.getUserById(idUser2));

    }
}

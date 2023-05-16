import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User createUser(User user) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        user.setDateOfCreating(LocalDateTime.now());
        user.setDateOfChanging(LocalDateTime.now());
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        return user;
    }

    @Override
    public User getUserById(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM User e";
        TypedQuery<User> query = entityManager.createQuery(jpqlQuery, User.class);
        List<User> userList =query.getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        return userList;
    }

    @Override
    public void updateUser(User user) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        User user1 = entityManager.find(User.class, user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setLogin(user.getLogin());
        user1.setPassword(user.getPassword());
        user1.setDateOfChanging(LocalDateTime.now());
        entityManager.merge(user1);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void deleteUserById(User user) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        User user1 = entityManager.find(User.class, user.getUserId());
        entityManager.remove(user1);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

    @Override
    public void addRoleToUser(int idUser, int idRole) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        User user1 = entityManager.find(User.class, idUser);
        Role role1 = entityManager.find(Role.class, idRole);
        user1.getRolesList().add(role1);
        user1.setDateOfChanging(LocalDateTime.now());

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
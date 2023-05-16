import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoleDAOImpl implements RoleDAO{
    @Override
    public void createRole(Role role) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public Role getRoleById(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        Role role = entityManager.find(Role.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        return role;
    }

    public List<User> getRoleUsers(int id){
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        Role role = entityManager.find(Role.class, id);
        List<User> users = role.getUserList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    @Override
    public List<Role> getAllRoles() {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Role e";
        TypedQuery<Role> query = entityManager.createQuery(jpqlQuery, Role.class);
        List<Role> roleList =query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
        return roleList;
    }

    @Override
    public void updateRoleById(Role role) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        Role role1 = entityManager.find(Role.class, role.getRoleId());
        role1.setRoleName(role.getRoleName());
        role1.setUserList(role.getUserList());
        entityManager.merge(role1);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void deleteRoleById(Role role) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        Role role1 = entityManager.find(Role.class, role.getRoleId());
        entityManager.remove(role1);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
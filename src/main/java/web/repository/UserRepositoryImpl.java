package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(String firstName, String lastName) {
        User user = new User(firstName, lastName);
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updated) {
        entityManager.merge(updated);
    }

    @Override
    public void deleteById(Long id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

}





package org.vip.info.dao;

import org.vip.info.model.User;

import java.util.List;
import javax.persistence.EntityManagerFactory;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void createUser(User user) {
        create(user);
    }

    public void removeUser(User user) {
        remove(user);
    }

    public User findUser(long id) {
        return find(id);
    }

    public List<User> findUsers() {
        return findAll(User.class);
    }
}

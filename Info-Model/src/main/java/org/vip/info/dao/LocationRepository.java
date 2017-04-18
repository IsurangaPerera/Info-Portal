package org.vip.info.dao;

import org.vip.info.model.User;

import java.util.List;
import javax.persistence.EntityManagerFactory;

public class LocationRepository extends AbstractRepository {

    public LocationRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void createLocation(Location location) {
        create(location);
    }

    public void removeLocation(Location location) {
        remove(location);
    }

    public User findLocation(long id) {
        return find(id);
    }

    public List<Location> findLocations() {
        return findAll(Location.class);
    }
}
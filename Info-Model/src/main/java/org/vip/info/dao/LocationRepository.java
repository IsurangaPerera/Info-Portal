package org.vip.info.dao;

import org.vip.info.model.Location;

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

    public Location findLocation(long id) {
        return (Location)find(id, Location.class);
    }

    public List<Location> findLocations() {
        return findAll(Location.class);
    }
}
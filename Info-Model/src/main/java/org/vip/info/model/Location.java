package org.vip.info.model;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    private float latitude;

    @Column
    private float longitude;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location", orphanRemoval = true)
    private List<Place> places;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
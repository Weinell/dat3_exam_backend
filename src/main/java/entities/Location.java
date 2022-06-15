package entities;

import dtos.LocationDTO;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@NamedQuery(name = "Location.deleteAllRows", query = "DELETE from Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "condition")
    private Integer condition;



    public Location() {
    }

    public Location(Long id, String address, String city, Integer condition) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.condition = condition;
    }

    public Location(LocationDTO locationDTO) {
        this.address = locationDTO.getAddress();
        this.city = locationDTO.getCity();
        this.condition = locationDTO.getCondition();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

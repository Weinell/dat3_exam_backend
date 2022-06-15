package entities;

import dtos.LocationDTO;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "locations")
@NamedQuery(name = "Location.deleteAllRows", query = "DELETE from Location")
public class Location {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Size(min = 1, max = 255)
    @Column(name = "conditions")
    private Integer conditions;

    public Location() {
    }

    public Location(String address, String city, Integer conditions) {
        this.address = address;
        this.city = city;
        this.conditions = conditions;
    }

    public Location(LocationDTO locationDTO) {
        this.address = locationDTO.getAddress();
        this.city = locationDTO.getCity();
        this.conditions = locationDTO.getConditions();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getConditions() {
        return conditions;
    }

    public void setConditions(Integer conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", condition=" + conditions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(getId(), location.getId()) && Objects.equals(getAddress(), location.getAddress()) && Objects.equals(getCity(), location.getCity()) && Objects.equals(getConditions(), location.getConditions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getCity(), getConditions());
    }
}

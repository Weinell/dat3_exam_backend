package dtos;

import entities.Location;

public class LocationDTO {

    private Long id;
    private String address;
    private String city;
    private Integer conditions;

    public LocationDTO(String address, String city, Integer conditions) {
        this.address = address;
        this.city = city;
        this.conditions = conditions;
    }

    public LocationDTO(Location location)    {
        this.address = location.getAddress();
        this.city = location.getCity();
        this.conditions = location.getConditions();
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

    public void setCondition(Integer conditions) {
        this.conditions = conditions;
    }
}

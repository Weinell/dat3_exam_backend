package dtos;

import entities.Location;

public class LocationDTO {

    private Long id;
    private String address;
    private String city;
    private Integer condition;

    public LocationDTO(String address, String city, Integer condition) {
        this.address = address;
        this.city = city;
        this.condition = condition;
    }

    public LocationDTO(Location location)    {
        this.address = location.getAddress();
        this.city = location.getCity();
        this.condition = location.getCondition();
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

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }
}

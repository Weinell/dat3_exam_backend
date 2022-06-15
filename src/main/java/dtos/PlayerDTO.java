package dtos;

import entities.Player;

public class PlayerDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private Integer status;

    public PlayerDTO(String name, String phone, String email, Integer status) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public PlayerDTO(Player player)  {
        this.name = player.getName();
        this.phone = player.getPhone();
        this.email = player.getEmail();
        this.status = player.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package entities;

import dtos.PlayerDTO;

import javax.persistence.*;

@Entity
@Table(name = "players")
@NamedQuery(name = "Player.deleteAllRows", query = "DELETE from Player")
public class Player {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "status")
    private Integer status;

    public Player() {
    }

    public Player(Long id, String name, String phone, String email, Integer status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Player(PlayerDTO playerDTO) {
        this.name = playerDTO.getName();
        this.phone = playerDTO.getPhone();
        this.email = playerDTO.getEmail();
        this.status = playerDTO.getStatus();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

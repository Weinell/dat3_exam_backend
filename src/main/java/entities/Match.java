package entities;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

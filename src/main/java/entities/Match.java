package entities;

import org.graalvm.compiler.graph.Node;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opponentTeam")
    private String opponentTeam;

    @Column(name = "judge")
    private String judge;

    @Column(name = "type")
    private int type;

    @Column(name = "inDoors")
    private boolean inDoors;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

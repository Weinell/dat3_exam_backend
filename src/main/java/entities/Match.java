package entities;

import org.graalvm.compiler.graph.Node;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "matches")
@NamedQuery(name = "Match.deleteAllRows", query = "DELETE from Match")
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
    private Integer type;

    @Column(name = "inDoors")
    private boolean inDoors;

    public Match() {
    }

    public Match(String opponentTeam, String judge, Integer type, boolean inDoors) {
        this.opponentTeam = opponentTeam;
        this.judge = judge;
        this.type = type;
        this.inDoors = inDoors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean isInDoors() {
        return inDoors;
    }

    public void setInDoors(boolean inDoors) {
        this.inDoors = inDoors;
    }
}

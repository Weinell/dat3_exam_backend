package entities;

import dtos.MatchDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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

    public Match(MatchDTO matchDTO) {
        this.opponentTeam = matchDTO.getOpponentTeam();
        this.judge = matchDTO.getJudge();
        this.type = matchDTO.getType();
        this.inDoors = matchDTO.isInDoors();
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

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", opponentTeam='" + opponentTeam + '\'' +
                ", judge='" + judge + '\'' +
                ", type=" + type +
                ", inDoors=" + inDoors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match = (Match) o;
        return isInDoors() == match.isInDoors() && Objects.equals(getId(), match.getId()) && Objects.equals(getOpponentTeam(), match.getOpponentTeam()) && Objects.equals(getJudge(), match.getJudge()) && Objects.equals(getType(), match.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOpponentTeam(), getJudge(), getType(), isInDoors());
    }
}

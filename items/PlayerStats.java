package informational_systems.course.items;

import jakarta.persistence.*;

@Entity
@Table(name = "playerstats")
public class PlayerStats {

    @EmbeddedId
    private PlayerStatsPK id;

    private Integer wins;
    private Integer loses;

    public PlayerStatsPK getId() {
        return id;
    }

    public void setId(PlayerStatsPK id) {
        this.id = id;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }
}

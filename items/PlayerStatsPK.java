package informational_systems.course.items;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class PlayerStatsPK implements Serializable {

    private Integer playerId;
    private Integer heroId;

    // Getters, Setters, Equals, and HashCode

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }
}
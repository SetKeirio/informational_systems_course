package informational_systems.course.items;

import jakarta.persistence.*;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private Integer damage;
    private Integer heal;
    private Float kda;
    private Integer gpm;
    private Integer xpm;
    private Integer lastHits;
    private Integer deny;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }

    public Float getKda() {
        return kda;
    }

    public void setKda(Float kda) {
        this.kda = kda;
    }

    public Integer getGpm() {
        return gpm;
    }

    public void setGpm(Integer gpm) {
        this.gpm = gpm;
    }

    public Integer getXpm() {
        return xpm;
    }

    public void setXpm(Integer xpm) {
        this.xpm = xpm;
    }

    public Integer getLastHits() {
        return lastHits;
    }

    public void setLastHits(Integer lastHits) {
        this.lastHits = lastHits;
    }

    public Integer getDeny() {
        return deny;
    }

    public void setDeny(Integer deny) {
        this.deny = deny;
    }
}
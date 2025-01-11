package informational_systems.course.items;

import jakarta.persistence.*;

@Entity
@Table(name = "herowithwinrate")
public class HeroWithWinRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hero1_id")
    private Hero hero1;

    @ManyToOne
    @JoinColumn(name = "hero2_id")
    private Hero hero2;

    private Integer position1;
    private Integer position2;
    private Float winrate;
    private Integer matches;
    private Integer wins;
    private Integer loses;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hero getHero1() {
        return hero1;
    }

    public void setHero1(Hero hero1) {
        this.hero1 = hero1;
    }

    public Hero getHero2() {
        return hero2;
    }

    public void setHero2(Hero hero2) {
        this.hero2 = hero2;
    }

    public Integer getPosition1() {
        return position1;
    }

    public void setPosition1(Integer position1) {
        this.position1 = position1;
    }

    public Integer getPosition2() {
        return position2;
    }

    public void setPosition2(Integer position2) {
        this.position2 = position2;
    }

    public Float getWinrate() {
        return winrate;
    }

    public void setWinrate(Float winrate) {
        this.winrate = winrate;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
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
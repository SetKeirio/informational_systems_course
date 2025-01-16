package informational_systems.course.items;

public class HeroWinRateResponse {

    private String heroName;
    private Integer position;
    private Integer matches;
    private Float winrate;
    private String patch;

    // Конструктор
    public HeroWinRateResponse(String heroName, Integer position, Integer matches, Float winrate, String patch) {
        this.heroName = heroName;
        this.position = position;
        this.matches = matches;
        this.winrate = winrate;
        this.patch = patch;
    }

    // Getters and Setters
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Float getWinrate() {
        return winrate;
    }

    public void setWinrate(Float winrate) {
        this.winrate = winrate;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }
}
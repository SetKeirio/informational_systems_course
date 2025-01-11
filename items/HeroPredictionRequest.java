package informational_systems.course.items;

import java.util.List;

public class HeroPredictionRequest {
    private List<Integer> radiantHeroes;
    private List<Integer> radiantPositions;
    private List<Integer> direHeroes;
    private List<Integer> direPositions;

    // Геттеры и сеттеры
    public List<Integer> getRadiantHeroes() {
        return radiantHeroes;
    }

    public void setRadiantHeroes(List<Integer> radiantHeroes) {
        this.radiantHeroes = radiantHeroes;
    }

    public List<Integer> getRadiantPositions() {
        return radiantPositions;
    }

    public void setRadiantPositions(List<Integer> radiantPositions) {
        this.radiantPositions = radiantPositions;
    }

    public List<Integer> getDireHeroes() {
        return direHeroes;
    }

    public void setDireHeroes(List<Integer> direHeroes) {
        this.direHeroes = direHeroes;
    }

    public List<Integer> getDirePositions() {
        return direPositions;
    }

    public void setDirePositions(List<Integer> direPositions) {
        this.direPositions = direPositions;
    }
}
package informational_systems.course.services;

import informational_systems.course.items.Match;
import informational_systems.course.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    // Получить все матчи
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    // Получить матч по ID
    public Match getMatchById(Integer id) {
        return matchRepository.findById(id).orElse(null);
    }

    // Создать новый матч
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    // Обновить матч
    public Match updateMatch(Integer id, Match matchDetails) {
        Match match = matchRepository.findById(id).orElse(null);
        if (match != null) {
            match.setHero1(matchDetails.getHero1());
            match.setHero2(matchDetails.getHero2());
            match.setHero3(matchDetails.getHero3());
            match.setHero4(matchDetails.getHero4());
            match.setHero5(matchDetails.getHero5());
            match.setHero6(matchDetails.getHero6());
            match.setHero7(matchDetails.getHero7());
            match.setHero8(matchDetails.getHero8());
            match.setHero9(matchDetails.getHero9());
            match.setHero10(matchDetails.getHero10());
            match.setPlayer1(matchDetails.getPlayer1());
            match.setPlayer2(matchDetails.getPlayer2());
            match.setPlayer3(matchDetails.getPlayer3());
            match.setPlayer4(matchDetails.getPlayer4());
            match.setPlayer5(matchDetails.getPlayer5());
            match.setPlayer6(matchDetails.getPlayer6());
            match.setPlayer7(matchDetails.getPlayer7());
            match.setPlayer8(matchDetails.getPlayer8());
            match.setPlayer9(matchDetails.getPlayer9());
            match.setPlayer10(matchDetails.getPlayer10());
            // Повторить для других полей, если необходимо
            return matchRepository.save(match);
        }
        return null;
    }

    // Удалить матч
    public void deleteMatch(Integer id) {
        matchRepository.deleteById(id);
    }

    public Match addMatch(Match match) {
        return matchRepository.save(match);
    }
}

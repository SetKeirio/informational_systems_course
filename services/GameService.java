package informational_systems.course.services;

import informational_systems.course.items.Game;
import informational_systems.course.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Integer id) {
        return gameRepository.findById(id).orElse(null);
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }
}
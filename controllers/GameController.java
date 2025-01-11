package informational_systems.course.controllers;

import informational_systems.course.items.Game;
import informational_systems.course.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    // Получить все игры
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    // Получить игру по ID
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Integer id) {
        return gameService.getGameById(id);
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game newGame = gameService.addGame(game);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }
}

package informational_systems.course.services;

import informational_systems.course.items.Player;
import informational_systems.course.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // Получить всех игроков
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Получить игрока по ID
    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id).orElse(null);
    }

    // Создать нового игрока
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Обновить игрока
    public Player updatePlayer(Integer id, Player playerDetails) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setName(playerDetails.getName());
            player.setRating(playerDetails.getRating());
            player.setWins(playerDetails.getWins());
            player.setLoses(playerDetails.getLoses());
            return playerRepository.save(player);
        }
        return null;
    }

    // Удалить игрока
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }
}

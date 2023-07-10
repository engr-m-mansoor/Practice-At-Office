package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public ResponseEntity<Player> registerPlayer(ModelPlayer modelPlayer) {
        try {
            if (playerRepository.findPlayerByPhoneNumber(modelPlayer.getPhoneNumber()) != null || playerRepository.findPlayerById(modelPlayer.getId()) != null) {
                throw new Exception();
            } else {
                Player player = new Player(modelPlayer);
                playerRepository.save(player);
                return ResponseEntity.ok(player);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    public ResponseEntity<Player> getPlayerProfile(ModelPlayer  modelPlayer) {
        try {
            if (playerRepository.getPlayerById(modelPlayer.getId()) != null) {
                Player player = new Player();
                player=playerRepository.getPlayerById(modelPlayer.getId());
                return ResponseEntity.ok(player);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new Player("Player not found")); // Create a custom Player object with the error message
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

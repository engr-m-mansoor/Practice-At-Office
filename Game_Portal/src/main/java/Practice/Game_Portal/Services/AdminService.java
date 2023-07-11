package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    PlayerRepository playerRepository;

    public ResponseEntity<List<Player>> getAllProfiles() {
        try {
            if (playerRepository.findAll() == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                List <Player> allPlayers = playerRepository.findAll();
                return ResponseEntity.status(HttpStatus.OK).body(allPlayers);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public  ResponseEntity<Player> updatePlayerById(Long playerId, ModelPlayer modelPlayer) {
            try {
                if (playerRepository.findPlayerById(playerId) == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(null);
                } else {
                    Player player = new Player();
                    player=playerRepository.getPlayerById(playerId);
                    player.setName(modelPlayer.getName());
                    player.setAge(modelPlayer.getAge());
                    player.setPhoneNumber(modelPlayer.getPhoneNumber());
                    player.setUserName(modelPlayer.getUserName());
                    player.setPassword(modelPlayer.getPassword());
                    playerRepository.save(player);
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(null);
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }


}

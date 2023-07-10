package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerRepository playerRepository;

//    public ResponseEntity<Player> getPlayerProfile(Long playerId) {
//        try {
//            Player player = playerRepository.getPlayerById(playerId);
//            if (player != null) {
//                return ResponseEntity.ok(player);
//            } else {
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            return (ResponseEntity<Player>) ResponseEntity.status(HttpStatus.NO_CONTENT);
//        }
//    }



    public String updatePlayerProfile(Long playerId, ModelPlayer modelPlayer) {
        try
        {
            Player player= new Player();
            player=playerRepository.getPlayerById(playerId);
            player.setName(modelPlayer.getName());
            player.setAge(modelPlayer.getAge());
            player.setPhoneNumber(modelPlayer.getPhoneNumber());
            playerRepository.save(player);
            return "Profile Updated";
        }
        catch(Exception e) {
            return "Error updating player profile";
        }

    }
}

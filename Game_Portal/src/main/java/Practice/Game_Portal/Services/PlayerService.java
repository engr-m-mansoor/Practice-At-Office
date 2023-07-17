package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class PlayerService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    PlayerRepository playerRepository;

    public ResponseEntity<Player> registerPlayer(ModelPlayer modelPlayer) {
        try {
            if (playerRepository.findPlayerByPhoneNumber(modelPlayer.getPhoneNumber()) != null || playerRepository.findPlayerById(modelPlayer.getId()) != null || playerRepository.findPlayerByUserName(modelPlayer.getUserName())!= null) {
                return ResponseEntity.badRequest().build();
            } else {
                String encodedPassword = passwordEncoder.encode(modelPlayer.getPassword());
                Player player = new Player(modelPlayer,encodedPassword);
                playerRepository.save(player);
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Player> getPlayerProfile(ModelPlayer  modelPlayer) {
        try {
            if (playerRepository.getPlayerById(modelPlayer.getId()) != null ) {
                Player player = new Player();
                player=playerRepository.getPlayerById(modelPlayer.getId());
                return ResponseEntity.status(HttpStatus.OK).body(player);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Player> updatePlayer(ModelPlayer modelPlayer) {
        try {
            if (playerRepository.findPlayerByPhoneNumber(modelPlayer.getPhoneNumber()) == null || playerRepository.findPlayerById(modelPlayer.getId()) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            } else {
                Player player = new Player();
                player=playerRepository.getPlayerById(modelPlayer.getId());
                player.setName(modelPlayer.getName());
                player.setAge(modelPlayer.getAge());
                player.setPhoneNumber(modelPlayer.getPhoneNumber());
                player.setUserName(modelPlayer.getUserName());
                player.setPassword(modelPlayer.getPassword());
                playerRepository.save(player);
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

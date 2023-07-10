package Practice.Game_Portal.NewControllers;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1")
public class PlayerControllerAPIs {
    @Autowired
    PlayerService playerService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerPlayer(@RequestBody ModelPlayer modelPlayer) {
        ResponseEntity<Player> response = playerService.registerPlayer(modelPlayer);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Successfully registered");
        } else {
            return ResponseEntity.badRequest().body("User Already Exists");
        }
    }
    @GetMapping(path="/profile")
    public ResponseEntity<Player> getPlayerProfileById(@RequestBody ModelPlayer modelPlayer) {
        ResponseEntity<Player> response = playerService.getPlayerProfile(modelPlayer);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Player("Player not found"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//    @PutMapping(path = "/profile")
//    public String updatePlayer(@RequestBody ModelPlayer modelPlayer) {
//        return playerService.updatePlayer(modelPlayer);
//    }
//
//    @GetMapping(path="/games")
//    public ResponseEntity<Player> getPlayerGames(@RequestBody ModelPlayer modelPlayer) {
//        ResponseEntity<Player> response = playerService.getPlayerProfile(modelPlayer.getId());
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return ResponseEntity.ok(response.getBody());
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//
//    @PostMapping(path="/games{gameId}")
//    public ResponseEntity<Player> joinAGame(@RequestBody ModelPlayer modelPlayer) {
//        ResponseEntity<Player> response = playerService.getPlayerProfile(modelPlayer.getId());
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return ResponseEntity.ok(response.getBody());
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//    @GetMapping(path="/games{gameId}/result")
//    public ResponseEntity<Player> joinAGame(@RequestBody ModelPlayer modelPlayer) {
//        ResponseEntity<Player> response = playerService.getPlayerProfile(modelPlayer.getId());
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return ResponseEntity.ok(response.getBody());
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//
}

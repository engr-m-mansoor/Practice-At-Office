package Practice.Game_Portal.ControllersAPI;

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

    // 1. localhost:8080/api/v1/register [POST]
    @PostMapping(path = "/register")
    public ResponseEntity<String> registerPlayer(@RequestBody ModelPlayer modelPlayer) {
        ResponseEntity<Player> response = playerService.registerPlayer(modelPlayer);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Successfully registered");
        } else {
            return ResponseEntity.badRequest().body("User Already Exists");
        }
    }
    // 3. localhost:8080/api/v1/profile [GET]
    @GetMapping(path = "/profile")
    public ResponseEntity<Player> getPlayerProfileById(@RequestBody ModelPlayer modelPlayer) {
        ResponseEntity<Player> response = playerService.getPlayerProfile(modelPlayer);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//  4. localhost:8080/api/v1/profile [PUT]
    @PutMapping(path = "/profile")
    public ResponseEntity<String> updatePlayer(@RequestBody ModelPlayer modelPlayer) {
        ResponseEntity<Player> response = playerService.updatePlayer(modelPlayer);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Player successfully updated");
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Player not found");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

package Practice.Game_Portal.NewControllers;

import Practice.Game_Portal.Entities.Game;
import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelGame;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class GameControllerAPI {

    @Autowired
    GameService gameService;
    @GetMapping(path="/games")
    public ResponseEntity<List<Game>> getAllProfiles() {
        ResponseEntity<List<Game>> response = gameService.getAllGames();
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 9. localhost:8080/admin/games [POST]
    @PostMapping(path = "/admin/games")
    public ResponseEntity<String> createGame(@RequestBody ModelGame modelGame) {
        ResponseEntity<Game> response = gameService.createGame(modelGame);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Successfully created");
        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            return ResponseEntity.badRequest().body("Game Already Exists");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // 10. localhost:8080/admin/games/{gameId} [PUT]
    @PutMapping(path="/admin/games/{gameId}")
    public ResponseEntity<String> updateGame(@PathVariable Long gameId, @RequestBody ModelGame modelGame) {
        ResponseEntity<Game> response = gameService.updateGame(gameId,modelGame);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Game successfully updated");
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Game not found");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // 11. localhost:8080/admin/games/{gameId} [DELETE]
    @DeleteMapping(path="/admin/games/{gameId}")
    public ResponseEntity<String> deleteGame(@PathVariable Long gameId) {
        ResponseEntity<Game> response = gameService.deleteGame(gameId);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Game successfully deleted");
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Game not found");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

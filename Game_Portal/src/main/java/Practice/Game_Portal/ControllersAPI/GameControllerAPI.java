package Practice.Game_Portal.ControllersAPI;

import Practice.Game_Portal.Entities.Game;
import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Entities.Result;
import Practice.Game_Portal.Model.ModelGame;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Services.GameService;
import Practice.Game_Portal.Services.ResultService;
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
    @Autowired
    ResultService resultService;

    //7. localhost:8080/api/v1/games [GET]
    @GetMapping(path="/games")
    public ResponseEntity<List<Game>> getAllGames() {
        ResponseEntity<List<Game>> response = gameService.getAllGames();
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 9. localhost:8080/api/v1/admin/games [POST]
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
    // 10. localhost:8080/api/v1/admin/games/{gameId} [PUT]
    @PutMapping(path="/admin/games/{gameId}")
    public ResponseEntity<String> updateGame(@PathVariable Long gameId, @RequestBody ModelGame modelGame) {
        ResponseEntity<Game> response = gameService.updateGame(gameId,modelGame);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body("Game successfully updated");
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Game not found");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // 11. localhost:8080/ap1/v1/admin/games/{gameId} [DELETE]
    @DeleteMapping(path="/admin/games/{gameId}")
    public ResponseEntity<String> deleteGame(@PathVariable Long gameId) {
        ResponseEntity<Game> response = gameService.deleteGame(gameId);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body("Game successfully deleted");
        } else if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Game not found");

        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //12. localhost:8080/api/v1/games/{gameId}/results [GET]
    @GetMapping(path="games/{gameId}/results")
    public ResponseEntity<Result> getPlayerResults(@PathVariable Long gameId, @RequestBody ModelPlayer modelPlayer) {

        ResponseEntity<Result> response = resultService.getPlayerResults(gameId,modelPlayer);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        } else if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .build();
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //13. localhost:8080/api/v1/admin/games/{gameId}/results [GET]
    @GetMapping(path="/admin/games/{gameId}/results")
    public ResponseEntity<Result> getGameResults(@PathVariable Long gameId) {

        ResponseEntity<Result> response = resultService.getGameResults(gameId);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .build();
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

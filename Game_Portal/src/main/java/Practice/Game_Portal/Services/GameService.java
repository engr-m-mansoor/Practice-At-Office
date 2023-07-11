package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Game;
import Practice.Game_Portal.Model.ModelGame;
import Practice.Game_Portal.Repositories.GameRepository;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

public ResponseEntity<List<Game>> getAllGames() {
            try {
                if (playerRepository.findAll() == null) {
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                } else {
                    List<Game> allGames= gameRepository.findAll();
                    return ResponseEntity.status(HttpStatus.OK).body(allGames);
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

    public ResponseEntity<Game> createGame(ModelGame modelGame) {
            try {
                if (gameRepository.findGameByName(modelGame.getName()) != null) {
                    return ResponseEntity.badRequest().build();
                } else {
                    Game game = new Game (modelGame);
                    gameRepository.save(game);
                    return ResponseEntity.ok().build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
     }
         public ResponseEntity<Game> updateGame(Long gameId, ModelGame modelGame) {
            try {
                if (gameRepository.findById(gameId) == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(null);
                } else {
                    Game game = new Game();
                    game=gameRepository.findGameById(gameId);
                    game.setName(modelGame.getName());
                    gameRepository.save(game);
                    return ResponseEntity.ok().build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

    public ResponseEntity<Game> deleteGame(Long gameId) {
        try {
            if (gameRepository.findById(gameId) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            } else {
                Game game = new Game();
                game=gameRepository.findGameById(gameId);
                gameRepository.delete(game);
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}



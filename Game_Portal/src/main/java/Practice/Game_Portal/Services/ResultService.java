package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Result;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Repositories.GameRepository;
import Practice.Game_Portal.Repositories.PlayerRepository;
import Practice.Game_Portal.Repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    ResultRepository resultRepository;

    @Autowired
    GameRepository gameRepository;

    public ResponseEntity<Result> getPlayerResults(Long gameId, ModelPlayer modelPlayer) {
        if(playerRepository.getPlayerById(modelPlayer.getId())==null)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else if (gameRepository.findById(gameId)==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            return ResponseEntity.status(HttpStatus.OK).body(resultRepository.findResultByGameId(gameId));
        }
    }
}

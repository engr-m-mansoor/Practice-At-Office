package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Result;
import Practice.Game_Portal.Repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameResultsService {

    Result result = null;
    @Autowired
    ResultRepository resultRepository;

    public String getGameResultsByGameId(Long gameId) {

        return resultRepository.findResultByGameId(gameId).toString();
    }
}

package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Game;
import Practice.Game_Portal.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListOfGamesService {

    @Autowired
    GameRepository gameRepository;
    public String getListOfGames() {
        try
        {
            return gameRepository.findAll().toString();
        }
        catch(Exception e)
        {
            return "No Games available";
        }
    }
}

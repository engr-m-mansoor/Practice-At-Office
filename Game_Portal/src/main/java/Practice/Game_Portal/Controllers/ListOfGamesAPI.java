package Practice.Game_Portal.Controllers;

import Practice.Game_Portal.Entities.Game;
import Practice.Game_Portal.Services.ListOfGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1")
public class ListOfGamesAPI {

    @Autowired
    ListOfGamesService listOfGamesService;

    @GetMapping(path="/games")
    public String getListOfGames() {
        return listOfGamesService.getListOfGames();
    }
}


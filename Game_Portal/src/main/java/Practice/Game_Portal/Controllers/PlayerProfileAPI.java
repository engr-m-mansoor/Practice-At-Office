package Practice.Game_Portal.Controllers;

import Practice.Game_Portal.Services.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path="/api/v1")
public class PlayerProfileAPI {

    @Autowired
    PlayerProfileService playerProfileService;

    @GetMapping(path="/profile{playerId}")
    public String getPlayerProfileById(@PathVariable("playerId") Long playerId){

        return playerProfileService.getPlayerProfile(playerId);
    }
}

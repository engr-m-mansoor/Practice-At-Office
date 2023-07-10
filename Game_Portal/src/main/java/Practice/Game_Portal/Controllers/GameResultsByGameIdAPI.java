//package Practice.Game_Portal.Controllers;
//
//import Practice.Game_Portal.Services.GameResultsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1")
//public class GameResultsByGameIdAPI {
//    @Autowired
//    GameResultsService gameResultsService;
//
//    @GetMapping("/games/{game-id}/results")
//    public String gameResultsByGameId(@PathVariable("game-id") Long gameId) {
//        return gameResultsService.getGameResultsByGameId(gameId);
//    }
//}

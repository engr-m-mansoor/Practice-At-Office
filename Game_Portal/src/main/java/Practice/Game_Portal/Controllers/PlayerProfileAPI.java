//package Practice.Game_Portal.Controllers;
//
//import Practice.Game_Portal.Entities.Player;
//import Practice.Game_Portal.Model.ModelPlayer;
//import Practice.Game_Portal.Services.PlayerProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping (path="/api/v1")
//public class PlayerProfileAPI {
//
//    @Autowired
//    PlayerProfileService playerProfileService;
//
//
//    @GetMapping("/profile/{playerId}")
//    public ResponseEntity<Player> getPlayerProfileById(@PathVariable("playerId") Long playerId) {
//        ResponseEntity<Player> response = playerProfileService.getPlayerProfile(playerId);
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return ResponseEntity.ok(response.getBody());
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//    @PutMapping(path="/profile/{playerId}")
//    public String updatePlayerProfile(@PathVariable("playerId") Long playerId, ModelPlayer modelPlayer){
//        return playerProfileService.updatePlayerProfile(playerId, modelPlayer);
//    }
//
//    @GetMapping(path="/")
//    public Player getPlayerProfileAbcById_(){
//        System.out.println("+++++++++++++++ProfileAPI");
//        return new Player();
//    }
//
//}

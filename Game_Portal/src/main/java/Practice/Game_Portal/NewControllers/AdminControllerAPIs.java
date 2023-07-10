//package Practice.Game_Portal.NewControllers;
//
//import Practice.Game_Portal.Entities.Player;
//import Practice.Game_Portal.Model.ModelPlayer;
//import Practice.Game_Portal.Services.PlayerService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(path="/api/v1/admin")
//public class AdminControllerAPIs {
//
//    @GetMapping(path="/profile")
//    public ResponseEntity<Player> getPlayerProfileById(@RequestBody ModelPlayer modelPlayer) {
//        PlayerService playerService;
//        ResponseEntity<Player> response = playerService.getPlayerProfile(modelPlayer.getId());
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return ResponseEntity.ok(response.getBody());
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//}

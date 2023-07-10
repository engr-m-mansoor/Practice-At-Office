//package Practice.Game_Portal.Controllers;
//
//import Practice.Game_Portal.Entities.Player;
//import Practice.Game_Portal.Model.ModelPlayer;
//import Practice.Game_Portal.Services.PlayerRegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/api/v1")
//public class PlayerRegisterAPI {
//    @Autowired
//    PlayerRegistrationService playerRegistrationService;
//    @PostMapping( path = "/register")
//    public String registerPlayer(@RequestBody ModelPlayer model) {
//        return playerRegistrationService.registerPlayer(model);
//
//    }
//    @GetMapping(path="/abc")
//    public Player getPlaye_(){
//        System.out.println("+++++++++++++++=================RegisterAPI");
//        return new Player();
//    }
//}

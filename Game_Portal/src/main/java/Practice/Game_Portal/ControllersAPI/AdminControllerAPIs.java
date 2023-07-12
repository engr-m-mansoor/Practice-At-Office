package Practice.Game_Portal.ControllersAPI;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/admin")
public class AdminControllerAPIs {
@Autowired
AdminService adminService;

    //5. localhost:8080/api/v1/admin/profiles [GET]
    @GetMapping(path="/profiles")
    public ResponseEntity<List<Player>> getAllProfiles() {
        ResponseEntity<List<Player>> response = adminService.getAllProfiles();
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //6. localhost:8080/api/v1/admin/profiles/{playerId} [PUT]
    @PutMapping(path = "/profiles/{playerid}")
    public ResponseEntity<String> updatePlayer(@PathVariable("playerid") Long playerId, @RequestBody ModelPlayer modelPlayer) {
        ResponseEntity<Player> response = adminService.updatePlayerById(playerId, modelPlayer);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body("Player successfully updated");
        } else if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Player not found");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

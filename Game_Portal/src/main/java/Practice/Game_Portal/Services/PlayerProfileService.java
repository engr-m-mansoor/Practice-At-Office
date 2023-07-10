package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileService {

    Player player=new Player();
    @Autowired
    PlayerRepository playerRepository;
    public String getPlayerProfile(Long playerId) {
        return playerRepository.findById(playerId).toString();
//        return player.getName()+"/n"+ player.getId();
    }
}

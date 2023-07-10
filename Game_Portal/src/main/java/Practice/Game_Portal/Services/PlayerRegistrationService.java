package Practice.Game_Portal.Services;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Model.ModelPlayer;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerRegistrationService
{
    @Autowired
    PlayerRepository playerRepository;
    public String registerPlayer(ModelPlayer model) {
        try {
            if (playerRepository.findPlayerByPhoneNumber(model.getPhoneNumber()) != null || playerRepository.findPlayerById(model.getId()) != null)
            {
            throw new Exception();
        }
        else
        {
            Player player = new Player(model);
            playerRepository.save(player);
            return "Registeration Successfull.";
        }
    }
        catch (Exception e) {
            return "Sorry the player already exist";
        }
    }
}

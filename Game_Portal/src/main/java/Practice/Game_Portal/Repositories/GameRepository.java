package Practice.Game_Portal.Repositories;

import Practice.Game_Portal.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    Game findGameByName(String name);

    Game findGameById(Long gameId);


}

package Practice.Game_Portal.Repositories;

import Practice.Game_Portal.Entities.Player;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>
{
    Player getPlayerById(Long id);

    Player findPlayerByPhoneNumber(Long phoneNumber);

    Player findPlayerById(Long id);

    Player findPlayerByUserName(String userName);
}

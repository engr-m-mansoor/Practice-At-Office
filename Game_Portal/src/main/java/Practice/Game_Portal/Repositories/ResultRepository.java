package Practice.Game_Portal.Repositories;

import Practice.Game_Portal.Entities.Result;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {

   Result findResultByGameId(Long gameId);
}

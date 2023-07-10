package Practice.Game_Portal.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "wiiner_id")
    private Long winnerId;

    @Column(name = "looser_id")
    private Long looserId;
}

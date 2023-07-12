package Practice.Game_Portal.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Game game;

    @Column(name = "winner_id")
    private Long winnerId;

    @Column(name = "looser_id")
    private Long looserId;
}

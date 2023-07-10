package Practice.Game_Portal.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "game_id")
    private Long id;

    @Column (name = "game_name")
    private String name;
}

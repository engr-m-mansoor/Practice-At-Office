package Practice.Game_Portal.Entities;

import Practice.Game_Portal.Model.ModelGame;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "game_id")
    private Long id;

    @Column (name = "game_name")
    private String name;
    public Game(ModelGame modelGame)
    {
        this.name = modelGame.getName();
    }
    public Game()
    {}

}

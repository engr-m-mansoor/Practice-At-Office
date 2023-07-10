package Practice.Game_Portal.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "age")
    private int age;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;
}

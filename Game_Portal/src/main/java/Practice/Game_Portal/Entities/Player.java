package Practice.Game_Portal.Entities;

import Practice.Game_Portal.Model.ModelPlayer;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "age")
    private int age;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
    public Player(ModelPlayer model,String encodedPassword) {
        name=model.getName();
        phoneNumber=model.getPhoneNumber();
        age=model.getAge();
        userName=model.getUserName();

        password=encodedPassword;
    }

    public Player() {

    }
}

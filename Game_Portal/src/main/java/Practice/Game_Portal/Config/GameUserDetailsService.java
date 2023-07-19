package Practice.Game_Portal.Config;

import Practice.Game_Portal.Entities.Player;
import Practice.Game_Portal.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameUserDetailsService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorities;
        Player player =  playerRepository.findPlayerByUserName(username);
        if (player == null) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else{
            userName = player.getUserName();
            password = player.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(player.toString()));
        }
        return new User(username,password,authorities);
    }

}

package Practice.Game_Portal.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("api/v1/admin/profiles",
                                "api/v1/profile",
                                "api/v1/admin/profiles/{playerId}",
                                "api/v1/games",
                                "api/v1/admin/games",
                                "api/v1/admin/games/{gameId}",
                                "api/v1/games/{gameId}/results",
                                "api/v1/admin/games/{gameId}/results").authenticated()
                        .requestMatchers("api/v1/register").permitAll())

                .httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    }





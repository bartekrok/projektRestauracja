package projektRestauracja.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/beverage_list","/burger_list","/employee_list","/zarzadzanie/foodtruck_list","/foodtruckbeverage_list","/foodtruckburger_list","/foodtrucksides_list","/sides_list","/new_employee","/new_foodtruck","/new_foodtruckbeverage","/new_foodtruckburger","/new_foodtrucksides","/new_sides", "/edit_beverage/**", "/new_beverage", "/edit_burger/**", "/new_burger", "/edit_employee/**")
                        .authenticated()
                        .anyRequest().permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/foodtruck_list")
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Update this if needed
                        .loginProcessingUrl("/login")  // Update this to match your form action
                        .defaultSuccessUrl("/zarzadzanie/foodtruck_list")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("bartekkierownik")
                .password("$2y$10$69spfiVfvE2TTx83aibCmuhzVTJMv5NM3jqJjDAeN9F6aM0cVmdD2")
                .roles("USER","ADMIN")
                .build();
        UserDetails user2 = User.builder()
                .username("pracownik1")
                .password("$2y$10$69spfiVfvE2TTx83aibCmuhzVTJMv5NM3jqJjDAeN9F6aM0cVmdD2")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

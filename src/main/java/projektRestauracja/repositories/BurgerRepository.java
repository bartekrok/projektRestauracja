package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.Beverage;
import projektRestauracja.models.Burger;

import java.util.List;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
    List<Burger> findByOrderByDescriptionDesc();
}

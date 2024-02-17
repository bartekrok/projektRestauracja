package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.FoodTruckBurger;
import projektRestauracja.models.Sides;

import java.util.List;

public interface SidesRepository extends JpaRepository<Sides, Long> {
    List<Sides> findByOrderByDescription();
}

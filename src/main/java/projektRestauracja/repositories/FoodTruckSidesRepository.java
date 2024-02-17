package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.FoodTruckBurger;
import projektRestauracja.models.FoodTruckSides;

import java.util.List;

public interface FoodTruckSidesRepository extends JpaRepository<FoodTruckSides, Long> {
    List<FoodTruckSides> findByOrderById();
}

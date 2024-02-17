package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.FoodTruck;
import projektRestauracja.models.FoodTruckBurger;

import java.util.List;

public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
    List<FoodTruck> findByOrderByName();
}

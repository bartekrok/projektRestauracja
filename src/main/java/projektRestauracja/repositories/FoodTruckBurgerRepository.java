package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.FoodTruckBeverage;
import projektRestauracja.models.FoodTruckBurger;

import java.util.List;

public interface FoodTruckBurgerRepository extends JpaRepository<FoodTruckBurger, Long> {
    List<FoodTruckBurger> findByOrderById();

}

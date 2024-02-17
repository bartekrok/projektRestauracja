package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.Employee;
import projektRestauracja.models.FoodTruckBeverage;

import java.util.List;

public interface FoodTruckBeverageRepository extends JpaRepository<FoodTruckBeverage, Long> {


    List<FoodTruckBeverage> findByOrderById();


}

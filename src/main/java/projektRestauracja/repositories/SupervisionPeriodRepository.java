package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.FoodTruckBurger;
import projektRestauracja.models.SupervisionPeriod;

import java.util.List;

public interface SupervisionPeriodRepository extends JpaRepository<SupervisionPeriod,Long> {
    List<SupervisionPeriod> findByOrderByIdSupervision();
}

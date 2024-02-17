package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projektRestauracja.models.Beverage;

import java.util.List;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long> {


    List<Beverage> findByOrderByDescriptionDesc();


}

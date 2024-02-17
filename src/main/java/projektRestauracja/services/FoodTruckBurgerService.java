package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.Beverage;
import projektRestauracja.models.FoodTruckBurger;
import projektRestauracja.repositories.BeverageRepository;
import projektRestauracja.repositories.FoodTruckBurgerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodTruckBurgerService {
    @Autowired
    private FoodTruckBurgerRepository repository;
    public FoodTruckBurgerService() {
        super();
    }

    public <S extends FoodTruckBurger> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<FoodTruckBurger> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }


    public List<FoodTruckBurger> findAll() {
        return repository.findByOrderById();
    }
}

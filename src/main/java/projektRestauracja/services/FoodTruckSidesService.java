package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.FoodTruckSides;
import projektRestauracja.repositories.FoodTruckBurgerRepository;
import projektRestauracja.repositories.FoodTruckSidesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodTruckSidesService {
    @Autowired
    private FoodTruckSidesRepository repository;
    public FoodTruckSidesService() {
        super();
    }

    public <S extends FoodTruckSides> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<FoodTruckSides> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }


    public List<FoodTruckSides> findAll() {
        return repository.findByOrderById();
    }
}

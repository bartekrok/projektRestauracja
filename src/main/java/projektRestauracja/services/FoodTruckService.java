package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.FoodTruck;
import projektRestauracja.repositories.FoodTruckBurgerRepository;
import projektRestauracja.repositories.FoodTruckRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodTruckService {
    @Autowired
    private FoodTruckRepository repository;
    public FoodTruckService() {
        super();
    }

    public <S extends FoodTruck> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<FoodTruck> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }


    public List<FoodTruck> findAll() {
        return repository.findByOrderByName();
    }
}

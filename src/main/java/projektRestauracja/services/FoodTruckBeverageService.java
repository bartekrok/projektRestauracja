package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.FoodTruckBeverage;
import projektRestauracja.models.FoodTruckBeverage;
import projektRestauracja.repositories.FoodTruckBeverageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodTruckBeverageService {
    @Autowired
    private FoodTruckBeverageRepository repository;
    public <S extends FoodTruckBeverage> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<FoodTruckBeverage> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }


    public List<FoodTruckBeverage> findAll() {
        return repository.findByOrderById();
    }

}

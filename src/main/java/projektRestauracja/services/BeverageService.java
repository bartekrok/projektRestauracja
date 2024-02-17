package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.Beverage;
import projektRestauracja.repositories.BeverageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BeverageService {
    @Autowired
    private BeverageRepository repository;
    public BeverageService() {
        super();
    }

    public <S extends Beverage> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Beverage> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }


    public List<Beverage> findAll() {
        return repository.findByOrderByDescriptionDesc();
    }
}

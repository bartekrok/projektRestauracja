package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.Burger;
import projektRestauracja.repositories.BeverageRepository;
import projektRestauracja.repositories.BurgerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {
    @Autowired
    private BurgerRepository repository;
    public BurgerService() {
        super();
    }

    public <S extends Burger> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Burger> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }


    public List<Burger> findAll() {
        return repository.findByOrderByDescriptionDesc();
    }
}

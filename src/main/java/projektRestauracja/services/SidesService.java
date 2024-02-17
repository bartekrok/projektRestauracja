package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.Sides;
import projektRestauracja.repositories.SidesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SidesService {

    @Autowired
    private SidesRepository repository;
    public SidesService() {
        super();
    }

    public <S extends Sides> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Sides> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public List<Sides> findAll() {
        return repository.findByOrderByDescription();
    }
}

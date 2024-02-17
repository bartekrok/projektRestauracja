package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.Sides;
import projektRestauracja.models.SupervisionPeriod;
import projektRestauracja.repositories.SidesRepository;
import projektRestauracja.repositories.SupervisionPeriodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisionPeriodService {
    @Autowired
    private SupervisionPeriodRepository repository;
    public SupervisionPeriodService() {
        super();
    }

    public <S extends SupervisionPeriod> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<SupervisionPeriod> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public List<SupervisionPeriod> findAll() {
        return repository.findByOrderByIdSupervision();
    }
}

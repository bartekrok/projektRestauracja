package projektRestauracja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektRestauracja.models.Employee;
import projektRestauracja.repositories.BurgerRepository;
import projektRestauracja.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public EmployeeService() {
        super();
    }

    public <S extends Employee> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Employee> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }


    public List<Employee> findAll() {
        return repository.findByOrderByNameDesc();
    }
}

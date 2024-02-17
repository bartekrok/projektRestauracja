package projektRestauracja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projektRestauracja.models.Burger;
import projektRestauracja.models.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByOrderByNameDesc();
}

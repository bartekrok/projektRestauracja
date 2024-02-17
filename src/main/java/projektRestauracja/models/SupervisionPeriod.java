package projektRestauracja.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class SupervisionPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupervision;

    @ManyToOne
    private FoodTruck id_foodtruck;
    @ManyToOne
    private Employee id_employee;
    @CreationTimestamp
    private LocalDateTime started_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;


    public Long getId_supervision() {
        return idSupervision;
    }

    public FoodTruck getId_foodtruck() {
        return id_foodtruck;
    }

    public Employee getId_employee() {
        return id_employee;
    }

    public LocalDateTime getStarted_at() {
        return started_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setId_supervision(Long id_supervision) {
        this.idSupervision = id_supervision;
    }

    public void setId_foodtruck(FoodTruck id_foodtruck) {
        this.id_foodtruck = id_foodtruck;
    }

    public void setId_employee(Employee id_employee) {
        this.id_employee = id_employee;
    }

    public void setStarted_at(LocalDateTime started_at) {
        this.started_at = started_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}

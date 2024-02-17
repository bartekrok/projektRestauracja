package projektRestauracja.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodTruckBeverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_foodtruck;
    private Long id_beverage;

    public Long getId() {
        return id;
    }

    public Long getId_foodtruck() {
        return id_foodtruck;
    }

    public Long getId_beverage() {
        return id_beverage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_foodtruck(Long id_foodtruck) {
        this.id_foodtruck = id_foodtruck;
    }

    public void setId_beverage(Long id_beverage) {
        this.id_beverage = id_beverage;
    }
}

package projektRestauracja.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodTruckBurger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_foodtruck;
    private Long id_burger;

    public Long getId() {
        return id;
    }

    public Long getId_foodtruck() {
        return id_foodtruck;
    }

    public Long getId_burger() {
        return id_burger;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_foodtruck(Long id_foodtruck) {
        this.id_foodtruck = id_foodtruck;
    }

    public void setId_burger(Long id_burger) {
        this.id_burger = id_burger;
    }
}

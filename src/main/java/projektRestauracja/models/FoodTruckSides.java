package projektRestauracja.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodTruckSides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_foodtruck;
    private Long id_sides;

    public Long getId() {
        return id;
    }

    public Long getId_foodtruck() {
        return id_foodtruck;
    }

    public Long getId_sides() {
        return id_sides;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_foodtruck(Long id_foodtruck) {
        this.id_foodtruck = id_foodtruck;
    }

    public void setId_sides(Long id_sides) {
        this.id_sides = id_sides;
    }
}

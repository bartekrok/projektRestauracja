package projektRestauracja.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FoodTruck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_foodtruck;
    private String city;
    private String name;
    private String postal_code;
    @OneToOne
    private Employee id_supervisor;

    @ManyToMany
    private List<FoodTruckBurger> foodTruckBurger;

    @ManyToMany
    private List<FoodTruckBeverage> foodTruckBeverage;

    @ManyToMany
    private List<FoodTruckSides> foodTruckSides;

    public Long getId_foodtruck() {
        return id_foodtruck;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public Employee getId_supervisor() {
        return id_supervisor;
    }

    public List<FoodTruckBurger> getFoodTruckBurger() {
        return foodTruckBurger;
    }

    public List<FoodTruckBeverage> getFoodTruckBeverage() {
        return foodTruckBeverage;
    }

    public List<FoodTruckSides> getFoodTruckSides() {
        return foodTruckSides;
    }

    public void setId_foodtruck(Long id_foodtruck) {
        this.id_foodtruck = id_foodtruck;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setId_supervisor(Employee id_supervisor) {
        this.id_supervisor = id_supervisor;
    }

    public void setFoodTruckBurger(List<FoodTruckBurger> foodTruckBurger) {
        this.foodTruckBurger = foodTruckBurger;
    }

    public void setFoodTruckBeverage(List<FoodTruckBeverage> foodTruckBeverage) {
        this.foodTruckBeverage = foodTruckBeverage;
    }

    public void setFoodTruckSides(List<FoodTruckSides> foodTruckSides) {
        this.foodTruckSides = foodTruckSides;
    }
}

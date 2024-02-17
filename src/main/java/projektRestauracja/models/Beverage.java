package projektRestauracja.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_beverage;
    private String description;
    private double price;
    private String photo;

    @ManyToMany
    private List<FoodTruckBeverage> foodTruckBeverage;

    public Long getId_beverage() {
        return id_beverage;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId_beverage(Long id_beverage) {
        this.id_beverage = id_beverage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setFoodTruckBeverage(List<FoodTruckBeverage> foodTruckBeverage) {
        this.foodTruckBeverage = foodTruckBeverage;
    }

    public List<FoodTruckBeverage> getFoodTruckBeverage() {
        return foodTruckBeverage;
    }
}

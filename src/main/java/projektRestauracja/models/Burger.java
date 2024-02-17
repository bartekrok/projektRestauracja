package projektRestauracja.models;

import jakarta.persistence.*;
import projektRestauracja.repositories.FoodTruckBurgerRepository;

import java.util.List;

@Entity
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_burger;
    private String description;
    private double price;
    private String photo;

    @ManyToMany
    private List<FoodTruckBurger> foodTruckBurger;

    public Long getId_burger() {
        return id_burger;
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

    public List<FoodTruckBurger> getFoodTruckBurger() {
        return foodTruckBurger;
    }

    public void setId_burger(Long id_burger) {
        this.id_burger = id_burger;
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

    public void setFoodTruckBurger(List<FoodTruckBurger> foodTruckBurger) {
        this.foodTruckBurger = foodTruckBurger;
    }
}

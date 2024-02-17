package projektRestauracja.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sides;
    private String description;
    private double price;
    private String photo;

    @ManyToMany
    private List<FoodTruckSides> foodTruckSides;

    public Long getId_sides() {
        return id_sides;
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

    public List<FoodTruckSides> getFoodTruckSides() {
        return foodTruckSides;
    }

    public void setId_sides(Long id_sides) {
        this.id_sides = id_sides;
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

    public void setFoodTruckSides(List<FoodTruckSides> foodTruckSides) {
        this.foodTruckSides = foodTruckSides;
    }
}

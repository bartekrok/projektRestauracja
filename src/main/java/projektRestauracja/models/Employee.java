package projektRestauracja.models;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;
    private String name;
    private String last_name;

    @OneToOne
    private FoodTruck id_foodtruck;

    public Long getId_employee() {
        return id_employee;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public FoodTruck getId_foodtruck() {
        return id_foodtruck;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setId_foodtruck(FoodTruck id_foodtruck) {
        this.id_foodtruck = id_foodtruck;
    }
}

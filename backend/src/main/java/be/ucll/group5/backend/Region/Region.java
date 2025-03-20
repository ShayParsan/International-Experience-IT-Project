package be.ucll.group5.backend.Region;

import jakarta.persistence.*;

@Entity
@Table(name = "regions") // Avoid using "region" as it might be a reserved keyword
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int temperature;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Direction windDirection;

    @Column(nullable = false)
    private int ph;

    @Column(nullable = false)
    private int salinity;

    // No-arg constructor (required by JPA)
    public Region() {}

    // Constructor
    public Region(int temperature, Direction windDirection, int ph, int salinity) {
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.ph = ph;
        this.salinity = salinity;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Direction getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Direction windDirection) {
        this.windDirection = windDirection;
    }

    public int getPh() {
        return ph;
    }

    public void setPh(int ph) {
        this.ph = ph;
    }

    public int getSalinity() {
        return salinity;
    }

    public void setSalinity(int salinity) {
        this.salinity = salinity;
    }
}
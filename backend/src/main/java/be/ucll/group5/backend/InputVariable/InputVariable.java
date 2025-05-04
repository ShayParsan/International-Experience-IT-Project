package be.ucll.group5.backend.InputVariable;

import jakarta.persistence.*;

@Entity
@Table(name = "input_variable")
public class InputVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private java.sql.Timestamp time;

    @Column(nullable = true)
    private Float temperature;

    @Column(nullable = true)
    private Float ph;

    @Column(nullable = true)
    private Float tds; // TDS (ppm)

    @Column(nullable = true, name = "water_hyacinth_growth")
    private Float waterHyacinthGrowth; // Water Hyacinth Growth (kg/m²)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Timestamp getTime() {
        return time;
    }

    public void setTime(java.sql.Timestamp time) {
        this.time = time;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getPh() {
        return ph;
    }

    public void setPh(Float ph) {
        this.ph = ph;
    }

    public Float getTds() {
        return tds;
    }

    public void setTds(Float tds) {
        this.tds = tds;
    }

    public Float getWaterHyacinthGrowth() {
        return waterHyacinthGrowth;
    }

    public void setWaterHyacinthGrowth(Float waterHyacinthGrowth) {
        this.waterHyacinthGrowth = waterHyacinthGrowth;
    }
}

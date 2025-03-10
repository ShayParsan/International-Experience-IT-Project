package be.ucll.group5.backend.Region;

public class Region {
    private int id;
    private int temperature;
    private Direction windDirection;
    private int ph;
    private int salinity;

    public Region(int id, int temperature, Direction windDirection, int ph, int salinity) {
        this.id = id;
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.ph = ph;
        this.salinity = salinity;
    }

    public int getId() {
        return id;
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

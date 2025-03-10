package be.ucll.group5.backend.Region;

import java.util.List;

public class RegionController {
    private RegionService regionService;

    public RegionController() {
        regionService = new RegionService();
    }

    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    public void setRegions(List<Region> regions) {
        regionService.setRegions(regions);
    }

    public Region getRegionById(int id) {
        return regionService.getRegionById(id);
    }

    public void updateRegion(int id, int temperature, Direction.DirectionType windDirection, int ph, int salinity) {
        regionService.updateRegion(id, temperature, windDirection, ph, salinity);
    }
}

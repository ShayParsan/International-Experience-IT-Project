package be.ucll.group5.backend.Region;

import java.util.List;

public class RegionService {
    private RegionRepository regionRepository;

    public RegionService() {
        regionRepository = new RegionRepository();
    }

    public List<Region> getRegions() {
        return regionRepository.getRegions();
    }

    public void setRegions(List<Region> regions) {
        regionRepository.setRegions(regions);
    }

    public Region getRegionById(int id) {
        List<Region> regions = regionRepository.getRegions();
        for (Region region : regions) {
            if (region.getId() == id) {
                return region;
            }
        }
        return null;
    }

    public void updateRegion(int id, int temperature, Direction.DirectionType windDirection, int ph, int salinity) {
        Region region = getRegionById(id);
        region.setTemperature(temperature);
        region.setWindDirection(new Direction(windDirection));
        region.setPh(ph);
        region.setSalinity(salinity);
    }
}

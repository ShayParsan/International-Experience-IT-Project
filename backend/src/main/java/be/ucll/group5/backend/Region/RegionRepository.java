package backEnd.src.main.Region;

import java.util.List;

public class RegionRepository {
    private List<Region> regions;

    public RegionRepository() {
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}

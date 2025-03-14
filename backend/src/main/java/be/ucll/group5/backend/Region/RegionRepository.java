package be.ucll.group5.backend.Region;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RegionRepository {
    private List<Region> regions = new ArrayList<Region>();

    public RegionRepository() {
        regions.add(new Region(1, 25, Direction.NORTH, 7, 35));
        regions.add(new Region(2, 30, Direction.EAST, 6, 40));
        regions.add(new Region(3, 20, Direction.SOUTH, 8, 30));
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public Region updateRegion(int id, Region region) {
        for (Region r : regions) {
            if (r.getId() == id) {
                r = region;
                return r;
            }
        }
        return null;
    }
}

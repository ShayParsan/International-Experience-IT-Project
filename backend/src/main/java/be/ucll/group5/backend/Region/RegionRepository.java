package be.ucll.group5.backend.Region;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
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

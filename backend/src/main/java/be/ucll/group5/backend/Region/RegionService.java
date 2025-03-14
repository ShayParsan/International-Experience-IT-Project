package be.ucll.group5.backend.Region;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
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

    public Region updateRegion(int id, Region region) {
        if (getRegionById(id) == null) {
            throw new IllegalArgumentException("Region not found");
        }
        regionRepository.updateRegion(id, region);
        return region;
    }
}

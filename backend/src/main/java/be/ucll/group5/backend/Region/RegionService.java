package be.ucll.group5.backend.Region;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    public void setRegions(List<Region> regions) {
        regionRepository.saveAll(regions);
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));
    }

    public Region updateRegion(Long id, Region region) {
        Region existingRegion = getRegionById(id);
        existingRegion.setTemperature(region.getTemperature());
        existingRegion.setWindDirection(region.getWindDirection());
        existingRegion.setPh(region.getPh());
        existingRegion.setSalinity(region.getSalinity());

        return regionRepository.save(existingRegion);
    }
}
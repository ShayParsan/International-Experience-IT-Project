package be.ucll.group5.backend.Region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    public RegionController() {
        regionService = new RegionService();
    }

    @GetMapping
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @PutMapping
    public void setRegions(List<Region> regions) {
        regionService.setRegions(regions);
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable int id) {
        return regionService.getRegionById(id);
    }

    @PutMapping("/{id}")
    public void updateRegion(@PathVariable int id, Region region) {
        regionService.updateRegion(id, region);
    }
}

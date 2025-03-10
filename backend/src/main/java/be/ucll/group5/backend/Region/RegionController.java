package be.ucll.group5.backend.Region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    public RegionController() {
        regionService = new RegionService();
    }

    @GetMapping("/regions")
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @PutMapping("/regions")
    public void setRegions(List<Region> regions) {
        regionService.setRegions(regions);
    }

    @GetMapping("/regions/{id}")
    public Region getRegionById(int id) {
        return regionService.getRegionById(id);
    }

    @PutMapping("/regions/{id}")
    public void updateRegion(int id, int temperature, Direction.DirectionType windDirection, int ph, int salinity) {
        regionService.updateRegion(id, temperature, windDirection, ph, salinity);
    }
}

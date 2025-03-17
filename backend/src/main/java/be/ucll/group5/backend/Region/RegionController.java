package be.ucll.group5.backend.Region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Region Management", description = "APIs for managing regions")
@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    public RegionController() {
        regionService = new RegionService();
    }

    @Operation(summary = "Get all regions", description = "Returns a list of all regions in the system")
    @GetMapping
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @Operation(summary = "Set the list of regions", description = "Sets the list of regions")
    @PutMapping
    public void setRegions(@RequestBody List<Region> regions) {
        regionService.setRegions(regions);
    }

    @Operation(summary = "Get region by ID", description = "Returns region details by ID")
    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable int id) {
        return regionService.getRegionById(id);
    }

    @Operation(summary = "Update region", description = "Updates an existing region by ID")
    @PutMapping("/{id}")
    public void updateRegion(@PathVariable int id, @RequestBody Region region) {
        regionService.updateRegion(id, region);
    }
}

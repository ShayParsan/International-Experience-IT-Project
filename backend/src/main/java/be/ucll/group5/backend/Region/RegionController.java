package be.ucll.group5.backend.Region;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Region Management", description = "APIs for managing regions")
@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @Operation(summary = "Get all regions", description = "Returns a list of all regions in the system")
    @GetMapping
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @Operation(summary = "Set the list of regions", description = "Replaces the list of regions with new ones")
    @PutMapping
    public void setRegions(@RequestBody List<Region> regions) {
        regionService.setRegions(regions);
    }

    @Operation(summary = "Get region by ID", description = "Returns region details by ID")
    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id);
    }

    @Operation(summary = "Update region", description = "Updates an existing region by ID")
    @PutMapping("/{id}")
    public Region updateRegion(@PathVariable Long id, @RequestBody Region region) {
        return regionService.updateRegion(id, region);
    }
}
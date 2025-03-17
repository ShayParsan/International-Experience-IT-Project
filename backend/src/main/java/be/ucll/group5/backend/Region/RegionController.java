package be.ucll.group5.backend.Region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/regions")
@Api(value = "Region Management System", description = "Operations pertaining to regions in Region Management System")
public class RegionController {
    @Autowired
    private RegionService regionService;

    public RegionController() {
        regionService = new RegionService();
    }

    @ApiOperation(value = "View a list of available regions", response = List.class)
    @GetMapping
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @ApiOperation(value = "Set the list of regions")
    @PutMapping
    public void setRegions(
            @ApiParam(value = "List of regions to be set", required = true) @RequestBody List<Region> regions) {
        regionService.setRegions(regions);
    }

    @ApiOperation(value = "Get a region by ID")
    @GetMapping("/{id}")
    public Region getRegionById(
            @ApiParam(value = "ID of the region to retrieve", required = true) @PathVariable int id) {
        return regionService.getRegionById(id);
    }

    @ApiOperation(value = "Update a region")
    @PutMapping("/{id}")
    public void updateRegion(
            @ApiParam(value = "ID of the region to update", required = true) @PathVariable int id,
            @ApiParam(value = "Updated region object", required = true) @RequestBody Region region) {
        regionService.updateRegion(id, region);
    }
}

package be.ucll.group5.backend.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/collections")
@Api(value = "Collection Management System", description = "Operations pertaining to collections in Collection Management System")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @ApiOperation(value = "View a list of available collections", response = List.class)
    @GetMapping
    public List<Collection> getCollections() {
        return collectionService.getCollections();
    }

    @ApiOperation(value = "Add a collection")
    @PostMapping
    public void addCollection(
            @ApiParam(value = "ID of the collection", required = true) @RequestParam int id,
            @ApiParam(value = "Name of the collection", required = true) @RequestParam String name,
            @ApiParam(value = "Address of the collection", required = true) @RequestParam String address,
            @ApiParam(value = "Number of the collection", required = true) @RequestParam String number) {
        collectionService.addCollection(id, name, address, number);
    }

    @ApiOperation(value = "Get a collection by ID")
    @GetMapping("/{id}")
    public Collection getCollectionById(
            @ApiParam(value = "ID of the collection to retrieve", required = true) @PathVariable int id) {
        return collectionService.getCollectionById(id);
    }

    @ApiOperation(value = "Update a collection")
    @PutMapping("/{id}")
    public void updateCollection(
            @ApiParam(value = "ID of the collection to update", required = true) @PathVariable int id,
            @ApiParam(value = "Updated name of the collection", required = true) @RequestParam String name,
            @ApiParam(value = "Updated address of the collection", required = true) @RequestParam String address,
            @ApiParam(value = "Updated number of the collection", required = true) @RequestParam String number) {
        collectionService.updateCollection(id, name, address, number);
    }
}
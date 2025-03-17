package be.ucll.group5.backend.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Collection Management", description = "APIs for managing collections")
@RestController
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @Operation(summary = "Get all collections", description = "Returns a list of all collections in the system")
    @GetMapping
    public List<Collection> getCollections() {
        return collectionService.getCollections();
    }

    @Operation(summary = "Add a new collection", description = "Creates a new collection")
    @PostMapping
    public void addCollection(@RequestParam int id, @RequestParam String name, @RequestParam String address, @RequestParam String number) {
        collectionService.addCollection(id, name, address, number);
    }

    @Operation(summary = "Get collection by ID", description = "Returns collection details by ID")
    @GetMapping("/{id}")
    public Collection getCollectionById(@PathVariable int id) {
        return collectionService.getCollectionById(id);
    }

    @Operation(summary = "Update collection", description = "Updates an existing collection by ID")
    @PutMapping("/{id}")
    public void updateCollection(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String number) {
        collectionService.updateCollection(id, name, address, number);
    }
}

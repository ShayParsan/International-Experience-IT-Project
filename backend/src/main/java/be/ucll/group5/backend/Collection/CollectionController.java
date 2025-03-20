package be.ucll.group5.backend.Collection;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Collection Management", description = "APIs for managing collections")
@RestController
@RequestMapping("/collections")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @Operation(summary = "Get all collections", description = "Returns a list of all collections in the system")
    @GetMapping
    public List<Collection> getCollections() {
        return collectionService.getCollections();
    }

    @Operation(summary = "Get collection by ID", description = "Returns collection details by ID")
    @GetMapping("/{id}")
    public Collection getCollectionById(@PathVariable Long id) {
        return collectionService.getCollectionById(id);
    }

    @Operation(summary = "Add a new collection", description = "Creates a new collection")
    @PostMapping
    public Collection addCollection(@RequestBody Collection collection) {
        return collectionService.addCollection(collection);
    }

    @Operation(summary = "Update collection", description = "Updates an existing collection by ID")
    @PutMapping("/{id}")
    public Collection updateCollection(@PathVariable Long id, @RequestBody Collection collection) {
        return collectionService.updateCollection(id, collection);
    }

    @Operation(summary = "Delete collection", description = "Deletes a collection by ID")
    @DeleteMapping("/{id}")
    public void deleteCollection(@PathVariable Long id) {
        collectionService.deleteCollection(id);
    }
}
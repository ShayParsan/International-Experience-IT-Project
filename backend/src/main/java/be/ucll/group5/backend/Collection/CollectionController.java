package be.ucll.group5.backend.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping
    public List<Collection> getCollections() {
        return collectionService.getCollections();
    }

    @PostMapping
    public void addCollection(int id, String name, String address, String number) {
        collectionService.addCollection(id, name, address, number);
    }

    @GetMapping("/{id}")
    public Collection getCollectionById(@PathVariable int id) {
        return collectionService.getCollectionById(id);
    }

    @PutMapping("/{id}")
    public void updateCollection(@PathVariable int id, String name, String address, String number) {
        collectionService.updateCollection(id, name, address, number);
    }
}

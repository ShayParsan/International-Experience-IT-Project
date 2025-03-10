package be.ucll.group5.backend.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("/collections")
    public List<Collection> getCollections() {
        return collectionService.getCollections();
    }

    @PutMapping("/collections")
    public void addCollection(int id, String name, String address, String number) {
        collectionService.addCollection(id, name, address, number);
    }

    @GetMapping("/collections/{id}")
    public Collection getCollectionById(int id) {
        return collectionService.getCollectionById(id);
    }

    @PutMapping("/collections/{id}")
    public void updateCollection(int id, String name, String address, String number) {
        collectionService.updateCollection(id, name, address, number);
    }
}

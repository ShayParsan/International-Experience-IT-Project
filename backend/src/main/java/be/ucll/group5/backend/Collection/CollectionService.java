package be.ucll.group5.backend.Collection;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getCollections() {
        return collectionRepository.findAll();
    }

    public Collection getCollectionById(Long id) {
        return collectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Collection not found"));
    }

    public Collection addCollection(CollectionInput collectionInput) {
        Collection collection = new Collection(collectionInput.name(), collectionInput.address(),
                collectionInput.number());
        return collectionRepository.save(collection);
    }

    public Collection updateCollection(Long id, Collection newCollection) {
        Collection existingCollection = getCollectionById(id);
        existingCollection.setName(newCollection.getName());
        existingCollection.setAddress(newCollection.getAddress());
        existingCollection.setNumber(newCollection.getNumber());
        return collectionRepository.save(existingCollection);
    }

    public void deleteCollection(Long id) {
        collectionRepository.deleteById(id);
    }
}
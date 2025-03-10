package be.ucll.group5.backend.Collection;

import java.util.List;

public class CollectionService {
    private CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getCollections() {
        return collectionRepository.getCollections();
    }

    public Collection getCollectionById(int id) {
        return collectionRepository.getCollectionById(id);
    }

    public void updateCollection(int id, String name, String address, String number) {
        collectionRepository.updateCollection(id, name, address, number);
    }

    public void addCollection(int id, String name, String address, String number) {
        collectionRepository.addCollection(id, name, address, number);
    }

    public void deleteCollection(int id) {
        collectionRepository.deleteCollection(id);
    }
}

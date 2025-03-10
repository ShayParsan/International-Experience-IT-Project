package be.ucll.group5.backend.Collection;

public class CollectionController {
    private CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void addCollection(int id, String name, String address, String number) {
        collectionService.addCollection(id, name, address, number);
    }

    public Collection getCollectionById(int id) {
        return collectionService.getCollectionById(id);
    }

    public void updateCollection(int id, String name, String address, String number) {
        collectionService.updateCollection(id, name, address, number);
    }
}

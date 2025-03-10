package backEnd.src.main.Collection;

import java.util.List;

public class CollectionRepository {
    private List<Collection> collections;

    public CollectionRepository() {
        collections.add(new Collection(1, "Collection 1", "Address 1", "1234567890"));
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public Collection getCollectionById(int id) {
        for (Collection collection : collections) {
            if (collection.getId() == id) {
                return collection;
            }
        }
        return null;
    }

    public void updateCollection(int id, String name, String address, String number) {
        for (Collection collection : collections) {
            if (collection.getId() == id) {
                collection.setName(name);
                collection.setAddress(address);
                collection.setNumber(number);
            }
        }
    }

    public void addCollection(int id, String name, String address, String number) {
        collections.add(new Collection(id, name, address, number));
    }

    public void deleteCollection(int id) {
        for (Collection collection : collections) {
            if (collection.getId() == id) {
                collections.remove(collection);
            }
        }
    }
}

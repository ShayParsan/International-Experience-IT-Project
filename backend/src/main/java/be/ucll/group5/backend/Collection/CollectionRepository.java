package be.ucll.group5.backend.Collection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CollectionRepository {
    private List<Collection> collections;

    public CollectionRepository() {
        this.collections = new ArrayList<>();
        collections.add(new Collection(1, "Collection1", "Address1", "Number1"));
        collections.add(new Collection(2, "Collection2", "Address2", "Number2"));
        collections.add(new Collection(3, "Collection3", "Address3", "Number3"));
        collections.add(new Collection(4, "Collection4", "Address4", "Number4"));
        collections.add(new Collection(5, "Collection5", "Address5", "Number5"));
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

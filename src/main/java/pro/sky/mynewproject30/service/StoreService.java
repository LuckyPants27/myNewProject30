package pro.sky.mynewproject30.service;

import org.springframework.stereotype.Service;
import pro.sky.mynewproject30.component.Basket;
import pro.sky.mynewproject30.model.Item;
import pro.sky.mynewproject30.component.ItemStore;

import java.util.List;

@Service
public class StoreService {

    private final ItemStore itemStore;
    private final Basket basket;

    public StoreService(ItemStore itemStore, Basket basket) {
        this.itemStore = itemStore;
        this.basket = basket;
    }

    public void add(List<Integer> ids) {
        basket.add(
                ids.stream()
                        .map(id -> itemStore.get(id))
                        .toList()
        );
    }

    public List<Item> get() {
        return basket.get();
    }
}

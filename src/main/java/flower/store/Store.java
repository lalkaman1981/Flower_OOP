package flower.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Store {
    Map<Class< ? extends ShopItem>, List<ShopItem>> itemMap = new HashMap<>();

    public void add(ShopItem item) {
        Class< ? extends ShopItem> item_type = item.getClass();
        itemMap.putIfAbsent(item_type, new ArrayList<>());
        itemMap.get(item_type).add(item);
    }

    public List<ShopItem> search(String str) {
        Set<String> words = unique_words(str);
        String lower;
        List<ShopItem> items = new ArrayList<>();

        for (String word : words) {
            lower = word.toLowerCase();
            switch (lower) {
                case "flower" -> simpleSearch(items, Flower.class);
                case "bucket", "flowerbucket" -> simpleSearch(items, FlowerBucket.class);
                case "pack", "flowerpack" -> simpleSearch(items, FlowerPack.class);
                default -> {
                }
            }
        }

        return items;
    }

    private void simpleSearch(List<ShopItem> items, Class< ? extends ShopItem> cls) {
        List<ShopItem> flowers = itemMap.get(cls);
        if (flowers != null) {
            for (ShopItem flower : flowers) {
                items.add(flower);
            }
        } else {
            System.out.println("No items found for the class: " + cls.getSimpleName());
        }
    }

    private Set<String> unique_words(String words) {
        String[] splitted = words.split(" ");
        Set<String> unique_words = new HashSet<>();

        unique_words.addAll(Arrays.asList(splitted));

        return unique_words;
    }
}

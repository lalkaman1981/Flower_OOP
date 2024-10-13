package flower.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Store {
        private Map<Class<
        ? extends ShopItem>, 
        List<ShopItem>> itemMap = new HashMap<>();

        public void add(ShopItem item) {
                Class<
                ? extends ShopItem> itemType = item
                                .getClass();
                itemMap.putIfAbsent(
                                itemType,
                                new ArrayList<>());
                itemMap.get(itemType)
                                .add(item);
        }

        public List<ShopItem> search(
                        String str) {
                Set<String> words = uniqueWords(
                                str);
                String lower;
                List<ShopItem> items = new ArrayList<>();

                for (String word : words) {
                        lower = word.toLowerCase();
                        switch (lower) {
                        case "flower":
                                simpleSearch(items,
                                        Flower.class);
                                break;
                        case "bucket":
                        case "flowerbucket":
                                simpleSearch(items,
                                        FlowerBucket.class);
                                break;
                        case "pack":
                        case "flowerpack":
                                simpleSearch(items,
                                        FlowerPack.class);
                                break;
                        default:
                                break;
                        }

                }

                return items;
        }

        private void simpleSearch(
                        List<ShopItem> items,
                        Class<
                        ? extends ShopItem> cls) {
                List<ShopItem> flowers = itemMap
                                .get(cls);
                if (flowers != null) {
                        for (ShopItem flower : flowers) {
                                items.add(flower);
                        }
                } else {
                        System.out.println(
                "No items found for the class: "
                 + cls.getSimpleName());
                }
        }

        private Set<String> uniqueWords(
                        String words) {
                String[] splitted = words
                                .split(" ");
                Set<String> uniqueWords = new HashSet<>();
                uniqueWords.addAll(
                                Arrays.asList(splitted));
                return uniqueWords;
        }

        public Map<Class<
        ? extends ShopItem>,List<ShopItem>> getItemMap() {
                return itemMap;
        }

        public void setItemMap(
                Map<Class<
                ? extends ShopItem>, List<ShopItem>> newItemMap) {
                this.itemMap = newItemMap;
        }
}

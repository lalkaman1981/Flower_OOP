package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.Assertions;

class StoreTest {

    private Store store;
    private Flower flower;
    private FlowerPack flowerPack;
    private FlowerBucket flowerBucket;

    @BeforeEach
    void setUp() {
        store = new Store();
        flower = new Flower();
        double price = 10.0;
        flower.setPrice(
                price);

        flowerPack = new FlowerPack(
                flower,
                5);
        flowerBucket = new FlowerBucket();

        store.add(
                flower);
        store.add(
                flowerPack);
        store.add(
                flowerBucket);
    }

    @Test
    void testAddItemsToStore() {
        List<ShopItem> flowers = store
                .search("flower");
        Assertions
                .assertEquals(
                        1,
                        flowers.size());
        Assertions
                .assertEquals(
                        flower,
                        flowers.get(
                                0));

        List<ShopItem> packs = store
                .search("pack");
        Assertions
                .assertEquals(
                        1,
                        packs.size());
        Assertions
                .assertEquals(
                        flowerPack,
                        packs.get(
                                0));

        List<ShopItem> buckets = store
                .search("bucket");
        Assertions
                .assertEquals(
                        1,
                        buckets.size());
        Assertions
                .assertEquals(
                        flowerBucket,
                        buckets.get(
                                0));
    }

    @Test
    void testSearchByMultipleKeywords() {
        List<ShopItem> items = store
                .search("flower pack");
        Assertions
                .assertEquals(
                        2,
                        items.size());
        Assertions
                .assertTrue(
                        items.contains(
                                flower));
        Assertions
                .assertTrue(
                        items.contains(
                                flowerPack));
    }

    @Test
    void testSearchWithUnknownKeyword() {
        List<ShopItem> items = store
                .search("unknown");
        Assertions
                .assertTrue(
                        items.isEmpty());
    }

    @Test
    void testUniqueWords() {
        List<ShopItem> items = store
                .search("flower flower flower");
        Assertions
                .assertEquals(
                        1,
                        items.size());
        Assertions
                .assertEquals(
                        flower,
                        items.get(
                                0));
    }

    @Test
    void testSearchCaseInsensitive() {
        List<ShopItem> items = store
                .search("Flower PaCk");
        int exp = 2;
        Assertions
                .assertEquals(
                        exp,
                        items.size());
        Assertions
                .assertTrue(
                        items.contains(
                                flower));
        Assertions
                .assertTrue(
                        items.contains(
                                flowerPack));
    }
}

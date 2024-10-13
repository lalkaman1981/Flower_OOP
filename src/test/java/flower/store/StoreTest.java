package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    private Store store;
    private Flower flower;
    private FlowerPack flowerPack;
    private FlowerBucket flowerBucket;

    @BeforeEach
    void setUp() {
        store = new Store();
        flower = new Flower();
        flower.setPrice(10.0);

        flowerPack = new FlowerPack(flower, 5);
        flowerBucket = new FlowerBucket();

        store.add(flower);
        store.add(flowerPack);
        store.add(flowerBucket);
    }

    @Test
    void testAddItemsToStore() {
        List<ShopItem> flowers = store.search("flower");
        assertEquals(1, flowers.size());
        assertEquals(flower, flowers.get(0));

        List<ShopItem> packs = store.search("pack");
        assertEquals(1, packs.size());
        assertEquals(flowerPack, packs.get(0));

        List<ShopItem> buckets = store.search("bucket");
        assertEquals(1, buckets.size());
        assertEquals(flowerBucket, buckets.get(0));
    }

    @Test
    void testSearchByMultipleKeywords() {
        List<ShopItem> items = store.search("flower pack");
        assertEquals(2, items.size());
        assertTrue(items.contains(flower));
        assertTrue(items.contains(flowerPack));
    }

    @Test
    void testSearchWithUnknownKeyword() {
        List<ShopItem> items = store.search("unknown");
        assertTrue(items.isEmpty());
    }

    @Test
    void testUniqueWords() {
        List<ShopItem> items = store.search("flower flower flower");
        assertEquals(1, items.size());
        assertEquals(flower, items.get(0));
    }

    @Test
    void testSearchCaseInsensitive() {
        List<ShopItem> items = store.search("Flower PaCk");
        assertEquals(2, items.size());
        assertTrue(items.contains(flower));
        assertTrue(items.contains(flowerPack));
    }
}

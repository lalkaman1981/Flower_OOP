package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlowerPackTest {

    private Flower flower;
    private FlowerPack flowerPack;

    private static final double DELTA = 0.001;
    private static final double EXPECTED_PRICE = 50.0;
    private static final double INITIAL_FLOWER_PRICE = 10.0;
    private static final int INITIAL_QUANTITY = 5;
    private static final double NEW_FLOWER_PRICE = 15.0;
    private static final int QUANTITY = 10;

    @BeforeEach
    void setUp() {
        flower = new Flower();
        flower.setPrice(INITIAL_FLOWER_PRICE);
        flowerPack = new FlowerPack(flower, INITIAL_QUANTITY);
    }

    @Test
    void testFlowerPackConstructor() {
        org.junit.jupiter.api.Assertions.assertNotNull(flowerPack.getFlower());
        org.junit.jupiter.api.Assertions.assertEquals(INITIAL_QUANTITY,
                flowerPack.getQuantity());
    }

    @Test
    void testGetPrice() {
        org.junit.jupiter.api.Assertions.assertEquals(EXPECTED_PRICE,
                flowerPack.getPrice(), DELTA);
    }

    @Test
    void testSetFlower() {
        Flower newFlower = new Flower();
        newFlower.setPrice(NEW_FLOWER_PRICE);

        flowerPack.setFlower(newFlower);
        org.junit.jupiter.api.Assertions.assertEquals(newFlower,
                flowerPack.getFlower());
        org.junit.jupiter.api.Assertions.assertEquals(NEW_FLOWER_PRICE,
                flowerPack.getFlower().getPrice(), DELTA);
    }

    @Test
    void testSetQuantity() {
        flowerPack.setQuantity(QUANTITY);
        org.junit.jupiter.api.Assertions.assertEquals(QUANTITY,
                flowerPack.getQuantity());
    }
}

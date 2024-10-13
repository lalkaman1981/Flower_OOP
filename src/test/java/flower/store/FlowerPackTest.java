package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {

    private Flower flower;
    private FlowerPack flowerPack;

    @BeforeEach
    void setUp() {

        flower = new Flower();
        flower.setPrice(10.0);
        flowerPack = new FlowerPack(flower, 5);
    }

    @Test
    void testFlowerPackConstructor() {

        assertNotNull(flowerPack.getFlower());
        assertEquals(5, flowerPack.getQuantity());
    }

    @Test
    void testGetPrice() {
        assertEquals(50.0, flowerPack.getPrice(), 0.001);
    }

    @Test
    void testSetFlower() {

        Flower newFlower = new Flower();
        newFlower.setPrice(15.0);

        flowerPack.setFlower(newFlower);
        assertEquals(newFlower, flowerPack.getFlower());
        assertEquals(15.0, flowerPack.getFlower().getPrice(), 0.001);
    }

    @Test
    void testSetQuantity() {
        flowerPack.setQuantity(10);
        assertEquals(10, flowerPack.getQuantity());
    }
}

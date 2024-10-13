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
        double price = 10.0;
        flower.setPrice(price);
        flowerPack = new FlowerPack(flower, 5);
    }

    @Test
    void testFlowerPackConstructor() {

        assertNotNull(flowerPack.getFlower());
        int exp = 5;
        assertEquals(exp, flowerPack.getQuantity());
    }

    @Test
    void testGetPrice() {
        double exp = 50.0, delta = 0.001;
        assertEquals(exp, flowerPack.getPrice(), delta);
    }

    @Test
    void testSetFlower() {

        Flower newFlower = new Flower();
        double price = 15.0;
        newFlower.setPrice(price);

        flowerPack.setFlower(newFlower);
        assertEquals(newFlower, flowerPack.getFlower());
        assertEquals(15.0, flowerPack.getFlower().getPrice(), 0.001);
    }

    @Test
    void testSetQuantity() {
        int quantity = 10, exp = 10;
        flowerPack.setQuantity(quantity);
        assertEquals(exp, flowerPack.getQuantity());
    }
}

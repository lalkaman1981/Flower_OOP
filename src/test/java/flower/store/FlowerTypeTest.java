package flower.store;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlowerTypeTest {

    @Test
    void testFlowerTypeValues() {
        FlowerType[] expectedTypes = { FlowerType.CHAMOMILE, FlowerType.ROSE, FlowerType.TULIP };
        assertArrayEquals(expectedTypes, FlowerType.values());
    }

    @Test
    void testIndividualFlowerType() {
        assertEquals(FlowerType.ROSE, FlowerType.valueOf("ROSE"));
        assertEquals(FlowerType.CHAMOMILE, FlowerType.valueOf("CHAMOMILE"));
        assertEquals(FlowerType.TULIP, FlowerType.valueOf("TULIP"));
    }

    @Test
    void testInvalidFlowerType() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> FlowerType.valueOf("INVALID"));

        assertEquals("No enum constant flower.store.FlowerType.INVALID", thrown.getMessage());
    }
}

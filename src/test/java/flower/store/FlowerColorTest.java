package flower.store;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlowerColorTest {

    @Test
    void testRedColorToString() {
        assertEquals("#FF0000", FlowerColor.RED.toString());
    }

    @Test
    void testBlueColorToString() {
        assertEquals("#0000FF", FlowerColor.BLUE.toString());
    }

    @Test
    void testAllEnumValues() {
        for (FlowerColor color : FlowerColor.values()) {
            switch (color) {
            case RED:
                assertEquals("#FF0000", color.toString());
                break;
            case BLUE:
                assertEquals("#0000FF", color.toString());
                break;
            default:
                fail("Unexpected color: " + color);
            }
        }
    }
}

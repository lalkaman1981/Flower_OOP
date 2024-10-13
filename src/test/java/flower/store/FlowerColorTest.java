package flower.store;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class FlowerColorTest {

    @Test
    void testRedColorToString() {
        Assertions.assertEquals("#FF0000", FlowerColor.RED.toString());
    }

    @Test
    void testBlueColorToString() {
        Assertions.assertEquals("#0000FF", FlowerColor.BLUE.toString());
    }

    @Test
    void testAllEnumValues() {
        for (FlowerColor color : FlowerColor.values()) {
            switch (color) {
            case RED:
                Assertions.assertEquals("#FF0000", color.toString());
                break;
            case BLUE:
                Assertions.assertEquals("#0000FF", color.toString());
                break;
            default:
                Assertions.fail("Unexpected color: " + color);
            }
        }
    }
}

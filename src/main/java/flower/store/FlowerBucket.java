package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket
        extends
        ShopItem {
    private final List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        this.flowerPacks = new ArrayList<>();
    }

    public void add(
            FlowerPack flowerPack) {
        this.flowerPacks
                .add(flowerPack);
    }

    @Override
    public double getPrice() {
        double price = 0;

        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack
                    .getPrice();
        }

        return price;
    }
}

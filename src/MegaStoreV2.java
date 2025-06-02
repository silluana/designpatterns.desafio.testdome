public class MegaStoreV2 {

    public enum DiscountType {
        STANDARD(new StandardDiscount()),
        SEASONAL(new SeasonalDiscount()),
        WEIGHT(new WeightDiscount());

        private final DiscountStrategy strategy;

        DiscountType(DiscountStrategy strategy) {
            this.strategy = strategy;
        }

        public double applyDiscount(double cartWeight, double totalPrice) {
            return strategy.calculateDiscount(cartWeight, totalPrice);
        }
    }

    public static double getDiscountedPrice(double cartWeight, double totalPrice, DiscountType discountType) {
        return discountType.applyDiscount(cartWeight, totalPrice);
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(12, 100, DiscountType.WEIGHT));
        System.out.println(getDiscountedPrice(12, 100, DiscountType.STANDARD));
        System.out.println(getDiscountedPrice(12, 100, DiscountType.SEASONAL));
    }
}

interface DiscountStrategy {
    double calculateDiscount(double cartWeight, double totalPrice);
}

class StandardDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double cartWeight, double totalPrice) {
        return totalPrice * (1 - 6 / 100.0);
    }
}

class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double cartWeight, double totalPrice) {
        return totalPrice * (1 - 12 / 100.0);
    }
}

class WeightDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double cartWeight, double totalPrice) {
        double discount = cartWeight > 10 ? 18 : 6;
        return totalPrice * (1 - discount / 100.0);
    }
}
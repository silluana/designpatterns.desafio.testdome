public class MegaStore {

    public enum DiscountType {
        STANDARD(6),
        SEASONAL(12),
        WEIGHT(6);

        private final double discount;

        DiscountType(double discount) {
            this.discount = discount;
        }

        public double getDiscount() {
            return discount;
        }
    }

    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
        if (discountType == DiscountType.STANDARD) {
            return calculateDiscount(totalPrice, discountType.getDiscount());
        }
        if (discountType == DiscountType.SEASONAL) {
            return calculateDiscount(totalPrice, discountType.getDiscount());
        }
        if (discountType == DiscountType.WEIGHT) {
            if (cartWeight > 10) {
                return calculateDiscount(totalPrice, 18);
            }
            return calculateDiscount(totalPrice, discountType.getDiscount());
        }

        return totalPrice; // No discount applied
    }

    private static double calculateDiscount(double totalPrice, double discount) {
        return totalPrice * (1 - discount / 100);
    }

    public static void main(String[] args) {

        System.out.println(DiscountType.WEIGHT.name());
        System.out.println(DiscountType.WEIGHT.getDiscount());

        System.out.println(getDiscountedPrice(12, 100, DiscountType.WEIGHT));
    }
}

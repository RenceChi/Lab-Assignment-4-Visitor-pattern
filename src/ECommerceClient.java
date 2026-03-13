public class ECommerceClient {
    public static void main(String[] args) {
        // a cart with various items to test the different map rates
        Furniture[] cart = new Furniture[] {
                new Chair(8.5),
                new Chair(12.0),
                new Table(15.0),
                new Sofa(45.0, 120.0)
        };

        StandardShippingCalculator shippingCalculator = new StandardShippingCalculator();
        shippingCalculator.updateRate("Chair Surcharge", 7.00);

        double totalShippingCost = 0.0;

        System.out.println("--- Itemized Shipping Costs ---");

        //Process the cart
        for (Furniture item : cart) {
            double itemCost = item.accept(shippingCalculator);

            System.out.println(item.getClass().getSimpleName() + " cost: $" + itemCost);
            totalShippingCost += itemCost;
        }

        System.out.println("-------------------------------");
        System.out.println("Total Cart Shipping Cost: $" + totalShippingCost);
    }
}
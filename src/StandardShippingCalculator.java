import java.util.HashMap;
import java.util.Map;

public class StandardShippingCalculator implements ShippingVisitor {

    // HashMap to store dynamic shipping rates and thresholds
    private final Map<String, Double> ratesMap = new HashMap<>();

    public StandardShippingCalculator() {
        // Initialize default rates inside the map
        ratesMap.put("Chair", 15.00);
        ratesMap.put("Chair Surcharge", 5.00);
        ratesMap.put("Chair Weight", 10.0);

        ratesMap.put("Table Weight", 2.50);

        ratesMap.put("Sofa Volume", 5.00);
        ratesMap.put("Sofa Distance", 1.50);
    }

    // A helper method to easily update pricing at runtime
    public void updateRate(String rateKey, double newRate) {
        if (ratesMap.containsKey(rateKey)) {
            ratesMap.put(rateKey, newRate);
        } else {
            System.out.println("Rate key not found: " + rateKey);
        }
    }

    @Override
    public double visit(Chair chair) {
        double cost = ratesMap.get("Chair");
        // Pull the threshold and surcharge from the map instead of hardcoding
        if (chair.getWeight() > ratesMap.get("Chair Weight")) {
            cost += ratesMap.get("Chair Surcharge");
        }
        return cost;
    }

    @Override
    public double visit(Table table) {
        // Calculate using the map's multiplier
        return table.getSurfaceArea() * ratesMap.get("Table Weight");
    }

    @Override
    public double visit(Sofa sofa) {
        // Bulky calculation driven completely by the map's config
        return (sofa.getVolume() * ratesMap.get("Sofa Volume")) +
                (sofa.getDistanceToShip() * ratesMap.get("Sofa Distance"));
    }
}
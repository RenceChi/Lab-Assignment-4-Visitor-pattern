public class Chair implements Furniture {
    private double weight;

    public Chair(double weight) { this.weight = weight; }
    public double getWeight() { return weight; }

    @Override
    public double accept(ShippingVisitor visitor) {
        return visitor.visit(this);
    }
}
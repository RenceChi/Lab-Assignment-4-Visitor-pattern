public class Sofa implements Furniture {
    private double volume;
    private double distanceToShip;

    public Sofa(double volume, double distanceToShip) {
        this.volume = volume;
        this.distanceToShip = distanceToShip;
    }

    public double getVolume() { return volume; }
    public double getDistanceToShip() { return distanceToShip; }

    @Override
    public double accept(ShippingVisitor visitor) {
        return visitor.visit(this);
    }
}
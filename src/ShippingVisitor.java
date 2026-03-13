public interface ShippingVisitor {
    double visit(Chair chair);
    double visit(Table table);
    double visit(Sofa sofa);
}
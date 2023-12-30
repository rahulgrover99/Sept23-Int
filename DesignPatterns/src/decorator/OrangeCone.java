package decorator;

public class OrangeCone implements IceCream{

    // Base Add on

    private IceCream base;

    public OrangeCone() {
    }
    public OrangeCone(IceCream base) {
        this.base = base;
    }

    @Override
    public int getCost() {
        if (base == null) return 10;
        return base.getCost() + 10;
    }

    @Override
    public String getDescription() {
        if (base == null) return "Orange cone\n";
        return base.getDescription() + "Orange cone\n";
    }
}

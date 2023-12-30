package decorator;

public class VanillaScoop implements IceCream{

    private IceCream base;

    public VanillaScoop(IceCream base) {
        this.base = base;
    }

    @Override
    public int getCost() {
        return base.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "Vanilla Scoop\n";
    }
}

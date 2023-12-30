package decorator;

public class ChocolateSyrup implements IceCream{

    private IceCream base;

    public ChocolateSyrup(IceCream base) {
        this.base = base;
    }

    @Override
    public int getCost() {
        return base.getCost() + 15;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "Chocolate Syrup\n";
    }
}

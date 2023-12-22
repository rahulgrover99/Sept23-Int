package factory;

public class Flutter {

    public void setTheme(String themeName) {
        System.out.printf("Set theme as %s", themeName);
    }

    public void setRefreshRate(int freq) {
        System.out.printf("Set refresh rate as %s", freq);
    }

    // Factory method  -> Respo
    public UIFactory createUiFactory(String platform) {
        if (platform.equals("Android")) {
            return new AndroidUiFactory();
        } else if (platform.equals("IOS")) {
            return new IosUiFactory();
        }
        return null;
    }

}

package factory;

public class Client {
    public static void main(String[] args) {

        Flutter flutter = new Flutter();

        UIFactory uiFactory = flutter.createUiFactory("Android");

        Button b = uiFactory.createButton();

        b.changeSize(21);
        b.setText();

    }
}

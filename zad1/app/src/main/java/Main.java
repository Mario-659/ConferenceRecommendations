import app.App;

public class Main {
    public static void main(String[] args) {
        String path = args[0];

        App app = new App(path);
        app.run();
        System.exit(0);
    }
}

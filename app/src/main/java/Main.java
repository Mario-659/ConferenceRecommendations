import app.App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path;
        if (args.length == 1) path = args[0];
        else{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please type path to .txt file with input: ");
            path = scanner.nextLine();
        }

        App app = new App(path);
        app.run();
        System.exit(0);
    }
}

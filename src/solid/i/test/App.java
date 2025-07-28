package solid.i.test;

import solid.i.solution.Document;
import solid.i.solution.OldPrinter;
import solid.i.solution.Print;

public class App {
    public static void main(String[] args) {
        Document document = new Document("Hello, World!");

        Print printer = new OldPrinter();
        printer.print(document);
    }
}

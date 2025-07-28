package solid.i.solution;

public class OldPrinter implements Print {

    @Override
    public void print(Document document) {
        System.out.println("Printing document: " + document.getContent());
    }

}

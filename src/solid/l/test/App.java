package solid.l.test;

import solid.l.solution.Bird;
import solid.l.solution.Flyable;
import solid.l.solution.Penguin;
import solid.l.solution.Sparrow;

public class App {
    public static void main(String[] args) {
        Flyable sparrow = new Sparrow();
        sparrow.fly();

        Bird penguin = new Penguin();
        System.out.print("Penguin is not able to fly, but it can ");
        penguin.eat();

    }
}

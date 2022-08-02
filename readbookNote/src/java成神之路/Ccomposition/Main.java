package java成神之路.Ccomposition;

/**
 * @date 2021/12/7 15:54
 */
public class Main {

    public static void main(String[] args) {

        Bee a = new Bee(1, "black", new AttackImpl("fly", "move"));
        a.attack();

        // if you need another implementation of move()
        // there is no need to change Insect, we can quickly use new method to attack

        Bee b = new Bee(1, "black", new AttackImpl("fly", "sting"));
        b.attack();

    }
}

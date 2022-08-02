package java成神之路.composition_before;

/**
 * @date 2021/12/7 15:57
 */
class Bee extends Insect {
    public Bee(int size, String color) {
        super(size, color);
    }

    public void move() {
        System.out.println("Fly");
    }

    public void attack() {
        move();
        super.attack();
    }
}

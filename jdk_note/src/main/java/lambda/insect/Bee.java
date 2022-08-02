package lambda.insect;

// 这个封装类封装了一个Attack类型的对象
class Bee extends Insect implements Attack {
    private Attack attack;
 
    public Bee(int size, String color, Attack attack) {
        super(size, color);
        this.attack = attack;
    }
 
    public void move() {
        attack.move();
    }
 
    public void attack() {
        attack.attack();
    }
}
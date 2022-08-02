package lambda.insect;

public class InheritanceVSComposition2 {
    public static void main(String[] args) {
        Bee a = new Bee(1, "black", new AttackImpl("fly", "move"));
        a.attack();
 
        // if you need another implementation of move()
        // there is no need to change Insect, we can quickly use new method to attack
 
        Bee b = new Bee(1, "black", new AttackImpl("fly", "sting"));
        b.attack();

        //内部类
        Bee c = new Bee(1, "red", new Attack() {
            private String move;
            private String attack;

            @Override
            public void move() {
                System.out.println(move);
            }

            @Override
            public void attack() {
                move();
                System.out.println(attack);
            }
        });
        c.attack();

        //lambda
//        Bee d = new Bee("1,","red",()->{})
    }
}
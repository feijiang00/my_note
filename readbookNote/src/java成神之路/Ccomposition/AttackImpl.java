package java成神之路.Ccomposition;

class AttackImpl implements Attack {
    private final String move;
    private final String attack;

    public AttackImpl(String move, String attack) {
        this.move = move;
        this.attack = attack;
    }

    @Override
    public void move() {
        System.out.println(move);
    }

    @Override
    public void attack() {
        move();
        System.out.println(attack);
    }
}
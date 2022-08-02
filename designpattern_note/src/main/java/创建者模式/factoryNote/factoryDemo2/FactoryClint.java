package 创建者模式.factoryNote.factoryDemo2;

//import jdk.dynalink.beans.StaticClass;

import java.util.Scanner;

public class FactoryClint {
    public static void main(String[] args) {

        System.out.println("input shape which you want to draw");
        Scanner sc = new Scanner(System.in);

        String shape = sc.next();

        Painter painter = StaticCreator(shape);

        shape = sc.next();
        painter = StaticCreator(shape);


    }


    public static Painter StaticCreator(String name){

        /**
         * 初始化工厂
         */
        if(name.equalsIgnoreCase("circle")){
            Factory CircleFactory = new CircleFactory();
            CirclePainter circlePainter = (CirclePainter) CircleFactory.createCircle();
            return  circlePainter;
        }else if(name.equalsIgnoreCase("rect")){
            Factory RectFactory = new RectFactory();
            RectPainter rectPainter  = (RectPainter) RectFactory.createRect();
            return rectPainter;
        }else{
            return null;
        }
    }
}


/**
 *  抽象画图工厂,每一个工厂对应一个⚪和矩形，虽然在抽象类中定义了，但是
 *  工厂的实现类中却对于不是自己该类的工厂，不起作用
 *
 *  工厂方法模式：
 *          一个抽象产品类，可以派生出多个具体产品类。
 *          一个抽象工厂类，可以派生出多个具体工厂类。
 *         每个具体工厂类只能创建一个具体产品类的实例。（对于一类产品（接口），想增加不同的实例（接口的实现类）时直接增加对应的工厂类就行，不需修改以前工厂类的代码）
 */
abstract class Factory{
    public abstract Painter createCircle();

    public abstract Painter createRect();
}

class CircleFactory extends Factory{


    @Override
    public CirclePainter createCircle() {
        System.out.println("draw:circle");
        return new CirclePainter();
    }

    @Override
    public Painter createRect() {
        return null;
    }


}

class RectFactory extends Factory{


    @Override
    public Painter createCircle() {
        return null;
    }

    @Override
    public RectPainter createRect() {
        System.out.println("draw:rect");

        return new RectPainter();
    }
}

/**
 * 原始抽象类
 */
abstract class Painter{

    public abstract void draw();
}

class  CirclePainter extends Painter {

    @Override
    public void draw() {
        System.out.println("draw:circle");
    }
}

class RectPainter extends Painter {

    @Override
    public void draw() {
        System.out.println("draw:rect");
    }
}





package 创建者模式.factoryNote.factoryDemo3;

import java.util.Scanner;

/**
 * 抽象工厂类
 * 多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。
 * 一个抽象工厂类，可以派生出多个具体工厂类。
 * 每个具体工厂类可以创建多个具体产品类的实例。
 */
public class FactoryClint {
    public static void main(String[] args) {
        System.out.println("input shape which you want to draw");
        Scanner sc = new Scanner(System.in);

        String shape = sc.next();

        StaticCreator(shape);

        shape =sc.next();

        StaticCreator(shape);

    }

    public static void StaticCreator(String name){
        Factory CircleFactory = new CircleFactory();
        Factory RectFactory = new RectFactory();

        if(name.equalsIgnoreCase("circle")){
            Painter painter;Dye dye;
            painter = CircleFactory.createPainter();
            dye = CircleFactory.createDye();
            painter.draw();
            dye.dyeing();

        }else if(name.equalsIgnoreCase("rect")){
            Painter painter;Dye dye;
            dye = RectFactory.createDye();
            painter = RectFactory.createPainter();
            painter.draw();
            dye.dyeing();
        }else {
            return;
        }
    }
}


/**
 * 抽象类工厂，返回的是一些抽象类方法
 */
abstract class Factory{
    //返回Painter,Painter系列下的是圆和矩形的绘制
    abstract public Painter createPainter();

    //返回Dye，Dye系列下的是圆和矩形的上色
    abstract public Dye createDye();
}

/**
 * 返回园的绘制和圆的上色,
 */
class CircleFactory extends Factory{

    @Override
    public Painter createPainter() {
        return new CirclePainter();
    }

    @Override
    public Dye createDye() {
        return new CircleDye();
    }
}

class RectFactory extends Factory{

    @Override
    public Painter createPainter() {
        return  new RectPainter();
    }

    @Override
    public Dye createDye() {
        return new RectDye();
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

/**
 * 新增原始抽象类Dye
 */
abstract  class  Dye{
    public abstract void dyeing();
}

class CircleDye extends Dye{

    @Override
    public void dyeing() {
        System.out.println("dyeing circle");
    }
}

class RectDye extends Dye{

    @Override
    public void dyeing() {
        System.out.println("dyeing rect");
    }
}
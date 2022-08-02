package 创建者模式.factoryNote.factoryDemo;

import java.util.Scanner;

/**
 * 简单工厂模式
 */
public class FactoryClint {

    public static void main(String[] args) {

        System.out.println("input shape which you want to draw");
        Scanner sc = new Scanner(System.in);
        String shape = sc.next();

        simpleFactory simpleFactory  = new simpleFactory();
        Painter painter = simpleFactory.initShape(shape);

        painter.draw();

        shape = sc.next();
        painter = simpleFactory.initShape(shape);
        painter.draw();
    }
}

class simpleFactory{
    public  Painter initShape(String name){

        if(name.equalsIgnoreCase("circle")){
            return new CirclePainter();
        }else if(name.equalsIgnoreCase("rect")){
            return new RectPainter();
        }else{
            return null;
        }
    }
}

/**
 * 原始抽象类
 */
abstract class Painter{

    public abstract void draw();
}

class  CirclePainter extends Painter{

    @Override
    public void draw() {
        System.out.println("draw:circle");
    }
}

class RectPainter extends Painter{

    @Override
    public void draw() {
        System.out.println("draw:rect");
    }
}

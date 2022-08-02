package 结构者模式.proxy.jdk;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running.....");
    }
}

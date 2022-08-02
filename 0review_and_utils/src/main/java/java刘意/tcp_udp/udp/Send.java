package java刘意.tcp_udp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @date 2021/12/7 14:09
 */
public class Send {
    public static void main(String[] args) throws IOException {
        /**
         * 发送数据步骤
         *      创建发送端的Socket对象
         *      创建数据包
         *      发送数据
         *      关闭发送端
         */
        //首先拿到IP地址
        InetAddress address = InetAddress.getByName("192.168.220.1");

        //构建发送socket
        DatagramSocket socket = new DatagramSocket();

        //构造要发送的数据
        byte[] bytes = "hello,udp,我来了".getBytes();

        //构造发送的数据包对象
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,10086);

        //发送数据
        socket.send(dp);

        //关闭发送端
        socket.close();
    }
}

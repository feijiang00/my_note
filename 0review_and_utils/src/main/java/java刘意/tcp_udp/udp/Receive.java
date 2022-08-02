package java刘意.tcp_udp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @date 2021/12/7 14:30
 */
public class Receive {
    public static void main(String[] args) throws IOException {

        //接收指定端口的socket数据
        DatagramSocket socket = new DatagramSocket(10086);

        //一直接收
        while(true){
            //创建接收数据容器
            byte[] bytes = new byte[1024];
            //创建接收数据包对象
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            //接收数据
            socket.receive(dp);
            //解析数据包，并使用数据
            String dataStr = new String(dp.getData(), dp.getOffset(), dp.getLength());
            //输出数据
            System.out.println(dataStr);

        }
    }
}

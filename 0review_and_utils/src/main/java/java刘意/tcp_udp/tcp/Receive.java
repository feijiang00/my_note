package java刘意.tcp_udp.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @date 2021/12/7 14:56
 */
public class Receive {
    public static void main(String[] args) throws IOException {

        //创建服务端的socket对象，绑定指定端口
        ServerSocket socket = new ServerSocket(10086);

        //侦听要连接到的此套接字，并接受它
        Socket s = socket.accept();

        //获取输入流，读数据，并显示数据
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String data = new String(bytes,0,len);//将byte数组转为String数组
        System.out.println("数据是："+data);

        s.close();
        socket.close();
    }
}

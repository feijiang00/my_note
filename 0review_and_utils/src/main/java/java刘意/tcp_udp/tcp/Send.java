package java刘意.tcp_udp.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @date 2021/12/7 14:53
 */
public class Send {
    public static void main(String[] args) throws IOException {

        //创建客户端对象
        Socket s= new Socket("192.168.220.1",10086);

        //获取输出，写数据
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());

        //释放资源
        s.close();
    }
}

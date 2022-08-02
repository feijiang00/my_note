package java刘意.tcp_udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @date 2021/12/7 14:11
 */
public class Note {
    /**
     * 网络编程三要素：  ip地址，端口，协议
     *
     * UDP:
     *      是一种无连接通信协议，即使在数据传输时，数据的发送端和接收端不建议逻辑链接，通常用于视频会议，音频，视频的数据传输
     * TCP:
     *      传输控制协议,即在传输数据之前，会建立逻辑连接，然后传输数据，可靠无差错的数据传输。
     *      建立连接的三次握手：
     *      第一次握手：客户端向服务端发起请连接请求，等待服务器相应
     *      第二次握手，服务器端向客户端发送确认信息，来连接吧，通知客户端你可以来连接了
     *      第三次握手，客户端再次和服务器发送确认，我来了啊，那我来了
     *      多用于，上传文件，下载文件，浏览网页等等
     *
     *
     */

    public static void main(String[] args) throws UnknownHostException {

        //通过ip或者主机名获取 inetAddress对象，这里后面UDP,TCP都要用到
        InetAddress inetAddress = InetAddress.getByName("192.168.220.1");
        System.out.println(inetAddress.getHostAddress());//ip地址
        System.out.println(inetAddress.getHostName());//主机名

    }
}

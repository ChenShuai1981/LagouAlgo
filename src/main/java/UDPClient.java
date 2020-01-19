import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        //1.通过DatagramChannel的open()方法创建一个DatagramChannel对象
        DatagramChannel datagramChannel = DatagramChannel.open();
        //绑定一个port（端口）
        datagramChannel.bind(new InetSocketAddress(9999));

//        ByteBuffer buf = ByteBuffer.allocate(48);
//        buf.clear();
//        datagramChannel.receive(buf);
//        buf.flip();
//        StringBuilder stringBuffer=new StringBuilder();
//        while (buf.hasRemaining()) {
//            stringBuffer.append((char) buf.get());
//        }
//        System.out.println("从服务端接收到的数据："+stringBuffer);

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put("datagramchannel".getBytes());
        buf.flip();
        int send = datagramChannel.send(buf, new InetSocketAddress("localhost",9999));
        System.out.println(send);
        datagramChannel.close();
    }
}

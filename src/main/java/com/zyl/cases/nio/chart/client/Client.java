package com.zyl.cases.nio.chart.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class Client {

  public static void main(String[] args) throws IOException {
    SocketChannel socketChannel = SocketChannel.open();
    SocketAddress socketAddress = new InetSocketAddress(8080);
    socketChannel.connect(socketAddress);
    String str = "zheng-you-le";
    ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
    socketChannel.write(buffer);

    buffer.clear();
    byte[] bytes;
    int count = 0;
    while ((count = socketChannel.read(buffer)) > 0) {
      buffer.flip();
      bytes = new byte[count];
      buffer.get(bytes);
      System.out.println(new String(buffer.array()));
      buffer.clear();
    }

    try {
      while (socketChannel.validOps() != SelectionKey.OP_READ) {
        Thread.sleep(200);
      }
    } catch (Exception e) {

    }

    ByteBuffer bufferBack = ByteBuffer.allocate(20);

    socketChannel.read(bufferBack);
    System.out.println("back: " + new String(bufferBack.array()));

    socketChannel.socket().shutdownInput();
    socketChannel.socket().close();
    socketChannel.close();
  }

}

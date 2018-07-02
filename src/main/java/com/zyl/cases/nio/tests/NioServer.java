package com.zyl.cases.nio.tests;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {

  private static final int PORT = 8080;

  private static ByteBuffer echoBuffer = ByteBuffer.allocate(5);


  public static void main(String args[]) throws Exception {

    /*//打开ServerSocketChannel 用于监听客户端连接  所有客户连接的父管道
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

    //绑定监听端口
    InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", PORT);

    ServerSocket serverSocket = serverSocketChannel.socket();
    serverSocket.bind(socketAddress);

    //设置连接为非阻塞模式
    serverSocketChannel.configureBlocking(false);

    //创建Reactor线程， 创建多路复用器 并启动线程

    Selector selector = Selector.open();

    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    while (true) {
      Set selectedKeys = selector.selectedKeys();
      Iterator<SelectionKey> iterator = selectedKeys.iterator();
      while (iterator.hasNext()) {
        SelectionKey key = iterator.next();
        if (key.readyOps() == SelectionKey.OP_ACCEPT) {
          SocketChannel sc = serverSocketChannel.accept();
          sc.configureBlocking(false);
          iterator.remove();
          System.out.println("Got connection from " + sc);
        } else if (key.readyOps() == SelectionKey.OP_READ) {
          SocketChannel sc = (SocketChannel) key.channel();
          sc.read(echoBuffer);
          System.out.println("Echoed " + echoBuffer + " from " + sc);
          iterator.remove();
        }

      }

    }*/

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.socket().bind(new InetSocketAddress(8080));
    serverSocketChannel.configureBlocking(false);

    while (true) {
      SocketChannel socketChannel = serverSocketChannel.accept();
      if (socketChannel != null) {
        socketChannel.read(echoBuffer);
        System.out.println("Echoed " + new String(echoBuffer.array()) + " from " + socketChannel);
      }
    }
  }


}

package com.zyl.cases.nio.chart.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class ServerStarter {

  private static final int PORT = 8080;

  public void start() throws IOException {

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

    //绑定监听端口
    InetSocketAddress socketAddress = new InetSocketAddress(PORT);

    ServerSocket serverSocket = serverSocketChannel.socket();
    serverSocket.bind(socketAddress);

    //设置连接为非阻塞模式
    serverSocketChannel.configureBlocking(false);

    //创建Reactor线程， 创建多路复用器 并启动线程
    Selector selector = Selector.open();

    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    new SelectorHandle(selector).start();

  }

}

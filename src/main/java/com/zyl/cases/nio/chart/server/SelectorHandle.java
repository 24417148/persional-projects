package com.zyl.cases.nio.chart.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorHandle extends Thread {

  private Selector selector;

  public SelectorHandle(Selector selector) {
    this.selector = selector;
  }


  @Override
  public void run() {
    try {
      System.out.println("selectorHandle is runing");
      while (true) {
        int n = selector.select();
        if (n == 0) {
          continue;
        }
        Iterator ite = this.selector.selectedKeys().iterator();
        while (ite.hasNext()) {
          SelectionKey key = (SelectionKey) ite.next();
          if (key.isAcceptable()) {
            SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
            socketChannel.configureBlocking(false);
            //将选择器注册到连接到的客户端信道，
            //并指定该信道key值的属性为OP_READ，
            //同时为该信道指定关联的附件
            //buffer 内部调用了CAT 对缓存的内存加锁  避免使用同一buffer 导致的锁问题
            socketChannel
                .register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(10));
          }
          if (key.isReadable()) {
            ((SocketChannel) key.channel()).read((ByteBuffer) key.attachment());
            System.out
                .println("hadle read: " + new String(((ByteBuffer) key.attachment()).array()));
            (key.channel())
                .register(key.selector(), SelectionKey.OP_WRITE, ByteBuffer.allocate(10));
          }
          if (key.isWritable() && key.isValid()) {
            ByteBuffer backBuffer = ByteBuffer.allocate(20);
            backBuffer.put("this is server".getBytes());
            ((SocketChannel) key.channel()).write(backBuffer);
            System.out
                .println("hadle write: " + new String(backBuffer.array()));
            (key.channel()).close();
          }
          ite.remove();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

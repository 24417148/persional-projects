package com.zyl.cases.nio.tests;

import java.nio.ByteBuffer;

public class BufferTest {

  public static void main(String args[]) throws Exception {

    ByteBuffer buffer = ByteBuffer.allocate(32);

    printDetil(buffer);

    buffer.put((byte) 'a');


    //printDetil(buffer);

   // buffer.flip(); // 写 --> 读  position = 0 从头开始

    //System.out.println("---char: " + (char) buffer.get());

    printDetil(buffer);

    buffer.flip();

    printDetil(buffer);

    buffer.compact(); // 读 --> 写 position = limit - position  只是方向改变

    printDetil(buffer);

    //buffer.clear();// position 变为初始位置0  一起指针重置  数据不清除
    buffer.put((byte) 'b');

    printDetil(buffer);

    //buffer.put((byte) 'b');

   /* System.out.println("---char: " + (char) buffer.get(0));

    System.out.println("---char: " + (char) buffer.get(1));

    System.out.println("---char: " + (char) buffer.get(30));

    System.out.println("---char: " + (char) buffer.get(31));*/

   // printDetil(buffer);

  }

  private static void printDetil(ByteBuffer buffer) {
    System.out.println(
        "capacity: " + buffer.capacity() + " position: " + buffer.position() + " limit: " + buffer
            .limit());
    System.out.println();
  }

}

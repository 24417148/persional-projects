package com.zyl.cases.nio.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {

  private static final String READ_FILE_NAME = "C:/Users/zheng-yl/Desktop/test-read.txt";

  private static final String WRITE_FILE_NAME = "C:/Users/zheng-yl/Desktop/test-wirte.txt";

  public static void main(String[] args) {
    try {
      //ioWay();
      nioWay();
      CopyFile();
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  /**
   * 使用IO读取指定文件的前1024个字节的内容。
   * @throws Exception
   */
  private static void ioWay() throws Exception{
    FileInputStream is = new FileInputStream(READ_FILE_NAME);

    byte[] buffer = new byte[1024];

    is.read(buffer);

    System.out.println(new String(buffer, "UTF-8"));

    is.close();
  }



  /**
   * 使用NIO读取指定文件的前1024个字节的内容。
   * @throws Exception
   */

  private static void nioWay() throws Exception {
    FileInputStream is = new FileInputStream(READ_FILE_NAME);

    //为该文件输入流生成唯一的文件通道  FileChannel
    FileChannel channel = is.getChannel();

    //开辟一个长度为1024的字节缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    channel.read(buffer);

    System.out.println(new String(buffer.array(), "UTF-8"));
    System.out.println(buffer.isDirect() + ", " + buffer.isReadOnly());
    channel.close();
    is.close();
  }


  public static void CopyFile() throws Exception  {

    String infile = READ_FILE_NAME;
      String outfile = WRITE_FILE_NAME;

      // 获取源文件和目标文件的输入输出流
      FileInputStream fin = new FileInputStream(infile);
      FileOutputStream fout = new FileOutputStream(outfile);

      // 获取输入输出通道
      FileChannel fcin = fin.getChannel();
      FileChannel fcout = fout.getChannel();

      // 创建缓冲区
      ByteBuffer buffer = ByteBuffer.allocate(1024);

      while (true) {
        // clear方法重设缓冲区，使它可以接受读入的数据
        buffer.clear();

        // 从输入通道中将数据读到缓冲区
        int r = fcin.read(buffer);

        // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
        if (r == -1) {
          break;
        }

        // flip方法让缓冲区可以将新读入的数据写入另一个通道
        buffer.flip();

        // 从输出通道中将数据写入缓冲区
        fcout.write(buffer);
      }
    }

  }

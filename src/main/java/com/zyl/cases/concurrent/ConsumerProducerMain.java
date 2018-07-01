package com.zyl.cases.concurrent;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConsumerProducerMain {

  public static void main(String[] args)
  {
    Ticket ticket = new Ticket();

    Producer pro = new Producer(ticket);
    Consumer con = new Consumer(ticket);
    ReadWriteLock lock = new ReentrantReadWriteLock(false);
    new Thread(con).start();
    new Thread(con).start();
    new Thread(pro).start();
    new Thread(pro).start();

  }

}

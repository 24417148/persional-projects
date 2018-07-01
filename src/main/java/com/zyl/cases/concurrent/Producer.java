package com.zyl.cases.concurrent;

public class Producer extends Thread {


  private Ticket res;

  Producer(Ticket res) {
    this.res = res;
  }

  public void run() {
    while (true) {
      res.set("+生产商品+");

    }
  }
}

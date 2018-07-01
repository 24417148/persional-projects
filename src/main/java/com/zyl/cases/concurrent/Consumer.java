package com.zyl.cases.concurrent;

public class Consumer implements Runnable {

  private Ticket res;

  Consumer(Ticket res) {
    this.res = res;
  }

  public void run() {
    while (true) {
      res.out();
    }
  }
}

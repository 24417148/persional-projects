package com.zyl.cases.concurrent;

public class Ticket {
  private String name;
  private int count = 1;
  private boolean flag = false;
  //  t1    t2
  public synchronized void set(String name)
  {
    while(flag){
      try{
        this.wait();
      }catch(Exception e){
        e.printStackTrace();
      }
    }

    this.name = name+"--"+count++;
    System.out.println(Thread.currentThread().getName()+"...生产者.."+this.name);
    flag = true;
    this.notifyAll();
  }


  //  t3   t4
  public synchronized void out()
  {
    while(!flag){
      try{
        wait();
      }catch(Exception e){
        e.printStackTrace();
      }
    }

    System.out.println(Thread.currentThread().getName()+"...消费者........."+this.name);
    flag = false;
    this.notifyAll();
  }
}

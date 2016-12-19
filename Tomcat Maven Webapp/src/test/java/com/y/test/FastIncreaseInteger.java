package com.y.test;

import java.util.concurrent.atomic.AtomicInteger;  
/**
 * 原子计数器测试
 * @author yanhz
 * 2016年10月20日 上午9:05:02
 * <P>Title:FastIncreaseInteger</P>
 * <P>TODO</P>
 */
public class FastIncreaseInteger {  
    private AtomicInteger num =new AtomicInteger();  
    public int getIncreaseInt(){  
        while(true){  
        int temp = num.get();  
        int next = temp + 1;  
            if(num.compareAndSet(temp, next)){  
                return next ;  
            }  
        }  
          
    }  
    public static void main(String[] args) {  
        FastIncreaseInteger  ss=new FastIncreaseInteger();  
        Tesst t=new Tesst(ss);  
        new Thread(t).start();  
        new Thread(t).start();  
        new Thread(t).start();  
        new Thread(t).start();  
        new Thread(t).start();  
          
    }  
}  
 class Tesst implements Runnable {  
    private FastIncreaseInteger increse=null;  
    public Tesst (FastIncreaseInteger fastIncreaseInteger){  
        this.increse=fastIncreaseInteger;  
    }  
    @Override  
    public void run() {  
        while(true){  
            System.out.println(increse.getIncreaseInt()+"\t\t :\t"+Thread.currentThread().getId());  
        }  
          
    }  
       
 }  

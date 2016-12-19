package com.y.test;
/**
 * 原子计数器测试
 * @author yanhz
 * 2016年10月20日 上午9:08:13
 * <P>Title:SynIncreaseInteger</P>
 * <P>TODO</P>
 */
public class SynIncreaseInteger {  
    private int num = 0;  
    public int getIncreaseNum (){  
        synchronized (this) {
        	num = num<100?num++:0;
        }  
        return num;  
    }  
    public static void main(String[] args) {  
        SynIncreaseInteger  ss=new SynIncreaseInteger();  
        Tessst t=new Tessst(ss);  
        new Thread(t).start();  
//        new Thread(t).start();  
//        new Thread(t).start();  
//        new Thread(t).start();  
//        new Thread(t).start();  
          
    }  
}  
class Tessst implements Runnable {  
    private SynIncreaseInteger increse=null;  
    public Tessst (SynIncreaseInteger fastIncreaseInteger){  
        this.increse=fastIncreaseInteger;  
    } 
    
    @Override  
    public void run() {
    	System.out.println("-===-");
        while(true){
        	
        	System.out.println("-1-");
           // System.out.println(increse.getIncreaseNum()+"\t\t :\t"+Thread.currentThread().getId());  
        }  
    }  
       
 }  
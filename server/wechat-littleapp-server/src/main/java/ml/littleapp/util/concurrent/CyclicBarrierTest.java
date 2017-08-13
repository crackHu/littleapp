package ml.littleapp.util.concurrent;
import java.util.concurrent.CyclicBarrier;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
/** 
 * @author amber2012 
 *  
 * CyclicBarrier: 
 * 表示线程彼此等待，等所有的线程都集合后，才开始做任务 
 *  
 */  
public class CyclicBarrierTest {  
  
    public static void main(String[] args) {  
        ExecutorService service = Executors.newCachedThreadPool();  
        final  CyclicBarrier cb = new CyclicBarrier(3);  
        for(int i=0;i<4;i++){  
            Runnable runnable = new Runnable(){  
                    public void run(){  
                    try {  
                        Thread.sleep((long)(Math.random()*10000));    
                        System.out.println("线程" + Thread.currentThread().getName() +   
                                "即将到达集合地点1，当前已有" + (cb.getNumberWaiting()+1) + "个已经到达，" + (cb.getNumberWaiting()==2?"都到齐了，继续走啊":"正在等候"));                         
                        cb.await();  
                          
                        Thread.sleep((long)(Math.random()*10000));    
                        System.out.println("线程" + Thread.currentThread().getName() +   
                                "即将到达集合地点2，当前已有" + (cb.getNumberWaiting()+1) + "个已经到达，" + (cb.getNumberWaiting()==2?"都到齐了，继续走啊":"正在等候"));  
                        cb.await();   
                        Thread.sleep((long)(Math.random()*10000));    
                        System.out.println("线程" + Thread.currentThread().getName() +   
                                "即将到达集合地点3，当前已有" + (cb.getNumberWaiting() + 1) + "个已经到达，" + (cb.getNumberWaiting()==2?"都到齐了，继续走啊":"正在等候"));                       
                        cb.await();                       
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }                 
                }  
            };  
            service.execute(runnable);  
        }  
        service.shutdown();  
    }  
}  
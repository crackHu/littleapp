package ml.littleapp.util.concurrent;
import java.util.concurrent.CountDownLatch;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
/** 
 * @author amber2012 
 *  
 * CountDownLatch： 
 * 好比倒计时计数器，调用CountDownLatch对象的CountDown方法就将计数器减1，当计数器到达0时，则所有等待线程 
 * 或单个等待线程开始执行。 
 */  
public class CountdownLatchTest {  
  
    public static void main(String[] args) {  
      
        ExecutorService service = Executors.newCachedThreadPool();  
        // 创建两个计数器，cdOrder的初始值为1，cdAnswer初始值为3  
        final CountDownLatch cdOrder = new CountDownLatch(1);  
        final CountDownLatch cdAnswer = new CountDownLatch(3);        
          
        for(int i=0;i<3;i++){  
            Runnable runnable = new Runnable(){  
                    public void run(){  
                    try {  
                        System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");                          
                        cdOrder.await(); // 所有的线程都在此等待，并希望被其他线程调用cdOrder.countDown()激活，在这里由主线程激活  
                          
                        System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");                                
                        Thread.sleep((long)(Math.random()*10000));    
                          
                        System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");                         
                        cdAnswer.countDown();// cdAnswer计数器的初始值为3，，三个线程到达后调用cdAnswer.countDown()到计数为0，激活主线程  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }                 
                }  
            };  
            service.execute(runnable);  
        }         
          
        try {  
            Thread.sleep((long)(Math.random()*10000));  
          
            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");                       
            cdOrder.countDown();// 主线程将cdOrder计数器减1  
              
            System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");     
            cdAnswer.await();// 主线程正在等待，希望被其他线程激活  
              
            System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");    
        } catch (Exception e) {  
            e.printStackTrace();  
        }                 
        service.shutdown();  
    }  
}  
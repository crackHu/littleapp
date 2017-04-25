package ml.littleapp.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ml.littleapp.pojo.SysLog;
import ml.littleapp.util.IdWorker;

@Component
public class Sender {
	
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
    
    public void sendLog(String method, String enter, String exit) {
    	
    	SysLog sysLog = new SysLog();
    	sysLog.setId(new IdWorker().nextId());
    	sysLog.setTitle(method);
    	sysLog.setParams(enter);
    	sysLog.setException(exit);
    	
    	this.rabbitTemplate.convertAndSend("log", sysLog);
    }
}
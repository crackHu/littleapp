package ml.littleapp.rabbitmq;

import javax.inject.Inject;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import ml.littleapp.mapper.SysLogMapper;
import ml.littleapp.pojo.SysLog;

@Component
@RabbitListener(queues = "crawler", containerFactory="rabbitListenerContainerFactory")
public class CrawlerReceiver {

	@RabbitHandler
	public void processLog(@Payload String sysLog) {
		System.out.println("Receiver : " + sysLog);
	}
}
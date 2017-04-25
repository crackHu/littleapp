package ml.littleapp.rabbitmq;

import javax.inject.Inject;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import ml.littleapp.mapper.SysLogMapper;
import ml.littleapp.pojo.SysLog;

@Component
@RabbitListener(queues = "log", containerFactory="rabbitListenerContainerFactory")
public class Receiver {

	@Inject
	private SysLogMapper sysLogMapper;

	@RabbitHandler
	public void processLog(@Payload SysLog sysLog) {
		System.out.println("Receiver : " + sysLog);
		sysLogMapper.insertSelective(sysLog);
	}
}
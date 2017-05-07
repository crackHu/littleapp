package ml.littleapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConstStatisticsAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("@annotation(ml.littleapp.annotation.ConstStatistics)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    	
    	long start = System.currentTimeMillis();
    	Object result = joinPoint.proceed();
    	long end = System.currentTimeMillis();
    	log.info("Consumption statistics: {}.{}() finished, cost {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), (end - start) + "ms");
    	
		return result;
    }
    
}

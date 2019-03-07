package com.nab.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NabLogging {

	
	private static final Logger log = LoggerFactory.getLogger(NabLogging.class);

	
	@Around("com.nab.aop.SystemPointcut.trace() || com.nab.aop.SystemPointcut.service() ")
	public Object logMethod(ProceedingJoinPoint jp) throws Throwable {
		String method = jp.getSignature().toString();
		try {
			log.debug("Entering {}" , method);
			log.debug(composeArgs(jp.getArgs().length), jp.getArgs());
			return jp.proceed();
		}catch(Throwable e) {
			log.error("AOP catched exception in {}", e , method);
			throw e;
		}finally {
			log.debug("Exiting {}" , method);
		}
		
	}
	
	private String composeArgs(int argSize) {
		StringBuilder sb = new StringBuilder("Args = ");
		for(int i = 0 ; i < argSize ;i++) {
			sb.append("{} ");
		}
		return sb.toString();
	}
	
}

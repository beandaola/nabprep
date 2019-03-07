package com.nab.aop;

import org.aspectj.lang.annotation.Pointcut;


public class SystemPointcut {
	
	@Pointcut("@within(org.springframework.stereotype.Repository)")
	public void repository() {//parameter must be empty
	}
	
	@Pointcut("@within(org.springframework.stereotype.Service)")
	public void service() {
		
	}
	@Pointcut("@within(com.nab.aop.NabTrace)")
	public void trace() {
		
	}
}

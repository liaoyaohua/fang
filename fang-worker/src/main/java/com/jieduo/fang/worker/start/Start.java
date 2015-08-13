package com.jieduo.fang.worker.start;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * @author lyh
 *
 */
public class Start {
	private ThreadPoolTaskExecutor taskExecutor;
	private List<Runnable> threads;
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
		Start start = beanFactory.getBean("start", Start.class);
		
		for (Runnable task : start.threads) {
			start.taskExecutor.execute(task);
		}
	}

	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public List<Runnable> getThreads() {
		return threads;
	}

	public void setThreads(List<Runnable> threads) {
		this.threads = threads;
	}

}
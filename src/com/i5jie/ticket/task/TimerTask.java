package com.i5jie.ticket.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * @author CLOUD-KWB
 *
 */
@Component
public class TimerTask {

	@Scheduled(fixedRate = 1000*60*60*24, initialDelay =10000)
	public void execute() {
		
	}

}

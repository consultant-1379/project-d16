package com.team1.git.mining;

import com.team1.git.mining.CSVReadScheduler;
import com.team1.git.mining.RunnableTask;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GitMiningApplication {


	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GitMiningApplication.class, args);
		CSVReadScheduler scheduler;
		scheduler = (CSVReadScheduler) ctx.getBean("CSVReadScheduler");
		scheduler.threadPoolTaskScheduler().scheduleWithFixedDelay(
				new RunnableTask(), 30000
		);


	}


	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_id");
		return converter;
	}

}

package org.bobo.clockin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.bobo.clockin.mapper")
public class ClockInApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClockInApplication.class, args);
	}

}
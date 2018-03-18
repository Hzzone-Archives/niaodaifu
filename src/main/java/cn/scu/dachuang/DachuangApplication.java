package cn.scu.dachuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("cn.scu.dachuang.dao")
public class DachuangApplication {

	public static void main(String[] args) {
		SpringApplication.run(DachuangApplication.class, args);
	}
}

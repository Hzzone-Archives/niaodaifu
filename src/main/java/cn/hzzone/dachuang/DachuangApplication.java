package cn.hzzone.dachuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.hzzone.dachuang.dao")
public class DachuangApplication {

	public static void main(String[] args) {
		SpringApplication.run(DachuangApplication.class, args);
	}
}

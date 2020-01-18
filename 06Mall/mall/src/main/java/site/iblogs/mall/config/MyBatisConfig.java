package site.iblogs.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"site.iblogs.mall.mbg.mapper","site.iblogs.mall.dao"})
public class MyBatisConfig {

}
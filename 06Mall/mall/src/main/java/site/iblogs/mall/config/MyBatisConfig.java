package site.iblogs.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("site.iblogs.site.mbg.mapper")
public class MyBatisConfig {

}

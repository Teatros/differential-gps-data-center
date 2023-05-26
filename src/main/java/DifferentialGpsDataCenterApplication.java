import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author tangqi
 */
@SpringBootApplication
@ComponentScan(basePackages="com.firedance.gps")
@MapperScan(basePackages = "com.firedance.gps.dao")
@EnableAutoConfiguration
public class DifferentialGpsDataCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(DifferentialGpsDataCenterApplication.class, args);
    }
}

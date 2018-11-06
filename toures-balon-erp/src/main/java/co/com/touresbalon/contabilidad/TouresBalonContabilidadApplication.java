package co.com.touresbalon.contabilidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="co.com.touresbalon.contabilidad.listener")
@SpringBootApplication
public class TouresBalonContabilidadApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouresBalonContabilidadApplication.class, args);
    }
}

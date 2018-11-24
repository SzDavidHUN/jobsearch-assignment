package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"hu.me.iit.controller", "hu.me.iit.dao", "hu.me.iit.model", "hu.me.iit.service"})
public class WebAppConfig {

}

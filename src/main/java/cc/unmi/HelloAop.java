package cc.unmi;

import cc.unmi.config.AppConfig;
import cc.unmi.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloAop {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.fetchUserById(234));
    }
}

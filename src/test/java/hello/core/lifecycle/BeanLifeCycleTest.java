package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void listCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeSycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeSycleConfig{
        //@Bean(initMethod = "init", destroyMethod = "close")
        //코드를 고칠 수 없는 외부 라이브러리의 초기화, 종료해야 한다면 위의 initMethod, destroyMethod 쓰면 됨
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}

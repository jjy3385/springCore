package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

/*    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
    //수동빈 등록이 우선권을 가진다.즉, 수동으로 등록한걸로 오버라이딩함(덮어씀)
    //하지만 이걸 의도하는 경우는 거의 없기 때문에, 충돌나면 오류가 발생되도록 기본 값을 바꿈

}

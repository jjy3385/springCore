package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("service")
@Component
public class OrderServiceImpl implements OrderService {

    //필드주입
/*    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;*/

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

/*    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("두번째 수정자 주입  memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("두번째 수정자 주입 discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/

    //@MainDiscountPolicy -> 어노테이션 직접작성 -> 컴파일 타임에 오타가 있는지 확인할 수 있음
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}

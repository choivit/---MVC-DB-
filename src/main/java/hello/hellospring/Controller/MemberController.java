package hello.hellospring.Controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

//    //3. setter 주입(단점. 여러번 호출되어버림)
//    private MemberService memberService;

//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }


//    //2. 필드 주입(별로 안좋음, 바꿀 수 있는 방법이 없음)
//    @Autowired private final MemberService memberService;

//    //1. 생성자 주입(best)
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

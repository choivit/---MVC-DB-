package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){

            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();

        //같은 이름이 있는 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName()); //꺼낸 값이 null 일 가능성이 있으면 optional로 감싸서 빼주고 덕분에 하위가 가능함.
//        result.ifPresent(m -> { //ifPresent == result가 값이 있으면(Optional이기 때문에 가능)
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
//        Member member1 = result.get(); //그냥 꺼내고 싶으면 이렇게 해도 상관은 없는데 권장하지 X
//        result.orElseGet(); //값이 있으면 꺼내고 없으면 뭔가 실행하거나 기본값을 실행하라는 말.
//        validateDuplicateMember(member); //중복 회원 검증
//
//        memberRepository.save(member);
//        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){

            return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

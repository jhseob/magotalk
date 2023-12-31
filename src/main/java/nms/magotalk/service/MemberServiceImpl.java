package nms.magotalk.service;

import lombok.RequiredArgsConstructor;
import nms.magotalk.domain.Member;
import nms.magotalk.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        checkSameMember(member);
        memberRepository.save(member);
        return member.getMemberId();
    }

    private void checkSameMember(Member member) {
        memberRepository.findByName(member.getMemberName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    @Override
    public Optional<Member> findMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    @Override
    public Optional<Member> findMember(String name) {
        Optional<Member> member = memberRepository.findByName(name);
        return member;
    }
}

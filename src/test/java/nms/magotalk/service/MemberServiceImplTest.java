package nms.magotalk.service;

import nms.magotalk.domain.Member;
import nms.magotalk.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    @DisplayName("회원가입")
    @Test
    void join() {
        Member member = new Member(
                "1234", "전자제어", 2,
                1, "memberA", "aa"
        );

        Long memberId = memberService.join(member);
        assertThat(member).isEqualTo(memberService.findMember(member.getMemberId()).get());
    }

    @DisplayName("회원중복")
    @Test
    void sameNameJoin() {
        Member member1 = new Member(
                "1234", "전자제어", 2,
                1, "memberA", "aa"
        );
        Member member2 = new Member(
                "1234", "전자제어", 2,
                1, "memberA", "aa"
        );

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
    }

    @DisplayName("아이디로 멤버 조회")
    @Test
    void findById() {
        Member member = new Member(
                "1234", "전자제어", 2,
                1, "memberA", "aa"
        );

        Long memberId = memberService.join(member);
        Member findMember = memberService.findMember(memberId).get();

        assertThat(findMember).isEqualTo(member);
    }
}
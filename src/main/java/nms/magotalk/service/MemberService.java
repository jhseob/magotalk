package nms.magotalk.service;

import nms.magotalk.domain.Member;

import java.util.Optional;

public interface MemberService {
    Long join(Member member);
    Optional<Member> findMember(Long id);
    Optional<Member> findMember(String name);
}

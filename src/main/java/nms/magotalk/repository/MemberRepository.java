package nms.magotalk.repository;

import nms.magotalk.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface MemberRepository {

    Optional<Member> findById(Long memberId);
    Optional<Member> findByName(String memberName);
    Member save(Member member);
}

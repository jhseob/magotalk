package nms.magotalk.repository;

import nms.magotalk.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private Map<Long, Member> collection = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    @Override
    public Optional<Member> findById(Long memberId) {
        Optional<Member> member = Optional.ofNullable(collection.get(memberId));
        return member;
    }

    @Override
    public Optional<Member> findByName(String memberName) {
        Optional<Member> member = collection.values().stream().filter(
                m -> m.getMemberName().equals(memberName)
        ).findAny();
        return member;
    }

    @Override
    public Member save(Member member) {
        member.setMemberId(++sequence);
        Member savedMember = collection.put(member.getMemberId(), member);
        return savedMember;
    }
}

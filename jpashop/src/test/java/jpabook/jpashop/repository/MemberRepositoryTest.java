package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    @DisplayName("조회한 회원과 찾은 회원 동일성")
    public void testMember() {
        Member member = new Member();
        member.setUsername("memberA");
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);
        //저장된 아이디 == 찾은 멤버의 아이디
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        // 유저 네임이 같은지 테스트
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        //찾은 멤버와 저장된 멤머 객체가 같은지 테스트
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}
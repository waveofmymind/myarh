package wave.myarh.domain.member.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import wave.myarh.domain.member.domain.Member;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 멤버_저장_테스트() {
        // given
        Member member = Member.builder()
                .email("sjun0913@gmail.com")
                .nickname("waveofmymind")
                .build();

        // when
        memberRepository.save(member);

        // then
        Assertions.assertThat(memberRepository.findByEmail(member.getEmail()).isPresent()).isEqualTo(true);
    }
}
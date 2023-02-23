package wave.myarh.domain.member.domain;

import jakarta.persistence.*;
import lombok.*;
import wave.myarh.domain.BaseEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column(unique = true)
    private String socialId;

    @Column
    private String nickname;





}

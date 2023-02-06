package wave.myarh.domain.review.domain;

import jakarta.persistence.*;
import lombok.*;
import wave.myarh.domain.BaseEntity;
import wave.myarh.domain.problem.domain.Problem;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name="review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "problem_id", updatable = false)
    private Problem problem;

    private String content;
}
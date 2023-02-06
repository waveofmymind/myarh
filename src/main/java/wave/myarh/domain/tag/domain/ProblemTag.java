package wave.myarh.domain.tag.domain;

import jakarta.persistence.*;
import lombok.*;
import wave.myarh.domain.problem.domain.Problem;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name="problem_tag")
public class ProblemTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="problem_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tag_id")
    private Tag tag;

    public ProblemTag(Problem problem, Tag tag) {
        this.problem = problem;
        this.tag = tag;
    }

}
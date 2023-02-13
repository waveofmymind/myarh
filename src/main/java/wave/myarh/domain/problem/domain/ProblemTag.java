package wave.myarh.domain.problem.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name="problem_tag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProblemTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="problem_id")
    private Problem problem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tag_id")
    private Tag tag;

    public ProblemTag(Problem problem, Tag tag) {
        this.problem = problem;
        this.tag = tag;
    }
}

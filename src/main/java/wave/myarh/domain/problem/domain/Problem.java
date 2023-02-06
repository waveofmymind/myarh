package wave.myarh.domain.problem.domain;

import jakarta.persistence.*;
import lombok.*;
import wave.myarh.domain.BaseEntity;
import wave.myarh.domain.review.domain.Review;
import wave.myarh.domain.tag.domain.ProblemTag;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="problem")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Problem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="problem_id")
    private Long id;

    private String title;

    private String link;

    private int level;
    @Builder.Default
    @OneToMany(mappedBy = "problem",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ProblemTag> problemTagList = new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "problem",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

}

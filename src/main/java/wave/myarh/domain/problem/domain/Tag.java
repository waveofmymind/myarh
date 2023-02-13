package wave.myarh.domain.problem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tag")
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;
    public Tag(String tagName) {
        this.tagName = tagName;
    }
}

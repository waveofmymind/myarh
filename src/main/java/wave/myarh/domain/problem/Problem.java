package wave.myarh.domain.problem;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="problem")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private int level;

}

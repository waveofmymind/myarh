package wave.myarh.domain.problem.domain;

import jakarta.persistence.*;

@Entity
@Table(name="tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;



}

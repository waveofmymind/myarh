package wave.myarh.domain.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.myarh.domain.problem.domain.Tag;

import java.util.Optional;


public interface TagRepository extends JpaRepository<Tag,Long> {

    Optional<Tag> findByTagName(String tagName);

}

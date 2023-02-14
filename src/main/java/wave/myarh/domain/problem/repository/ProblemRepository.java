package wave.myarh.domain.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.myarh.domain.problem.domain.Problem;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem,Long> {

    List<Problem> findByOrderByCreatedDateDesc();
}

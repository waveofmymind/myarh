package wave.myarh.domain.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.myarh.domain.problem.domain.Problem;

public interface ProblemRepository extends JpaRepository<Problem,Long> {
}

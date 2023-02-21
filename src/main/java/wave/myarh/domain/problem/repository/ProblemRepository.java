package wave.myarh.domain.problem.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wave.myarh.domain.problem.domain.Problem;

import java.util.List;
import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem,Long> {

    List<Problem> findByOrderByCreatedDateDesc(Pageable page);
}

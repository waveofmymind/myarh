package wave.myarh.domain.problem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wave.myarh.domain.problem.repository.ProblemRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProblemService {

    private ProblemRepository problemRepository;
}

package wave.myarh.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wave.myarh.global.dto.ResponseApiDto;
import wave.myarh.global.exception.BusinessException;
import wave.myarh.global.exception.ExceptionCode;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<?> businessException(final BusinessException e) {
        log.error("Business Exception : " + e.getMessage());
        final ExceptionCode exceptionCode = e.getExceptionCode();
        return new ResponseEntity<>(ResponseApiDto.fail(exceptionCode.getStatus(),e.getMessage()), exceptionCode.getStatus());
    }
}

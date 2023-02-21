package wave.myarh.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import wave.myarh.global.dto.ResponseApiDto;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ResponseApiDto<?>> businessException(final EntityNotFoundException e) {
        log.error("Business Exception : " + e.getMessage());
        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(ResponseApiDto.fail(errorCode.getStatus(),e.getMessage()), errorCode.getStatus());
    }


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseApiDto<?>> handleException(final Exception e) {
        log.error("Exception : " + e.getMessage());
        final ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(ResponseApiDto.fail(errorCode.getStatus(), errorCode.getMessage()), errorCode.getStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ResponseApiDto<?>> httpMessageNotReadableException() {
        log.error("HttpMessageNotReadableException");
        final ErrorCode exceptionCode = ErrorCode.INVALID_INPUT_VALUE;
        return new ResponseEntity<>(ResponseApiDto.fail(exceptionCode.getStatus(), exceptionCode.getMessage()), exceptionCode.getStatus());
    }

    //todo
}

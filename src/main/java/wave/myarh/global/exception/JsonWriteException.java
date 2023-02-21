package wave.myarh.global.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonWriteException extends BusinessException {
    public JsonWriteException() {
        super(ErrorCode.JSON_WRITE_ERROR);
    }
}

package wave.myarh.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ResponseApiDto<T> {

    private int status;

    private String message;

    private T data;

    public ResponseApiDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    //데이터 응답 필요 없을 떄
    public static ResponseApiDto<?> of(HttpStatus httpStatus, String message) {
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseApiDto<>(status,message);
    }

    public static <T> ResponseApiDto<?> of(HttpStatus httpStatus, String message, T data) {
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseApiDto<>(status,message,data);
    }

    public static ResponseApiDto<?> fail(HttpStatus httpStatus, String message) {
        return new ResponseApiDto<>(httpStatus.value(),message,null);
    }
}

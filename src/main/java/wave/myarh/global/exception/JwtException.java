package wave.myarh.global.exception;

public class JwtException extends BusinessException {
    public JwtException() {
        super(ErrorCode.JWT_EXCEPTION);
    }
}

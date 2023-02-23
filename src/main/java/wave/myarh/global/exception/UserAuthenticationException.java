package wave.myarh.global.exception;


public class UserAuthenticationException extends BusinessException {
    public UserAuthenticationException() {
        super(ErrorCode.NOT_VALID_USER);
    }
}

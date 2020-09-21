package njust.se2.librarymanagementsystemweb.result;

public enum ResultCode {
    SUCCESS(200),
    FAIL(4000),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}

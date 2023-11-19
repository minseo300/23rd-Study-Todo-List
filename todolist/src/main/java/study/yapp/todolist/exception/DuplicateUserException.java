package study.yapp.todolist.exception;

import lombok.extern.slf4j.Slf4j;
import study.yapp.todolist.common.ResponseCode;

@Slf4j
public class DuplicateUserException extends BusinessException{
    public DuplicateUserException(ResponseCode responseCode) {
        super(responseCode);
    }

    public DuplicateUserException(String message, ResponseCode responseCode) {
        super(message, responseCode);
        log.info(message);
    }
}
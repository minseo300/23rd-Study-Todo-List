package study.yapp.todolist.exception;

import lombok.extern.slf4j.Slf4j;
import study.yapp.todolist.common.ResponseCode;

@Slf4j
public class InvalidUserException extends BusinessException{
    public InvalidUserException(ResponseCode responseCode) {
        super(responseCode);
    }

    public InvalidUserException(String message, ResponseCode responseCode) {
        super(message, responseCode);
        log.info(message);
    }
}
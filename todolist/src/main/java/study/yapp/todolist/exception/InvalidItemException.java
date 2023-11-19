package study.yapp.todolist.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.yapp.todolist.common.ResponseCode;

@Slf4j
public class InvalidItemException extends BusinessException{
    public InvalidItemException(ResponseCode responseCode) {
        super(responseCode);
    }

    public InvalidItemException(String message, ResponseCode responseCode) {
        super(message, responseCode);
        log.info(message);
    }
}
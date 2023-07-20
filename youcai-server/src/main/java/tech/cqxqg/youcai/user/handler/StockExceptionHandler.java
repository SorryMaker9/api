package tech.cqxqg.youcai.user.handler;


import com.swak.frame.dto.Result;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.cqxqg.youcai.user.exception.StockException;

@Order(-2)
@RestControllerAdvice
public class StockExceptionHandler {

    @ExceptionHandler({StockException.class})
    public ResponseEntity<Result<?>> handler(StockException stockException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Result.fail(stockException.getStockResultCode()));
    }
}

package tech.cqxqg.youcai.user.exception;


import tech.cqxqg.youcai.user.constants.StockResultCode;

public class StockException extends RuntimeException{

    private StockResultCode stockResultCode;

    public StockException() {
    }

    public StockException(StockResultCode stockResultCode) {
        super(stockResultCode.getMsg());
        this.stockResultCode = stockResultCode;
    }

    public void setStockResultCode(StockResultCode stockResultCode) {
        this.stockResultCode = stockResultCode;
    }

    public StockResultCode getStockResultCode() {
        return this.stockResultCode;
    }

}

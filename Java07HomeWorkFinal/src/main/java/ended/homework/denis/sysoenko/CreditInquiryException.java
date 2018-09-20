package ended.homework.denis.sysoenko;


class CreditInquiryException extends Throwable {
    public CreditInquiryException(String message) {
        super(message);
    }
}

class CreditOverdraftException extends Throwable{
    public  CreditOverdraftException(String message) {
        super(message);
    }
}

class RetrimentAgeException extends Throwable{
    public  RetrimentAgeException(String message) {
        super(message);
    }
}
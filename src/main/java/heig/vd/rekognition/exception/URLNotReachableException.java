package heig.vd.rekognition.exception;

public class URLNotReachableException extends RuntimeException{
    public URLNotReachableException(String message) {
        super("L'URL fournie n'est pas atteignable: " + message);
    }
}

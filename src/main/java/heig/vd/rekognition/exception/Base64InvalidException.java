package heig.vd.rekognition.exception;

public class Base64InvalidException extends RuntimeException {
    public Base64InvalidException(String message) {
        super("Le base64 n'est pas bien encodé: " + message);
    }
}

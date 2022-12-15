package heig.vd.rekognition.exception;

public class FileTreatmentErrorException extends RuntimeException {
    FileTreatmentErrorException(String message) {
        super("Une erreur lors de l'utilisation de l'image est survenue: " + message);
    }
}

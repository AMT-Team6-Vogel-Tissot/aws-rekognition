package heig.vd.rekognition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.MalformedURLException;
import java.util.Date;

@ControllerAdvice
public class RekognitionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(URLNotReachableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage URLNotReachable(URLNotReachableException e){
        return new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(FileTreatmentErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage FileTreatmentError(FileTreatmentErrorException e){
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Base64InvalidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage Base64Invalid(Base64InvalidException e){
        return new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(), e.getMessage());
    }
}

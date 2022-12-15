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
    @ExceptionHandler(MalformedURLException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage URLNotReachable(MalformedURLException e){
        return new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(FileTreatmentErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage FileTreatmentError(FileTreatmentErrorException e){
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), e.getMessage());
    }
}

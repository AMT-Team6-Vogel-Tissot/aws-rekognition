package heig.vd.rekognition.controller.api;


import heig.vd.rekognition.controller.request.RekognitionRequest;
import heig.vd.rekognition.exception.Base64InvalidException;
import heig.vd.rekognition.exception.URLNotReachableException;
import heig.vd.rekognition.service.AwsLabelDetectorHelperImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Map;


@RestController
public class AppController {
    private final AwsLabelDetectorHelperImpl service;
    public AppController(){ service = new AwsLabelDetectorHelperImpl();}

    private boolean checkURL(String sURL) {
        try{
            URL url = new URL(sURL);

            HttpURLConnection huc = (HttpURLConnection) url.openConnection();

            return huc.getResponseCode() == 200;
        } catch(IOException e) {
            return false;
        }

    }

    @GetMapping("/analyse")
    public Map<String, String> execute(@Valid @RequestBody RekognitionRequest rekognitionRequest) {
        if(!checkURL(rekognitionRequest.source())) {
            throw new URLNotReachableException(rekognitionRequest.source());
        }

        return executeRekognition(rekognitionRequest);
    }

    @GetMapping("/analyse/base64")
    public Map<String, String> executeBase64(@Valid @RequestBody RekognitionRequest rekognitionRequest) {

        try{
            Base64.getDecoder().decode(rekognitionRequest.source());
        } catch (IllegalArgumentException e) {
            throw new Base64InvalidException(rekognitionRequest.source());
        }

        return executeRekognition(rekognitionRequest);
    }

    private Map<String, String> executeRekognition(RekognitionRequest rekognitionRequest){
        Map<String, String> result;
        int maxLabels = rekognitionRequest.maxLabels() == null ? service.getDEFAULT_MAX_LABELS() : rekognitionRequest.maxLabels();
        float minConfidence = rekognitionRequest.minConfidence() == null ? service.getDEFAULT_MIN_CONFIDENCE() : rekognitionRequest.minConfidence();

        try {
            result = service.execute(rekognitionRequest.source(), maxLabels, minConfidence);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}

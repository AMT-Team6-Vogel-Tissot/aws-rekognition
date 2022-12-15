package heig.vd.rekognition.controller.request;

import jakarta.validation.constraints.NotBlank;

public record RekognitionRequest (@NotBlank String url, Integer maxLabels, Float minConfidence) {

}
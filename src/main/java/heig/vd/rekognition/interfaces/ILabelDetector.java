package heig.vd.rekognition.interfaces;

import java.util.Map;

public interface ILabelDetector {

    Map<String, String> execute(String nameObject, int maxLabels, float minConfidence);

    Map<String, String> executeBase64(String base64Image, int maxLabels, float minConfidence);

}

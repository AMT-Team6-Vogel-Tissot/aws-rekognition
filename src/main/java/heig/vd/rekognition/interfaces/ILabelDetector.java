package heig.vd.rekognition.interfaces;

import java.net.MalformedURLException;
import java.util.Map;

public interface ILabelDetector {

    Map<String, String> execute(String nameObject, int maxLabels, float minConfidence) throws MalformedURLException;

    Map<String, String> executeBase64(String base64Image, int maxLabels, float minConfidence);

}

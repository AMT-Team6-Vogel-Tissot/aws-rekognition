package heig.vd.rekognition.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public interface ILabelDetector {

    Map<String, String> execute(String nameObject, int maxLabels, float minConfidence) throws IOException;

    Map<String, String> executeBase64(String base64Image, int maxLabels, float minConfidence);

}

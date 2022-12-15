package heig.vd.rekognition;

import static org.junit.jupiter.api.Assertions.*;

import heig.vd.rekognition.service.RekognitionService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

public class RekognitionServiceTests {

    private final RekognitionService rekognitionService = new RekognitionService();

    private final int maxLabelsNormalCase = rekognitionService.getDefaultMaxLabels();
    private final float minConfidenceNormalCase = rekognitionService.getDefaultMinConfidence();
    private final Path image = Paths.get("src", "test", "resources", "fileTest.jpg");
    private final String testURL = "https://plus.unsplash.com/premium_photo-1663134281768-37fa467e9f5b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80";


    @Test
    void execute_ParametersDefaultValues_ContentFromAwsRekognitionWithoutFilter_url_Success() throws IOException {
        // given

        // when
        Map<String,String> result = rekognitionService.execute(testURL, rekognitionService.getDefaultMaxLabels(), rekognitionService.getDefaultMinConfidence());

        // then
        assertEquals(maxLabelsNormalCase, result.size());
        for (String v : result.values()) {
            assertTrue(Float.parseFloat(v) >= minConfidenceNormalCase);
        }
    }

    @Test
    void execute_MaxLabelsEqual20_ContentFromAwsRekognitionFilterApplied_Success() throws IOException {
        // given
        int maxLabels = 20;

        // when
        Map<String,String> result = rekognitionService.execute(testURL, maxLabels, rekognitionService.getDefaultMinConfidence());

        // then
        assertEquals(maxLabels, result.size());
    }

    @Test
    void execute_MinConfidenceLevelEqual70_ContentFromAwsRekognitionFilterApplied() throws IOException {
        // given
        int minConfidence = 70;

        // when
        Map<String,String> result = rekognitionService.execute(testURL, rekognitionService.getDefaultMaxLabels(), minConfidence);

        // then
        for (String v : result.values()) {
            assertTrue(Float.parseFloat(v) >= minConfidence);
        }
    }

    @Test
    void execute_MaxLabel30AndConfidenceLevel50_ContentFromAwsRekognitionFilterApplied() throws IOException {
        // given
        int maxLabels = 30;
        float minConfidence = 50;

        // when
        Map<String,String> result = rekognitionService.execute(testURL, maxLabels, minConfidence);

        // then
        assertEquals(maxLabels, result.size());
        for (String v : result.values()) {
            assertTrue(Float.parseFloat(v) >= minConfidence);
        }

    }

    @Test
    void executeBase64_ParametersDefaultValues_ContentFromAwsRekognitionWithoutFilter_base64_Success() throws IOException {
        // given
        byte[] content = Files.readAllBytes(image);
        String contentEncodedB64 = Base64.getEncoder().encodeToString(content);

        // when
        Map<String,String> result = rekognitionService.executeBase64(contentEncodedB64, rekognitionService.getDefaultMaxLabels(), rekognitionService.getDefaultMinConfidence());

        // then
        assertEquals(maxLabelsNormalCase, result.size());
        for (String v : result.values()) {
            assertTrue(Float.parseFloat(v) >= minConfidenceNormalCase);
        }
    }

    @Test
    void executeBase64_MaxLabelsEqual20_ContentFromAwsRekognitionFilterApplied_Success() throws IOException {
        // given
        byte[] content = Files.readAllBytes(image);
        String contentEncodedB64 = Base64.getEncoder().encodeToString(content);
        int maxLabels = 20;

        // when
        Map<String,String> result = rekognitionService.executeBase64(contentEncodedB64, maxLabels, rekognitionService.getDefaultMinConfidence());

        // then
        assertEquals(maxLabels, result.size());
    }

    @Test
    void executeBase64_MinConfidenceLevelEqual70_ContentFromAwsRekognitionFilterApplied() throws IOException {
        // given
        byte[] content = Files.readAllBytes(image);
        String contentEncodedB64 = Base64.getEncoder().encodeToString(content);
        int minConfidence = 70;

        // when
        Map<String,String> result = rekognitionService.executeBase64(contentEncodedB64, rekognitionService.getDefaultMaxLabels(), minConfidence);

        // then
        for (String v : result.values()) {
            assertTrue(Float.parseFloat(v) >= minConfidence);
        }
    }

    @Test
    void executeBase64_MaxLabel30AndConfidenceLevel50_ContentFromAwsRekognitionFilterApplied() throws IOException {
        // given
        byte[] content = Files.readAllBytes(image);
        String contentEncodedB64 = Base64.getEncoder().encodeToString(content);
        int maxLabels = 30;
        float minConfidence = 50;

        // when
        Map<String,String> result = rekognitionService.executeBase64(contentEncodedB64, maxLabels, minConfidence);

        // then
        assertEquals(maxLabels, result.size());
        for (String v : result.values()) {
            assertTrue(Float.parseFloat(v) >= minConfidence);
        }

    }
}

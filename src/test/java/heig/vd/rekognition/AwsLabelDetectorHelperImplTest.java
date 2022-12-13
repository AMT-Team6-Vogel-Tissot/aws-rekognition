package heig.vd.rekognition;

import static org.junit.jupiter.api.Assertions.*;

import heig.vd.rekognition.service.AwsLabelDetectorHelperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;

public class AwsLabelDetectorHelperImplTest {

    private final AwsLabelDetectorHelperImpl rekognitionService = new AwsLabelDetectorHelperImpl();

    private final String pathToTestFolder = "./filesTest/";
    private final String image1 = "file1.jpg";
    private final String image1Result = image1 + "-result";
    private final Path path1 = Path.of(this.pathToTestFolder, this.image1);

    private final Map<String, String> correctMapNormalCase = Map.of(
            "Building","98.851166","Campus","83.2322",
            "School","69.49009","Candle","65.13202","Office Building","98.851166",
            "Outdoors","92.17462","City","57.828415","Aerial View","63.52579",
            "Person","74.04278","Convention Center","57.032322"
    );

    private final Map<String, String> correctMapChangeNbLabelsCase = Map.of(
            "Building","98.851166","Campus","83.2322", "Office Building","98.851166",
            "Outdoors","92.17462", "Person", "74.04278"
    );

    private final Map<String, String> correctMapChangeMinConfidenceCase = Map.of(
            "Building","98.851166","Campus","83.2322","Architecture", "98.851166",
            "Office Building","98.851166", "Outdoors","92.17462"
    );

    private final String correctMinValNormalCase = "57.032322";
    private final String correctMinValChangeNbLabelsCase = "74.04278";
    private final String correctMinValChangeMinConfidenceCase = "83.2322";
    private final int correctMaxLabelsMinConfidenceCase = 5;
    private final int maxLabelsNormalCase = 10;
    private final int minConfidenceNormalCase = 50;
    private final int maxLabelsChangeNbLabelsCase = 5;
    private final int minConfidenceChangeNbLabelsCase = 80;


    @Test
    void Analyze_ParametersDefaultValues_ContentFromAwsRekognitionWithoutFilter_url(){

    }

    @Test
    void Analyze_ParametersDefaultValues_ContentFromAwsRekognitionWithoutFilter_base64(){

    }

    @Test
    void Analyze_MaxLabelsEqual20_ContentFromAwsRekognitionFilterApplied(){

    }

    @Test
    void Analyze_MinConfidenceLevelEqual70_ContentFromAwsRekognitionFilterApplied(){

    }

    @Test
    void Analyse_MaxLabel30AndConfidenceLevel50_ContentFromAwsRekognitionFilterApplied(){

    }
}

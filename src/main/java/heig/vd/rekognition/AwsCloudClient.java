package heig.vd.rekognition;

import heig.vd.rekognition.interfaces.ICloudClient;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;

import java.util.Objects;

import heig.vd.rekognition.utils.GetEnvVal;

public class AwsCloudClient implements ICloudClient {


    private final AwsLabelDetectorHelperImpl labelDetector;

    private static AwsCloudClient INSTANCIED = null;

    private final String bucketUrl;

    private AwsCloudClient(){

        Region region = Region.of(Objects.requireNonNull(GetEnvVal.getEnvVal("REGION")));

        StaticCredentialsProvider credentialsProvider = StaticCredentialsProvider
                .create(AwsBasicCredentials.create(GetEnvVal.getEnvVal("AWS_ACCESS_KEY_ID"),
                        GetEnvVal.getEnvVal("AWS_SECRET_ACCESS_KEY")));

        bucketUrl = GetEnvVal.getEnvVal("BUCKET");
        labelDetector = new AwsLabelDetectorHelperImpl(credentialsProvider, region);
    }

    public static AwsCloudClient getInstance() {
        if(INSTANCIED == null){
            INSTANCIED = new AwsCloudClient();
        }
        return INSTANCIED;
    }


    public AwsLabelDetectorHelperImpl getLabelDetector() {
        return labelDetector;
    }

    public String getBucketUrl(){
        return bucketUrl;
    }
}

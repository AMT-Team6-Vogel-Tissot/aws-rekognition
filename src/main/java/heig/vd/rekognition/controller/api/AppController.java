package heig.vd.rekognition.controller.api;


import heig.vd.rekognition.service.AwsLabelDetectorHelperImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.Map;


@RestController
public class AppController {
    private final AwsLabelDetectorHelperImpl service;
    public AppController(){ service = new AwsLabelDetectorHelperImpl();}
    @GetMapping("/analyse")
    public Map<String, String> urlObject(@RequestParam String name, @RequestParam int maxLabels, @RequestParam int minConfidence) throws MalformedURLException {
        return service.execute(name,maxLabels,minConfidence);
    }
}

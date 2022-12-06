package heig.vd.rekognition.controller.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//TODO retourner un json avec l'analyse
@RestController
public class AppController {
    @GetMapping("/analyse")
    public String urlObject(@RequestParam String name, @RequestParam int maxLabels, @RequestParam int minConfidence) {
        return "";
    }
}

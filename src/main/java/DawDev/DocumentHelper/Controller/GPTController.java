package DawDev.DocumentHelper.Controller;

import DawDev.DocumentHelper.GPTModel.GPTRequest;
import DawDev.DocumentHelper.GPTModel.GPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class GPTController {

    @Value("${chatgpt.model}")
    private String model;

    @Value("${chatgpt.api.url}")
    private String apiUrl;

    @Value("${chatgpt.api.key}")
    private String apikey;

    private static final RestTemplate restTemplate = new RestTemplate();

    @PostMapping(value = "/ask", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ask(@RequestBody Map<String, String> data) {
        //User data for our program to handle
        String action = data.get("action");
        String documentDetails = data.get("documentDetails");
        //Combine sentence of action + details
        String query = constructQuery(action, documentDetails);

        //Pass 3.5 Turbo model and User messages
        GPTRequest request = new GPTRequest(model, query);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apikey);
        GPTResponse chatgptResponse = restTemplate.postForObject(apiUrl,
                new HttpEntity<>(request, headers),
                GPTResponse.class);

        assert chatgptResponse != null;
        return chatgptResponse.getChoices().get(0).getMessage().getContent();
    }

    private String constructQuery(String action, String documentDetails) {
        return action + ": " + documentDetails;
    }

    // Private method to check API usage
}

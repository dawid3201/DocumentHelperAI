package DawDev.DocumentHelper.GPTModel;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GPTRequest {
    //GPT has 2 requests model and message
    private String model; //3.5
    private List<Message> messages = new ArrayList<>();// User message

    public GPTRequest(String model, String message) {
        this.model = model;
        this.messages.add(new Message("user", message));
    }
}

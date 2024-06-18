package DawDev.DocumentHelper.GPTModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GPTResponse {
    //List of choices attribute
    private List<Choice> choices;
}

package DawDev.DocumentHelper.GPTModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    //To response this model needs index and message
    private int index;
    private Message message;
}

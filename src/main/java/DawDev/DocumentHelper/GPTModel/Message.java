package DawDev.DocumentHelper.GPTModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    //Message needs role and content
    private String role;
    private String content;
}

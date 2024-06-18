package DawDev.DocumentHelper.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping("/")
    public String getIndexPage(){
        return "Index";
    }
}

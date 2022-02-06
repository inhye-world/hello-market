package inhye.hellomarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    //웹을 쳐서 들어가면 스프링컨테이너에 해당하는 컨트롤러가 있는지 확인 후
    //없으면 index로 맵핑해준다
    public String home(){
        return "home";
    }
}

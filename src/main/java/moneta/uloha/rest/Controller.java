package moneta.uloha.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RestService restService;

    @RequestMapping(value = "/moneta/transform", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String transformText(@RequestBody String text){
        return restService.transform(text);
    }

}


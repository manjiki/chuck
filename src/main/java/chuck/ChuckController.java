package chuck;
/**
 * Created by manji on 5/26/16.
 */


import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Random;


@RestController
public class ChuckController {
    private RestTemplate restTemplate = new RestTemplate();
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    FortunesRepository fortunesRepository;

    @RequestMapping("/chuck")
    public String giveMeAChuck() throws IOException{
        String htmlTemplate;
        Chuck quote = restTemplate.getForObject(chuckAPI, Chuck.class);
        try (InputStream tmpl = this.getClass().getClassLoader().getResourceAsStream("index.html")) {
            htmlTemplate = StreamUtils.copyToString(tmpl, Charset.forName("UTF-8"));
            htmlTemplate = (htmlTemplate == null) ? "" : htmlTemplate;
        }
        String html= String.format(htmlTemplate, quote.getValue().getJoke().toString());
        return html;
        /*return quote.getValue().getJoke();*/
    }
   @RequestMapping("/fortune")
    public String randomFortume(){
        Long range = fortunesRepository.count();
        Integer quote = new Random().nextInt(range.intValue());
       Fortune fortune_cookie = fortunesRepository.findById(quote);
        return fortune_cookie.getText();
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name){
        return "Hello " + name;

    }

    @Value("${server.zone}")
    public String serverZone;

    @Value("${chuck.api}")
    public String chuckAPI;

    @RequestMapping("/zone")
    public String getzone() {
    return serverZone;
    }



    public static Integer plus(int oneNumber, int twoNumber){
        return oneNumber+twoNumber;
    }
}

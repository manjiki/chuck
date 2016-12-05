package chuck;
/**
 * Created by manji on 5/26/16.
 */


import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**import org.springframework.beans.factory.annotation.Autowired;**/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class ChuckController {
    private RestTemplate restTemplate = new RestTemplate();
    private final AtomicLong counter = new AtomicLong();
    /**@Autowired
    FortunesRepository fortunesRepository;**/

    @RequestMapping("/")
    public String giveMeAChuck(){
        Chuck quote = restTemplate.getForObject("http://api.icndb.com/jokes/random", Chuck.class);
        String html= String.format("<html>" +
                "<link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>" +
                "<link href='http://fonts.googleapis.com/css?family=Cabin' rel='stylesheet' type='text/css'>"+
                "<style> " +
                "h1 { font: 400 100px/1.3 'Lobster', Helvetica, sans-serif; color: #2b2b2b; text-shadow: 2px 2px 0px rgba(0,0,0,0.1);text-align: center;}" +
                "body {background-color: powderblue;}" +
                "p {font: 18px 'Cabin'; text-align: center;}" +
                "</style>"+
                "<body><p><img src=\"/static/images/chuck.jpg\" align=\"middle\"></p>    "+
        "<h1> Chuck Says</h1> <p>%s <br>" +
                "</p><br><br> <p><img src=\"/static/images/chuck1.jpg\" align=\"middle\"><img src=\"/static/images/chuck2.jpg\" align=\"middle\"></body></html>",
                quote.getValue().getJoke().toString());
        return html;
        /*return quote.getValue().getJoke();*/
    }
    /**@RequestMapping("/fortune")
    public String randomFortume(){
        Long range = fortunesRepository.count();
        Integer quote = new Random().nextInt(range.intValue());
        Fortune fortune_cookie = fortunesRepository.findById(quote);
        return fortune_cookie.getText();
    }**/

    @Value("${server.zone}")
    public String serverZone;

    @RequestMapping("/zone")
    public String getzone() {
    return serverZone;
    }



    public static Integer plus(int oneNumber, int twoNumber){
        return oneNumber+twoNumber;
    }
}

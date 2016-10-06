import chuck.ChuckController;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by manji on 5/26/16.
 */
public class HelloTest {
    @Test
    public void testOne() {
        Assert.assertEquals(ChuckController.plus(1,1), new Integer (2));
    }
}

package ejb;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

@Stateful(name = "counterEJB")
@StatefulTimeout(20)
public class counterBean {
    private static int i = 0;
    public void incr(){
        i++;
    }
    public int getI(){
        return i;
    }
    public counterBean() {
    }
}

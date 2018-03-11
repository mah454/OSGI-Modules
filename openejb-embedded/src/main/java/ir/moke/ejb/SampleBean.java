package ir.moke.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SampleBean {
    public void sum() {
        System.out.println("1 + 1 = 2");
    }
}

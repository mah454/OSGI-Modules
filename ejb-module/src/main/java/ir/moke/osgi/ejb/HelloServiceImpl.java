package ir.moke.osgi.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello Mahdi");
    }
}

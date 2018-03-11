package ir.moke.osgi.ejb;

import javax.ejb.Remote;

@Remote
public interface  HelloService {
    void sayHello();
}

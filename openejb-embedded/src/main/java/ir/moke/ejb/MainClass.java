package ir.moke.ejb;

import org.apache.openejb.OpenEjbContainer;
import org.apache.openejb.core.LocalInitialContextFactory;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class MainClass {
    private static final String applicationName = "DemoMain";
    private CountDownLatch started = new CountDownLatch(1) ;
    public static void main(String[] args) throws NamingException, InterruptedException {
        final Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());
        properties.setProperty(OpenEjbContainer.OPENEJB_EMBEDDED_REMOTABLE, Boolean.TRUE.toString());
        final EJBContainer container = EJBContainer.createEJBContainer(properties);
        final CountDownLatch latch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            latch.countDown();
            container.close();
        }));

        latch.await();
    }


    public void run() throws NamingException {
        EJBContainer ejbContainer = null ;

        final Properties properties = new Properties();
        properties.setProperty(EJBContainer.APP_NAME,applicationName );
        properties.setProperty(EJBContainer.PROVIDER, OpenEjbContainer.class.getName());
        properties.setProperty(OpenEjbContainer.OPENEJB_EMBEDDED_REMOTABLE, "false");
        properties.setProperty("ejbd.disabled", "true");
        properties.setProperty("ejbds.disabled", "true");
        properties.setProperty("admin.disabled", "true");
        properties.setProperty("openejb.jaxrs.application", "false");

        ejbContainer = EJBContainer.createEJBContainer(properties);
        ejbContainer.getContext().bind("inject",this);
        started.countDown();
    }
}

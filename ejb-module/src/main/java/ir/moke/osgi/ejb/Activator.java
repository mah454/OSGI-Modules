package ir.moke.osgi.ejb;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Start OSGI Bundle");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Stop OSGI Bundle");
    }
}

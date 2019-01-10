import java.io.File;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLClassLoader;

public class Application {
    private Class clazz;
    private Object instance;
    private Object port;

    public void  executeMethod() {
        System.out.println("--- executeMethod");

        try {
            Method method = port.getClass().getDeclaredMethod("execute", BigInteger.class, BigInteger.class);
            System.out.println(method);
            BigInteger value01 = new BigInteger("1");
            BigInteger value02 = new BigInteger("60");
            method.invoke(port,value01,value02);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    public void loadClazzFromJavaArchive() {
        try {
            URL[] urls = {new File(Configuration.instance.subFolderPathOfJavaArchive).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls,Application.class.getClassLoader());
            clazz = Class.forName(Configuration.instance.nameOfClass,true,urlClassLoader);
            System.out.println("class    : " + clazz.toString() + " - " + clazz.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void provideInstanceOfClass() {
        try {
            instance = clazz.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            System.out.println("instance : " + instance.toString() + " - " + instance.hashCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void provideComponentPort() {
        try {
            port = clazz.getDeclaredField("port").get(instance);
            System.out.println("port     : " + port.toString() + " - " + port.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        Configuration.instance.print();
        loadClazzFromJavaArchive();
        provideInstanceOfClass();
        provideComponentPort();
        System.out.println();
        executeMethod();
    }

    public static void main(String... args) {
        Application application = new Application();
        application.execute();
    }
}
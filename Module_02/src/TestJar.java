import by.incubator.Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestJar {
    public static void main(String[] args) throws RuntimeException {

        try {

            URL urls = new URL("file:/D:/Java/2025/java_Program/out2/example.jar");
            URLClassLoader urcl= new URLClassLoader(new URL[] {urls});
            Class<?> clazz = urcl.loadClass("by.incubator.Main");
            Method mainMethod = clazz.getDeclaredMethod("main",String[].class);
            mainMethod.invoke(null,(Object) new String[]{});



        } catch (MalformedURLException |
                 ClassNotFoundException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            Main instance = Main.class.newInstance();
            String[] arg = new String[]{""};
            instance.main(arg);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



    }
}


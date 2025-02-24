import java.sql.DriverManager;
import java.util.ArrayList;
class Maxi{

}
public class PrintClassLoader {
    static class Mini{

    }
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    //public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    //public static final String BOLD = "\u001B[1m";

    public static void main(String[] args)  {
        //printClassLoader();

        Class<PrintClassLoader> pcl=PrintClassLoader.class;
        PrintClassLoader obj = new PrintClassLoader();
        Class<PrintClassLoader> pcl2= (Class<PrintClassLoader>) obj.getClass();
        Class<Integer> I=Integer.class;
        Class<Boolean> B=Boolean.class;
        Class<Mini> M=Mini.class;
        Class<Maxi> maxi=Maxi.class;
        printLoader(pcl);
        printLoader(pcl2);
        printLoader(I);
        printLoader(B);
        printLoader(M);
        printLoader(maxi);




    }
    public static void printLoader( Class<?> A){
        System.out.println("Класс "+ BLUE+A+RESET);
        System.out.println("Загрузчик "+GREEN+ A.getClassLoader()+RESET);
        if(A.getClassLoader()!=null) {
        System.out.println("Родительский элемент "+PURPLE+ A.getClassLoader().getParent()+RESET);
        }
        else {
            System.out.println(); return;}
        if(A.getClassLoader().getParent()!=null) {
            System.out.println("Родительский элемент родителя " +CYAN+ A.getClassLoader().getParent().getParent()+RESET);
        }
        System.out.println();
    }

    public static void printClassLoader() throws ClassNotFoundException{
        System.out.println("Platform ClassLoader:        " + ClassLoader.getPlatformClassLoader());
        System.out.println("System ClassLoader:          " + ClassLoader.getSystemClassLoader());
        System.out.println("ClassLoader of this class:   " + PrintClassLoader.class.getClassLoader());
        System.out.println("ClassLoader of DriverManager:" + DriverManager.class.getClassLoader());
        System.out.println("ClassLoader of ArrayList:    " + ArrayList.class.getClassLoader());
    }


}
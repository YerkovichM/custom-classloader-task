package classloader;

import java.lang.reflect.Method;

public class Main {

    private final static String textServiceUpdatableClassPath = "classloader.TextServiceUpdatable";
    private final static String classPath = "C:\\Users\\yerko\\IdeaProjects\\custom-classloader-task\\target\\classes";

    public static void main(String[] args) throws Exception {
        taskClassLoader();
    }

    public static void taskClassLoader() throws Exception {
        while (true) {
            DynamicClassLoader loader = new DynamicClassLoader(new String[]{classPath});
            Class<?> aClass = Class.forName(textServiceUpdatableClassPath, true, loader);
            Method staticTextMethod = aClass.getMethod("staticText");
            Object textService = aClass.getDeclaredConstructor().newInstance();
            System.out.println(staticTextMethod.invoke(textService));
            System.in.read();
        }
    }
}

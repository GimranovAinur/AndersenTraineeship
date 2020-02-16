package andersen.course.custom_classloader;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        Path path = Paths.get("jar-path");
        CustomClassLoader classLoader = new CustomClassLoader(path);
        classLoader.findClass("ClassName");
    }
}

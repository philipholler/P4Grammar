package codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class JavaFileWriter { // todo very very temporary implementation

    private static final String outDir = System.getProperty("user.dir") +
            "/GeneratedModule/src/main/java/";


    public static void writeClass(ClassBuilder classBuilder){
        String packagePath = outDir + classBuilder.getPackage() + File.separator;
        new File(packagePath).mkdirs();

        try (PrintWriter printWriter = new PrintWriter(packagePath +
                classBuilder.getClassName() + ".java")){
            printWriter.print(classBuilder.toString());
        } catch (FileNotFoundException e) {
            // todo exception handling. Lol.
            e.printStackTrace();
        }
    }


}

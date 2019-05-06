package codegen;

import compiler.Compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JavaFileWriter { // todo very very temporary implementation

    private static final String outDir = System.getProperty("user.dir") + File.separator + Compiler.GENERATED_OUTPUT_FILES_DIR;


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

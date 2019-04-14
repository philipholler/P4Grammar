package codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JavaFileWriter { // todo very very temporary implementation

    private static final String outDir = System.getProperty("user.dir") +
            File.separator + "compiled_code" + File.separator;


    public static void writeClass(CodeBuilder codeBuilder){
        String packagePath = outDir + codeBuilder.getPackage() + File.separator;
        new File(packagePath).mkdirs();

        try (PrintWriter printWriter = new PrintWriter(packagePath +
                codeBuilder.getClassName() + ".java")){
            printWriter.print(codeBuilder.toString());
        } catch (FileNotFoundException e) {
            // todo exception handling. Lol.
            e.printStackTrace();
        }
    }


}

package codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JavaFileWriter {

    private static final String outDir = System.getProperty("user.dir") +
            File.separator + "compiled_code" + File.separator;

    public static void main(String[] args) {
        ClassBuilder classBuilder = new ClassBuilder();
        classBuilder.addClassDefinition("TestClass", "SuperClassSample");

        classBuilder.appendMethod("setValues", JavaType.VOID,
                new JavaInputParameter(JavaType.INT, "value1"),
                new JavaInputParameter(JavaType.INT, "value2"));

        classBuilder.appendVarDecl(JavaType.INT, "a");
        classBuilder.appendAssignment("a", "31435");

        classBuilder.appendVarDecl(JavaType.INT, "b", "5");
        classBuilder.appendMethodCall("setValues", "a", "b");

        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);


        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        writeClass(classBuilder);
    }


    public static void writeClass(ClassBuilder classBuilder){
        try (PrintWriter printWriter = new PrintWriter(outDir + classBuilder.getClassName() + ".java")){
            printWriter.print(classBuilder.getClassCode());
        } catch (FileNotFoundException e) {
            // todo exception handling. Lol.
            e.printStackTrace();
        }
    }


}

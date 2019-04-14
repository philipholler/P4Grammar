package codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JavaFileWriter { // todo very very temporary implementation

    private static final String outDir = System.getProperty("user.dir") +
            File.separator + "compiled_code" + File.separator;

    public static void main(String[] args) {
        ClassBuilder classBuilder = new ClassBuilder("device");
        classBuilder.appendClassDef("TestClass", "SuperClassSample");

        classBuilder.appendMethod("setValues", JavaType.VOID.keyword,
                new JavaInputParameter(JavaType.INT.keyword, "value1"),
                new JavaInputParameter(JavaType.INT.keyword, "value2"));

        classBuilder.appendPrimitiveDecl(JavaType.INT, "a");
        classBuilder.appendAssignment("a", "31435");

        classBuilder.appendPrimitiveDecl(JavaType.INT, "b", "5");
        classBuilder.appendMethodCall("setValues", "a", "b");

        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        writeClass(classBuilder);
    }


    public static void writeClass(ClassBuilder classBuilder){
        String packagePath = outDir + classBuilder.getPackage() + File.separator;
        new File(packagePath).mkdirs();

        try (PrintWriter printWriter = new PrintWriter(packagePath +
                classBuilder.getClassName() + ".java")){
            printWriter.print(classBuilder.getClassCode());
        } catch (FileNotFoundException e) {
            // todo exception handling. Lol.
            e.printStackTrace();
        }
    }


}

package compiler;

import node.ProgramNode;
import node.base.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;
import pivot.PivotLexer;
import pivot.PivotParser;
import visitor.*;
import visitor.codegen.ClassGenerationVisitor;
import visitor.codegen.EventInitializationVisitor;
import visitor.codegen.MainGenerationVisitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Compiler {

    public static String SOURCE_FILE_DIR = "testProgramsPivot/";
    public static String SOURCE_FILE = SOURCE_FILE_DIR + "kodeEksempelRapport.pvt";
    public static boolean COMPILER_DEBUG_MODE = true;
    public static String GENERATED_FILES_DIR = "GeneratedModule/src/main/java/";


    public static void main(String[] args) {

        try{
            // Input test file name. The rest creates the lexer and parser.
            CharStream cs = fromFileName(SOURCE_FILE);
            PivotLexer lexer = new PivotLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            PivotParser parser = new PivotParser(token);

            // Create parse tree with parser
            ParseTree tree = parser.program();

            // Visit with AstBuilderVisitor to create ast
            AstBuilderVisitor astVisitor = new AstBuilderVisitor();
            Node ast = astVisitor.visit(tree);

            // Print ast. Use the Node.getTreeString() to pretty-print the AST.
            System.out.println(ast.getTreeString(0));

            // Decorate AST using all visitors
            decorateAST(ast);

            // Print the symbol table, which is found inside the first node of type ProgramNode
            System.out.println(((ProgramNode)ast).getSt());

            // Optimise expressions
            optimiseExpr(ast);

            // Print new AST
            System.out.println(ast.getTreeString(0));

            // Delete old generated program
            deleteOldGeneratedFiles();

            // Generate code
            generateJavaCode(ast);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteOldGeneratedFiles(){
        File generatedFiles = new File(GENERATED_FILES_DIR);

        if(generatedFiles.exists()){
            // Remove all generated files
            for (File f: Objects.requireNonNull(generatedFiles.listFiles())) {
                if(!f.getName().equals("TempToDelete") ){
                    if(f.isDirectory()){
                        try {
                            FileUtils.deleteDirectory(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(f.isFile()){
                        f.delete();
                    }
                }
            }
        }

    }

    private static void generateJavaCode(Node ast){
        ast.accept(new ClassGenerationVisitor());

        ast.accept(new MainGenerationVisitor());

        ast.accept(new EventInitializationVisitor());
    }

    private static void decorateAST(Node ast){
        ast.accept(new FunctionVisitor());

        ast.accept(new DeclarationVisitor());

        ast.accept(new TypeAssignmentVisitor());

        ast.accept(new TypeCheckerVisitor());
    }

    private static void optimiseExpr(Node ast){
        ast.accept(new OptimiseExprVisitor());
    }


    private static void generateByteCode(Node ast){
        JasminVisitor jv = new JasminVisitor();
        //System.out.println(jv.visit(ast));
        try {
            PrintWriter pw = new PrintWriter("PivotClass.j");
            pw.write(jv.visit(ast).toString());
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setSourceFileDir(String sourceFileDir) {
        SOURCE_FILE_DIR = sourceFileDir;
    }

    public static void setSourceFile(String sourceFile) {
        SOURCE_FILE = SOURCE_FILE_DIR + sourceFile;
    }

    public static void setCompilerDebugMode(boolean compilerDebugMode) {
        COMPILER_DEBUG_MODE = compilerDebugMode;
    }

    public static void setGeneratedFilesDir(String generatedFilesDir) {
        GENERATED_FILES_DIR = generatedFilesDir;
    }

    public static String getSourceFileDir() {
        return SOURCE_FILE_DIR;
    }

    public static String getSourceFile() {
        return SOURCE_FILE;
    }

    public static boolean isCompilerDebugMode() {
        return COMPILER_DEBUG_MODE;
    }

    public static String getGeneratedFilesDir() {
        return GENERATED_FILES_DIR;
    }
}

package main;

import antlr.PivotLexer;
import antlr.PivotParser;
import node.base.Node;
import visitor.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static final String SOURCE_FILE = "testProgram";
    public static final boolean COMPILER_DEBUG_MODE = true;

    public static void main(String[] args) {

        try{
            // Input test file name. The rest creates the lexer and parser.
            CharStream cs = fromFileName(SOURCE_FILE);
            PivotLexer lexer = new PivotLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            PivotParser parser = new PivotParser(token);

            // Print parse tree
            //ParseTreePrinter parseTreePrinter = new ParseTreePrinter();
            //parseTreePrinter.print(parser.program());

            // Create parse tree with parser
            ParseTree tree = parser.program();

            // Visit with AstBuilderVisitor to create ast
            AstBuilderVisitor astVisitor = new AstBuilderVisitor();
            Node ast = astVisitor.visit(tree);

            // Print ast. Use the Node.getTreeString() to pretty-print the AST.
            System.out.println(ast.getTreeString(0));

            // Dispatch all AST-visitors and print out the symbol table
            dispatchASTVisitors(ast);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void dispatchASTVisitors(Node ast){
        FunctionVisitor fv = new FunctionVisitor();
        ast.accept(fv);

        DeclarationVisitor dclVisitor = new DeclarationVisitor(fv.getSt());
        ast.accept(dclVisitor);

        TypeAssignmentVisitor typeAssignmentVisitor = new TypeAssignmentVisitor(dclVisitor.getSt());
        ast.accept(typeAssignmentVisitor);

        TypeCheckerVisitor typeCheckVisitor = new TypeCheckerVisitor(typeAssignmentVisitor.getSt());
        ast.accept(typeCheckVisitor);

        System.out.println(typeCheckVisitor.getSt());
    }
}

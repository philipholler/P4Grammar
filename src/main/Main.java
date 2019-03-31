package main;

import ANTLR.PivotLexer;
import ANTLR.PivotParser;
import node.base.Node;
import visitor.AstBuilderVisitor;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static final String sourceFile = "declSignal";

    public static void main(String[] args) {

        try{
            // Input test file name. The rest creates the lexer and parser.
            CharStream cs = fromFileName(sourceFile);
            PivotLexer lexer = new PivotLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            PivotParser parser = new PivotParser(token);

            // Print parse tree
            // ParseTreePrinter parseTreePrinter = new ParseTreePrinter();
            // parseTreePrinter.print(parser.program());

            // Create parse tree with parser
            ParseTree tree = parser.program();

            // Visit with AstBuilderVisitor to create ast
            AstBuilderVisitor astVisitor = new AstBuilderVisitor();
            Node ast = astVisitor.visit(tree);

            // Print the AST using the printVisitor (NOT PRETTY)
            //PrintASTVisitor printVisitor = new PrintASTVisitor();
            //System.out.println(ast.accept(printVisitor));

            // Use the Node.getTreeString() to pretty-print the AST.
            System.out.println(ast.getTreeString(0));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

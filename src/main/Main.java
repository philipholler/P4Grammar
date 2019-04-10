package main;

import antlr.PivotLexer;
import antlr.PivotParser;
import node.base.Node;
import visitor.AstBuilderVisitor;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitor.DeclarationVisitor;
import visitor.JasminVisitor;
import visitor.FunctionVisitor;

import java.io.IOException;
import java.io.PrintWriter;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static final String sourceFile = "testProgram";

    public static void main(String[] args) {

        try{
            // Input test file name. The rest creates the lexer and parser.
            CharStream cs = fromFileName(sourceFile);
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

            FunctionVisitor fv = new FunctionVisitor();
            ast.accept(fv);

            DeclarationVisitor dclVisitor = new DeclarationVisitor(fv.getSt());
            ast.accept(dclVisitor);
            System.out.println(dclVisitor.getSt());

           //Jasmin Visitor
            //Creates Jasmine file and writes to filepath
            /*
            JasminVisitor jv = new JasminVisitor();
            PrintWriter pw = new PrintWriter("C:\\Users\\Mads\\Desktop\\testmappe\\helloworld.j");
            pw.println(jv.visit(ast));
            pw.flush();*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

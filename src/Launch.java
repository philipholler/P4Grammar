import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {
    public static void main(String[] args) {
        try{
            String source = "testProgram";
            CharStream cs = fromFileName(source);
            PivotLexer lexer = new PivotLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            PivotParser parser = new PivotParser(token);
            ParseTree tree = parser.program();

            PivotBaseVisitor<Object> visitor = new PivotBaseVisitor<>();
            visitor.visit(tree);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package compiler;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ParserThrowingErrorListener extends BaseErrorListener {

    public static final ParserThrowingErrorListener INSTANCE = new ParserThrowingErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException {
        int i = Compiler.getSourceFile().lastIndexOf('/');
        throw new ParseCancellationException("\n\n Could not parse program. Error at " + "Pivot.(" + Compiler.getSourceFile().substring(i+1) + ":" + line + ")\n");
    }
}
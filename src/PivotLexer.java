// Generated from /Users/philip/Library/Mobile Documents/com~apple~CloudDocs/Cloud dokumenter/Java projects/P4Grammar/Pivot.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PivotLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WhiteSpace=1, NewLine=2, LINE_COMMENT=3, AND=4, OR=5, GT=6, GE=7, LT=8, 
		LE=9, EQ=10, NE=11, TRUE=12, FALSE=13, SIGNALKW=14, INPUTKW=15, OUTPUTKW=16, 
		DEVICE=17, DEFINEKW=18, IF=19, WHILE=20, INITFUNCKW=21, VOID=22, WHEN=23, 
		EVERY=24, MS=25, SECONDS=26, MINUTES=27, HOURS=28, DAYS=29, WEEKS=30, 
		MONTHS=31, WAIT=32, STRINGKW=33, INTEGERKW=34, FLOATKW=35, SET=36, GET=37, 
		EXCEEDS=38, DECEEDS=39, NOW=40, ELSE=41, RETURN=42, BREAK=43, AT=44, PARANBEG=45, 
		PARANEND=46, BLCKBEG=47, BLCKEND=48, EQUALS=49, PLUS=50, MINUS=51, DIV=52, 
		MULT=53, RANGESEP=54, SEMCOL=55, LISTSEP=56, QUOT=57, COL=58, AMP=59, 
		STARTING=60, DATE=61, DATEnoYEAR=62, FLOAT=63, TIME=64, IP=65, INTEGER=66, 
		STRING=67, ID=68, SIGN=69;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WhiteSpace", "NewLine", "LINE_COMMENT", "NEWLINE", "LOWERCASE", "UPPERCASE", 
			"DIGIT", "AND", "OR", "GT", "GE", "LT", "LE", "EQ", "NE", "TRUE", "FALSE", 
			"SIGNALKW", "INPUTKW", "OUTPUTKW", "DEVICE", "DEFINEKW", "IF", "WHILE", 
			"INITFUNCKW", "VOID", "WHEN", "EVERY", "MS", "SECONDS", "MINUTES", "HOURS", 
			"DAYS", "WEEKS", "MONTHS", "WAIT", "STRINGKW", "INTEGERKW", "FLOATKW", 
			"SET", "GET", "EXCEEDS", "DECEEDS", "NOW", "ELSE", "RETURN", "BREAK", 
			"AT", "PARANBEG", "PARANEND", "BLCKBEG", "BLCKEND", "EQUALS", "PLUS", 
			"MINUS", "DIV", "MULT", "RANGESEP", "SEMCOL", "LISTSEP", "QUOT", "COL", 
			"AMP", "STARTING", "DATE", "DATEnoYEAR", "FLOAT", "TIME", "IP", "INTEGER", 
			"STRING", "ID", "SIGN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'&&'", "'||'", "'>'", "'>='", "'<'", "'<='", 
			"'=='", "'!='", "'true'", "'false'", "'Signal'", "'input'", "'output'", 
			"'Device'", "'define'", "'if'", "'while'", "'init'", "'void'", "'when'", 
			"'every'", "'ms'", "'seconds'", "'minutes'", "'hours'", "'days'", "'weeks'", 
			"'months'", "'wait'", "'string'", "'int'", "'float'", "'set'", "'get'", 
			"'exceeds'", "'deceeds'", "'now'", "'else'", "'return'", "'break'", "'at'", 
			"'('", "')'", "'{'", "'}'", "'='", "'+'", "'-'", "'/'", "'*'", "'..'", 
			"';'", "','", "'\"'", "':'", "'&'", "'starting'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WhiteSpace", "NewLine", "LINE_COMMENT", "AND", "OR", "GT", "GE", 
			"LT", "LE", "EQ", "NE", "TRUE", "FALSE", "SIGNALKW", "INPUTKW", "OUTPUTKW", 
			"DEVICE", "DEFINEKW", "IF", "WHILE", "INITFUNCKW", "VOID", "WHEN", "EVERY", 
			"MS", "SECONDS", "MINUTES", "HOURS", "DAYS", "WEEKS", "MONTHS", "WAIT", 
			"STRINGKW", "INTEGERKW", "FLOATKW", "SET", "GET", "EXCEEDS", "DECEEDS", 
			"NOW", "ELSE", "RETURN", "BREAK", "AT", "PARANBEG", "PARANEND", "BLCKBEG", 
			"BLCKEND", "EQUALS", "PLUS", "MINUS", "DIV", "MULT", "RANGESEP", "SEMCOL", 
			"LISTSEP", "QUOT", "COL", "AMP", "STARTING", "DATE", "DATEnoYEAR", "FLOAT", 
			"TIME", "IP", "INTEGER", "STRING", "ID", "SIGN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PivotLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pivot.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2G\u020d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u00a2\n"+
		"\4\f\4\16\4\u00a5\13\4\3\4\3\4\3\5\5\5\u00aa\n\5\3\5\3\5\5\5\u00ae\n\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3"+
		"/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3"+
		"\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3"+
		";\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3"+
		"B\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3D\5D\u01c5\nD\3D\6D\u01c8"+
		"\nD\rD\16D\u01c9\3D\3D\6D\u01ce\nD\rD\16D\u01cf\3E\3E\3E\3E\3E\3E\3F\6"+
		"F\u01d9\nF\rF\16F\u01da\3F\3F\6F\u01df\nF\rF\16F\u01e0\6F\u01e3\nF\rF"+
		"\16F\u01e4\3F\3F\6F\u01e9\nF\rF\16F\u01ea\3G\5G\u01ee\nG\3G\6G\u01f1\n"+
		"G\rG\16G\u01f2\3H\3H\3H\3H\3H\6H\u01fa\nH\rH\16H\u01fb\3H\3H\3I\3I\5I"+
		"\u0202\nI\3I\3I\3I\7I\u0207\nI\fI\16I\u020a\13I\3J\3J\2\2K\3\3\5\4\7\5"+
		"\t\2\13\2\r\2\17\2\21\6\23\7\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20"+
		"\'\21)\22+\23-\24/\25\61\26\63\27\65\30\67\319\32;\33=\34?\35A\36C\37"+
		"E G!I\"K#M$O%Q&S\'U(W)Y*[+],_-a.c/e\60g\61i\62k\63m\64o\65q\66s\67u8w"+
		"9y:{;}<\177=\u0081>\u0083?\u0085@\u0087A\u0089B\u008bC\u008dD\u008fE\u0091"+
		"F\u0093G\3\2\b\4\2\13\13\"\"\4\2\f\f\17\17\3\2c|\3\2C\\\3\2\62;\6\2\""+
		"#/\60<<aa\2\u021c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\3\u0095\3\2\2\2\5\u0099\3\2\2\2\7\u009d\3\2\2\2\t\u00ad"+
		"\3\2\2\2\13\u00af\3\2\2\2\r\u00b1\3\2\2\2\17\u00b3\3\2\2\2\21\u00b5\3"+
		"\2\2\2\23\u00b8\3\2\2\2\25\u00bb\3\2\2\2\27\u00bd\3\2\2\2\31\u00c0\3\2"+
		"\2\2\33\u00c2\3\2\2\2\35\u00c5\3\2\2\2\37\u00c8\3\2\2\2!\u00cb\3\2\2\2"+
		"#\u00d0\3\2\2\2%\u00d6\3\2\2\2\'\u00dd\3\2\2\2)\u00e3\3\2\2\2+\u00ea\3"+
		"\2\2\2-\u00f1\3\2\2\2/\u00f8\3\2\2\2\61\u00fb\3\2\2\2\63\u0101\3\2\2\2"+
		"\65\u0106\3\2\2\2\67\u010b\3\2\2\29\u0110\3\2\2\2;\u0116\3\2\2\2=\u0119"+
		"\3\2\2\2?\u0121\3\2\2\2A\u0129\3\2\2\2C\u012f\3\2\2\2E\u0134\3\2\2\2G"+
		"\u013a\3\2\2\2I\u0141\3\2\2\2K\u0146\3\2\2\2M\u014d\3\2\2\2O\u0151\3\2"+
		"\2\2Q\u0157\3\2\2\2S\u015b\3\2\2\2U\u015f\3\2\2\2W\u0167\3\2\2\2Y\u016f"+
		"\3\2\2\2[\u0173\3\2\2\2]\u0178\3\2\2\2_\u017f\3\2\2\2a\u0185\3\2\2\2c"+
		"\u0188\3\2\2\2e\u018a\3\2\2\2g\u018c\3\2\2\2i\u018e\3\2\2\2k\u0190\3\2"+
		"\2\2m\u0192\3\2\2\2o\u0194\3\2\2\2q\u0196\3\2\2\2s\u0198\3\2\2\2u\u019a"+
		"\3\2\2\2w\u019d\3\2\2\2y\u019f\3\2\2\2{\u01a1\3\2\2\2}\u01a3\3\2\2\2\177"+
		"\u01a5\3\2\2\2\u0081\u01a7\3\2\2\2\u0083\u01b0\3\2\2\2\u0085\u01bc\3\2"+
		"\2\2\u0087\u01c4\3\2\2\2\u0089\u01d1\3\2\2\2\u008b\u01d8\3\2\2\2\u008d"+
		"\u01ed\3\2\2\2\u008f\u01f4\3\2\2\2\u0091\u0201\3\2\2\2\u0093\u020b\3\2"+
		"\2\2\u0095\u0096\t\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\2\2\2\u0098"+
		"\4\3\2\2\2\u0099\u009a\5\t\5\2\u009a\u009b\3\2\2\2\u009b\u009c\b\3\2\2"+
		"\u009c\6\3\2\2\2\u009d\u009e\7\61\2\2\u009e\u009f\7\61\2\2\u009f\u00a3"+
		"\3\2\2\2\u00a0\u00a2\n\3\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a6\u00a7\b\4\2\2\u00a7\b\3\2\2\2\u00a8\u00aa\7\17\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\7\f\2\2\u00ac"+
		"\u00ae\7\17\2\2\u00ad\u00a9\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\n\3\2\2"+
		"\2\u00af\u00b0\t\4\2\2\u00b0\f\3\2\2\2\u00b1\u00b2\t\5\2\2\u00b2\16\3"+
		"\2\2\2\u00b3\u00b4\t\6\2\2\u00b4\20\3\2\2\2\u00b5\u00b6\7(\2\2\u00b6\u00b7"+
		"\7(\2\2\u00b7\22\3\2\2\2\u00b8\u00b9\7~\2\2\u00b9\u00ba\7~\2\2\u00ba\24"+
		"\3\2\2\2\u00bb\u00bc\7@\2\2\u00bc\26\3\2\2\2\u00bd\u00be\7@\2\2\u00be"+
		"\u00bf\7?\2\2\u00bf\30\3\2\2\2\u00c0\u00c1\7>\2\2\u00c1\32\3\2\2\2\u00c2"+
		"\u00c3\7>\2\2\u00c3\u00c4\7?\2\2\u00c4\34\3\2\2\2\u00c5\u00c6\7?\2\2\u00c6"+
		"\u00c7\7?\2\2\u00c7\36\3\2\2\2\u00c8\u00c9\7#\2\2\u00c9\u00ca\7?\2\2\u00ca"+
		" \3\2\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7w\2\2\u00ce"+
		"\u00cf\7g\2\2\u00cf\"\3\2\2\2\u00d0\u00d1\7h\2\2\u00d1\u00d2\7c\2\2\u00d2"+
		"\u00d3\7n\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7g\2\2\u00d5$\3\2\2\2\u00d6"+
		"\u00d7\7U\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da\7p\2\2"+
		"\u00da\u00db\7c\2\2\u00db\u00dc\7n\2\2\u00dc&\3\2\2\2\u00dd\u00de\7k\2"+
		"\2\u00de\u00df\7p\2\2\u00df\u00e0\7r\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2"+
		"\7v\2\2\u00e2(\3\2\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7w\2\2\u00e5\u00e6"+
		"\7v\2\2\u00e6\u00e7\7r\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7v\2\2\u00e9"+
		"*\3\2\2\2\u00ea\u00eb\7F\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7x\2\2\u00ed"+
		"\u00ee\7k\2\2\u00ee\u00ef\7e\2\2\u00ef\u00f0\7g\2\2\u00f0,\3\2\2\2\u00f1"+
		"\u00f2\7f\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7h\2\2\u00f4\u00f5\7k\2\2"+
		"\u00f5\u00f6\7p\2\2\u00f6\u00f7\7g\2\2\u00f7.\3\2\2\2\u00f8\u00f9\7k\2"+
		"\2\u00f9\u00fa\7h\2\2\u00fa\60\3\2\2\2\u00fb\u00fc\7y\2\2\u00fc\u00fd"+
		"\7j\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100\7g\2\2\u0100"+
		"\62\3\2\2\2\u0101\u0102\7k\2\2\u0102\u0103\7p\2\2\u0103\u0104\7k\2\2\u0104"+
		"\u0105\7v\2\2\u0105\64\3\2\2\2\u0106\u0107\7x\2\2\u0107\u0108\7q\2\2\u0108"+
		"\u0109\7k\2\2\u0109\u010a\7f\2\2\u010a\66\3\2\2\2\u010b\u010c\7y\2\2\u010c"+
		"\u010d\7j\2\2\u010d\u010e\7g\2\2\u010e\u010f\7p\2\2\u010f8\3\2\2\2\u0110"+
		"\u0111\7g\2\2\u0111\u0112\7x\2\2\u0112\u0113\7g\2\2\u0113\u0114\7t\2\2"+
		"\u0114\u0115\7{\2\2\u0115:\3\2\2\2\u0116\u0117\7o\2\2\u0117\u0118\7u\2"+
		"\2\u0118<\3\2\2\2\u0119\u011a\7u\2\2\u011a\u011b\7g\2\2\u011b\u011c\7"+
		"e\2\2\u011c\u011d\7q\2\2\u011d\u011e\7p\2\2\u011e\u011f\7f\2\2\u011f\u0120"+
		"\7u\2\2\u0120>\3\2\2\2\u0121\u0122\7o\2\2\u0122\u0123\7k\2\2\u0123\u0124"+
		"\7p\2\2\u0124\u0125\7w\2\2\u0125\u0126\7v\2\2\u0126\u0127\7g\2\2\u0127"+
		"\u0128\7u\2\2\u0128@\3\2\2\2\u0129\u012a\7j\2\2\u012a\u012b\7q\2\2\u012b"+
		"\u012c\7w\2\2\u012c\u012d\7t\2\2\u012d\u012e\7u\2\2\u012eB\3\2\2\2\u012f"+
		"\u0130\7f\2\2\u0130\u0131\7c\2\2\u0131\u0132\7{\2\2\u0132\u0133\7u\2\2"+
		"\u0133D\3\2\2\2\u0134\u0135\7y\2\2\u0135\u0136\7g\2\2\u0136\u0137\7g\2"+
		"\2\u0137\u0138\7m\2\2\u0138\u0139\7u\2\2\u0139F\3\2\2\2\u013a\u013b\7"+
		"o\2\2\u013b\u013c\7q\2\2\u013c\u013d\7p\2\2\u013d\u013e\7v\2\2\u013e\u013f"+
		"\7j\2\2\u013f\u0140\7u\2\2\u0140H\3\2\2\2\u0141\u0142\7y\2\2\u0142\u0143"+
		"\7c\2\2\u0143\u0144\7k\2\2\u0144\u0145\7v\2\2\u0145J\3\2\2\2\u0146\u0147"+
		"\7u\2\2\u0147\u0148\7v\2\2\u0148\u0149\7t\2\2\u0149\u014a\7k\2\2\u014a"+
		"\u014b\7p\2\2\u014b\u014c\7i\2\2\u014cL\3\2\2\2\u014d\u014e\7k\2\2\u014e"+
		"\u014f\7p\2\2\u014f\u0150\7v\2\2\u0150N\3\2\2\2\u0151\u0152\7h\2\2\u0152"+
		"\u0153\7n\2\2\u0153\u0154\7q\2\2\u0154\u0155\7c\2\2\u0155\u0156\7v\2\2"+
		"\u0156P\3\2\2\2\u0157\u0158\7u\2\2\u0158\u0159\7g\2\2\u0159\u015a\7v\2"+
		"\2\u015aR\3\2\2\2\u015b\u015c\7i\2\2\u015c\u015d\7g\2\2\u015d\u015e\7"+
		"v\2\2\u015eT\3\2\2\2\u015f\u0160\7g\2\2\u0160\u0161\7z\2\2\u0161\u0162"+
		"\7e\2\2\u0162\u0163\7g\2\2\u0163\u0164\7g\2\2\u0164\u0165\7f\2\2\u0165"+
		"\u0166\7u\2\2\u0166V\3\2\2\2\u0167\u0168\7f\2\2\u0168\u0169\7g\2\2\u0169"+
		"\u016a\7e\2\2\u016a\u016b\7g\2\2\u016b\u016c\7g\2\2\u016c\u016d\7f\2\2"+
		"\u016d\u016e\7u\2\2\u016eX\3\2\2\2\u016f\u0170\7p\2\2\u0170\u0171\7q\2"+
		"\2\u0171\u0172\7y\2\2\u0172Z\3\2\2\2\u0173\u0174\7g\2\2\u0174\u0175\7"+
		"n\2\2\u0175\u0176\7u\2\2\u0176\u0177\7g\2\2\u0177\\\3\2\2\2\u0178\u0179"+
		"\7t\2\2\u0179\u017a\7g\2\2\u017a\u017b\7v\2\2\u017b\u017c\7w\2\2\u017c"+
		"\u017d\7t\2\2\u017d\u017e\7p\2\2\u017e^\3\2\2\2\u017f\u0180\7d\2\2\u0180"+
		"\u0181\7t\2\2\u0181\u0182\7g\2\2\u0182\u0183\7c\2\2\u0183\u0184\7m\2\2"+
		"\u0184`\3\2\2\2\u0185\u0186\7c\2\2\u0186\u0187\7v\2\2\u0187b\3\2\2\2\u0188"+
		"\u0189\7*\2\2\u0189d\3\2\2\2\u018a\u018b\7+\2\2\u018bf\3\2\2\2\u018c\u018d"+
		"\7}\2\2\u018dh\3\2\2\2\u018e\u018f\7\177\2\2\u018fj\3\2\2\2\u0190\u0191"+
		"\7?\2\2\u0191l\3\2\2\2\u0192\u0193\7-\2\2\u0193n\3\2\2\2\u0194\u0195\7"+
		"/\2\2\u0195p\3\2\2\2\u0196\u0197\7\61\2\2\u0197r\3\2\2\2\u0198\u0199\7"+
		",\2\2\u0199t\3\2\2\2\u019a\u019b\7\60\2\2\u019b\u019c\7\60\2\2\u019cv"+
		"\3\2\2\2\u019d\u019e\7=\2\2\u019ex\3\2\2\2\u019f\u01a0\7.\2\2\u01a0z\3"+
		"\2\2\2\u01a1\u01a2\7$\2\2\u01a2|\3\2\2\2\u01a3\u01a4\7<\2\2\u01a4~\3\2"+
		"\2\2\u01a5\u01a6\7(\2\2\u01a6\u0080\3\2\2\2\u01a7\u01a8\7u\2\2\u01a8\u01a9"+
		"\7v\2\2\u01a9\u01aa\7c\2\2\u01aa\u01ab\7t\2\2\u01ab\u01ac\7v\2\2\u01ac"+
		"\u01ad\7k\2\2\u01ad\u01ae\7p\2\2\u01ae\u01af\7i\2\2\u01af\u0082\3\2\2"+
		"\2\u01b0\u01b1\5\17\b\2\u01b1\u01b2\5\17\b\2\u01b2\u01b3\7f\2\2\u01b3"+
		"\u01b4\5\17\b\2\u01b4\u01b5\5\17\b\2\u01b5\u01b6\7o\2\2\u01b6\u01b7\5"+
		"\17\b\2\u01b7\u01b8\5\17\b\2\u01b8\u01b9\5\17\b\2\u01b9\u01ba\5\17\b\2"+
		"\u01ba\u01bb\7{\2\2\u01bb\u0084\3\2\2\2\u01bc\u01bd\5\17\b\2\u01bd\u01be"+
		"\5\17\b\2\u01be\u01bf\7f\2\2\u01bf\u01c0\5\17\b\2\u01c0\u01c1\5\17\b\2"+
		"\u01c1\u01c2\7o\2\2\u01c2\u0086\3\2\2\2\u01c3\u01c5\7/\2\2\u01c4\u01c3"+
		"\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c8\5\17\b\2"+
		"\u01c7\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\7\60\2\2\u01cc\u01ce\5\17\b\2"+
		"\u01cd\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0\u0088\3\2\2\2\u01d1\u01d2\5\17\b\2\u01d2\u01d3\5\17\b\2"+
		"\u01d3\u01d4\5}?\2\u01d4\u01d5\5\17\b\2\u01d5\u01d6\5\17\b\2\u01d6\u008a"+
		"\3\2\2\2\u01d7\u01d9\5\17\b\2\u01d8\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2"+
		"\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01e2\3\2\2\2\u01dc\u01de"+
		"\7\60\2\2\u01dd\u01df\5\17\b\2\u01de\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2"+
		"\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01dc"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\u01e8\7<\2\2\u01e7\u01e9\5\17\b\2\u01e8\u01e7\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"\u008c\3\2\2\2\u01ec\u01ee\7/\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2"+
		"\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01f1\5\17\b\2\u01f0\u01ef\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u008e\3\2"+
		"\2\2\u01f4\u01f9\7$\2\2\u01f5\u01fa\5\13\6\2\u01f6\u01fa\5\r\7\2\u01f7"+
		"\u01fa\5\u0093J\2\u01f8\u01fa\5\17\b\2\u01f9\u01f5\3\2\2\2\u01f9\u01f6"+
		"\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb"+
		"\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\7$"+
		"\2\2\u01fe\u0090\3\2\2\2\u01ff\u0202\5\13\6\2\u0200\u0202\5\r\7\2\u0201"+
		"\u01ff\3\2\2\2\u0201\u0200\3\2\2\2\u0202\u0208\3\2\2\2\u0203\u0207\5\13"+
		"\6\2\u0204\u0207\5\r\7\2\u0205\u0207\5\17\b\2\u0206\u0203\3\2\2\2\u0206"+
		"\u0204\3\2\2\2\u0206\u0205\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2"+
		"\2\2\u0208\u0209\3\2\2\2\u0209\u0092\3\2\2\2\u020a\u0208\3\2\2\2\u020b"+
		"\u020c\t\7\2\2\u020c\u0094\3\2\2\2\24\2\u00a3\u00a9\u00ad\u01c4\u01c9"+
		"\u01cf\u01da\u01e0\u01e4\u01ea\u01ed\u01f2\u01f9\u01fb\u0201\u0206\u0208"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
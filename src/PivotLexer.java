// Generated from C:/Users/phili/IdeaProjects/P4Grammar/src\Pivot.g4 by ANTLR 4.7.2
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
		T__0=1, T__1=2, T__2=3, T__3=4, WhiteSpace=5, NewLine=6, LINE_COMMENT=7, 
		TRUE=8, FALSE=9, AND=10, OR=11, GT=12, GE=13, LT=14, LE=15, EQ=16, SIGNALKW=17, 
		INPUTKW=18, OUTPUTKW=19, DEVICE=20, DEFINEKW=21, IF=22, WHILE=23, INITFUNCKW=24, 
		VOID=25, WHEN=26, EVERY=27, PARANBEG=28, PARANEND=29, BLCKBEG=30, BLCKEND=31, 
		EQUALS=32, PLUS=33, MINUS=34, DIV=35, MULT=36, RANGESEP=37, END=38, LISTSEP=39, 
		QUOT=40, SINTEGER=41, ID=42, STRING=43, IP=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "WhiteSpace", "NewLine", "LINE_COMMENT", 
			"NEWLINE", "LOWERCASE", "UPPERCASE", "NUMBER", "TRUE", "FALSE", "AND", 
			"OR", "GT", "GE", "LT", "LE", "EQ", "SIGNALKW", "INPUTKW", "OUTPUTKW", 
			"DEVICE", "DEFINEKW", "IF", "WHILE", "INITFUNCKW", "VOID", "WHEN", "EVERY", 
			"PARANBEG", "PARANEND", "BLCKBEG", "BLCKEND", "EQUALS", "PLUS", "MINUS", 
			"DIV", "MULT", "RANGESEP", "END", "LISTSEP", "QUOT", "SINTEGER", "ID", 
			"STRING", "IP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'&'", "'func'", "'atom'", null, null, null, "'true'", "'false'", 
			"'&&'", "'||'", "'>'", "'>='", "'<'", "'<='", "'=='", "'Signal'", "'input'", 
			"'output'", "'Device'", "'#define'", "'if'", "'while'", "'init'", "'void'", 
			"'when'", "'every'", "'('", "')'", "'{'", "'}'", "'='", "'+'", "'-'", 
			"'/'", "'*'", "'..'", "';'", "','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "WhiteSpace", "NewLine", "LINE_COMMENT", 
			"TRUE", "FALSE", "AND", "OR", "GT", "GE", "LT", "LE", "EQ", "SIGNALKW", 
			"INPUTKW", "OUTPUTKW", "DEVICE", "DEFINEKW", "IF", "WHILE", "INITFUNCKW", 
			"VOID", "WHEN", "EVERY", "PARANBEG", "PARANEND", "BLCKBEG", "BLCKEND", 
			"EQUALS", "PLUS", "MINUS", "DIV", "MULT", "RANGESEP", "END", "LISTSEP", 
			"QUOT", "SINTEGER", "ID", "STRING", "IP"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0139\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\7\b~\n\b\f\b\16\b\u0081\13\b\3\b\3\b\3\t\5\t\u0086\n\t\3\t\3\t"+
		"\5\t\u008a\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3"+
		"*\3*\3*\3+\3+\3,\3,\3-\3-\3.\5.\u010d\n.\3.\6.\u0110\n.\r.\16.\u0111\3"+
		"/\3/\5/\u0116\n/\3/\7/\u0119\n/\f/\16/\u011c\13/\3\60\3\60\3\60\6\60\u0121"+
		"\n\60\r\60\16\60\u0122\3\61\6\61\u0126\n\61\r\61\16\61\u0127\3\61\3\61"+
		"\6\61\u012c\n\61\r\61\16\61\u012d\6\61\u0130\n\61\r\61\16\61\u0131\3\61"+
		"\3\61\6\61\u0136\n\61\r\61\16\61\u0137\2\2\62\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\2\23\2\25\2\27\2\31\n\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23"+
		"-\24/\25\61\26\63\27\65\30\67\319\32;\33=\34?\35A\36C\37E G!I\"K#M$O%"+
		"Q&S\'U(W)Y*[+],_-a.\3\2\7\4\2\13\13\"\"\4\2\f\f\17\17\3\2c|\3\2C\\\3\2"+
		"\62;\2\u0142\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5e\3\2\2\2\7g\3\2\2\2\t"+
		"l\3\2\2\2\13q\3\2\2\2\ru\3\2\2\2\17y\3\2\2\2\21\u0089\3\2\2\2\23\u008b"+
		"\3\2\2\2\25\u008d\3\2\2\2\27\u008f\3\2\2\2\31\u0091\3\2\2\2\33\u0096\3"+
		"\2\2\2\35\u009c\3\2\2\2\37\u009f\3\2\2\2!\u00a2\3\2\2\2#\u00a4\3\2\2\2"+
		"%\u00a7\3\2\2\2\'\u00a9\3\2\2\2)\u00ac\3\2\2\2+\u00af\3\2\2\2-\u00b6\3"+
		"\2\2\2/\u00bc\3\2\2\2\61\u00c3\3\2\2\2\63\u00ca\3\2\2\2\65\u00d2\3\2\2"+
		"\2\67\u00d5\3\2\2\29\u00db\3\2\2\2;\u00e0\3\2\2\2=\u00e5\3\2\2\2?\u00ea"+
		"\3\2\2\2A\u00f0\3\2\2\2C\u00f2\3\2\2\2E\u00f4\3\2\2\2G\u00f6\3\2\2\2I"+
		"\u00f8\3\2\2\2K\u00fa\3\2\2\2M\u00fc\3\2\2\2O\u00fe\3\2\2\2Q\u0100\3\2"+
		"\2\2S\u0102\3\2\2\2U\u0105\3\2\2\2W\u0107\3\2\2\2Y\u0109\3\2\2\2[\u010c"+
		"\3\2\2\2]\u0115\3\2\2\2_\u0120\3\2\2\2a\u012f\3\2\2\2cd\7<\2\2d\4\3\2"+
		"\2\2ef\7(\2\2f\6\3\2\2\2gh\7h\2\2hi\7w\2\2ij\7p\2\2jk\7e\2\2k\b\3\2\2"+
		"\2lm\7c\2\2mn\7v\2\2no\7q\2\2op\7o\2\2p\n\3\2\2\2qr\t\2\2\2rs\3\2\2\2"+
		"st\b\6\2\2t\f\3\2\2\2uv\5\21\t\2vw\3\2\2\2wx\b\7\2\2x\16\3\2\2\2yz\7\61"+
		"\2\2z{\7\61\2\2{\177\3\2\2\2|~\n\3\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3"+
		"\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083"+
		"\b\b\2\2\u0083\20\3\2\2\2\u0084\u0086\7\17\2\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\7\f\2\2\u0088\u008a\7\17"+
		"\2\2\u0089\u0085\3\2\2\2\u0089\u0088\3\2\2\2\u008a\22\3\2\2\2\u008b\u008c"+
		"\t\4\2\2\u008c\24\3\2\2\2\u008d\u008e\t\5\2\2\u008e\26\3\2\2\2\u008f\u0090"+
		"\t\6\2\2\u0090\30\3\2\2\2\u0091\u0092\7v\2\2\u0092\u0093\7t\2\2\u0093"+
		"\u0094\7w\2\2\u0094\u0095\7g\2\2\u0095\32\3\2\2\2\u0096\u0097\7h\2\2\u0097"+
		"\u0098\7c\2\2\u0098\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u009b\7g\2\2"+
		"\u009b\34\3\2\2\2\u009c\u009d\7(\2\2\u009d\u009e\7(\2\2\u009e\36\3\2\2"+
		"\2\u009f\u00a0\7~\2\2\u00a0\u00a1\7~\2\2\u00a1 \3\2\2\2\u00a2\u00a3\7"+
		"@\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5\u00a6\7?\2\2\u00a6$\3\2"+
		"\2\2\u00a7\u00a8\7>\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa\u00ab"+
		"\7?\2\2\u00ab(\3\2\2\2\u00ac\u00ad\7?\2\2\u00ad\u00ae\7?\2\2\u00ae*\3"+
		"\2\2\2\u00af\u00b0\7U\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7i\2\2\u00b2"+
		"\u00b3\7p\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7n\2\2\u00b5,\3\2\2\2\u00b6"+
		"\u00b7\7k\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7r\2\2\u00b9\u00ba\7w\2\2"+
		"\u00ba\u00bb\7v\2\2\u00bb.\3\2\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7w\2"+
		"\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7r\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2"+
		"\7v\2\2\u00c2\60\3\2\2\2\u00c3\u00c4\7F\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6"+
		"\7x\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9\7g\2\2\u00c9"+
		"\62\3\2\2\2\u00ca\u00cb\7%\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7g\2\2\u00cd"+
		"\u00ce\7h\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7g\2\2"+
		"\u00d1\64\3\2\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7h\2\2\u00d4\66\3\2\2"+
		"\2\u00d5\u00d6\7y\2\2\u00d6\u00d7\7j\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9"+
		"\7n\2\2\u00d9\u00da\7g\2\2\u00da8\3\2\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd"+
		"\7p\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7v\2\2\u00df:\3\2\2\2\u00e0\u00e1"+
		"\7x\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7f\2\2\u00e4"+
		"<\3\2\2\2\u00e5\u00e6\7y\2\2\u00e6\u00e7\7j\2\2\u00e7\u00e8\7g\2\2\u00e8"+
		"\u00e9\7p\2\2\u00e9>\3\2\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7x\2\2\u00ec"+
		"\u00ed\7g\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7{\2\2\u00ef@\3\2\2\2\u00f0"+
		"\u00f1\7*\2\2\u00f1B\3\2\2\2\u00f2\u00f3\7+\2\2\u00f3D\3\2\2\2\u00f4\u00f5"+
		"\7}\2\2\u00f5F\3\2\2\2\u00f6\u00f7\7\177\2\2\u00f7H\3\2\2\2\u00f8\u00f9"+
		"\7?\2\2\u00f9J\3\2\2\2\u00fa\u00fb\7-\2\2\u00fbL\3\2\2\2\u00fc\u00fd\7"+
		"/\2\2\u00fdN\3\2\2\2\u00fe\u00ff\7\61\2\2\u00ffP\3\2\2\2\u0100\u0101\7"+
		",\2\2\u0101R\3\2\2\2\u0102\u0103\7\60\2\2\u0103\u0104\7\60\2\2\u0104T"+
		"\3\2\2\2\u0105\u0106\7=\2\2\u0106V\3\2\2\2\u0107\u0108\7.\2\2\u0108X\3"+
		"\2\2\2\u0109\u010a\7$\2\2\u010aZ\3\2\2\2\u010b\u010d\7/\2\2\u010c\u010b"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u0110\5\27\f\2"+
		"\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\\\3\2\2\2\u0113\u0116\5\23\n\2\u0114\u0116\5\25\13\2\u0115"+
		"\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116\u011a\3\2\2\2\u0117\u0119\5_"+
		"\60\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b^\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0121\5\23\n\2"+
		"\u011e\u0121\5\25\13\2\u011f\u0121\5\27\f\2\u0120\u011d\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123`\3\2\2\2\u0124\u0126\5\27\f\2\u0125\u0124"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012b\7\60\2\2\u012a\u012c\5\27\f\2\u012b\u012a\3"+
		"\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u0130\3\2\2\2\u012f\u0125\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\7<\2\2\u0134"+
		"\u0136\5\27\f\2\u0135\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0135\3"+
		"\2\2\2\u0137\u0138\3\2\2\2\u0138b\3\2\2\2\20\2\177\u0085\u0089\u010c\u0111"+
		"\u0115\u011a\u0120\u0122\u0127\u012d\u0131\u0137\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
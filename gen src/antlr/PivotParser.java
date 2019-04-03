// Generated from /Users/philip/Library/Mobile Documents/com~apple~CloudDocs/Cloud dokumenter/Java projects/P4Grammar/Pivot.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PivotParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WhiteSpace=1, NewLine=2, LINE_COMMENT=3, AND=4, OR=5, GT=6, GE=7, ST=8, 
		SE=9, EQ=10, NE=11, TRUE=12, FALSE=13, SIGNAL=14, INPUT=15, OUTPUT=16, 
		DEVICE=17, DEFINEKW=18, IF=19, WHILE=20, INITFUNCKW=21, VOID=22, WHEN=23, 
		EVERY=24, MS=25, SECONDS=26, MINUTES=27, HOURS=28, DAYS=29, WEEKS=30, 
		MONTHS=31, WAIT=32, STRINGKW=33, INTEGERKW=34, FLOATKW=35, SET=36, GET=37, 
		EXCEEDS=38, DECEEDS=39, NOW=40, ELSE=41, RETURN=42, BREAK=43, STARTING=44, 
		PARANBEG=45, PARANEND=46, BLCKBEG=47, BLCKEND=48, EQUALS=49, PLUS=50, 
		MINUS=51, DIV=52, MULT=53, RANGESEP=54, SEMCOL=55, LISTSEP=56, QUOT=57, 
		COL=58, AMP=59, DATE=60, DATEnoYEAR=61, FLOAT=62, TIME=63, INTEGER=64, 
		STRING=65, ID=66, SIGN=67;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_define = 2, RULE_signal = 3, RULE_enumerations = 4, 
		RULE_enumeration = 5, RULE_range = 6, RULE_lowerBound = 7, RULE_upperBound = 8, 
		RULE_device = 9, RULE_inputs = 10, RULE_outputs = 11, RULE_declDevice = 12, 
		RULE_init = 13, RULE_funcDecl = 14, RULE_fParams = 15, RULE_param = 16, 
		RULE_event = 17, RULE_atomEvent = 18, RULE_repeatEvent = 19, RULE_timeAndDate = 20, 
		RULE_timeFrame = 21, RULE_block = 22, RULE_stmts = 23, RULE_waitStmt = 24, 
		RULE_assignment = 25, RULE_ifstmt = 26, RULE_whilestmt = 27, RULE_funcCall = 28, 
		RULE_arguments = 29, RULE_declVar = 30, RULE_brk = 31, RULE_rtn = 32, 
		RULE_litVal = 33, RULE_expr = 34, RULE_logical_expr = 35, RULE_comparison_expr = 36, 
		RULE_comparison_operand = 37, RULE_comp_operator = 38, RULE_atom = 39, 
		RULE_varType = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "define", "signal", "enumerations", "enumeration", 
			"range", "lowerBound", "upperBound", "device", "inputs", "outputs", "declDevice", 
			"init", "funcDecl", "fParams", "param", "event", "atomEvent", "repeatEvent", 
			"timeAndDate", "timeFrame", "block", "stmts", "waitStmt", "assignment", 
			"ifstmt", "whilestmt", "funcCall", "arguments", "declVar", "brk", "rtn", 
			"litVal", "expr", "logical_expr", "comparison_expr", "comparison_operand", 
			"comp_operator", "atom", "varType"
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
			"'exceeds'", "'deceeds'", "'now'", "'else'", "'return'", "'break'", "'starting'", 
			"'('", "')'", "'{'", "'}'", "'='", "'+'", "'-'", "'/'", "'*'", "'..'", 
			"';'", "','", "'\"'", "':'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WhiteSpace", "NewLine", "LINE_COMMENT", "AND", "OR", "GT", "GE", 
			"ST", "SE", "EQ", "NE", "TRUE", "FALSE", "SIGNAL", "INPUT", "OUTPUT", 
			"DEVICE", "DEFINEKW", "IF", "WHILE", "INITFUNCKW", "VOID", "WHEN", "EVERY", 
			"MS", "SECONDS", "MINUTES", "HOURS", "DAYS", "WEEKS", "MONTHS", "WAIT", 
			"STRINGKW", "INTEGERKW", "FLOATKW", "SET", "GET", "EXCEEDS", "DECEEDS", 
			"NOW", "ELSE", "RETURN", "BREAK", "STARTING", "PARANBEG", "PARANEND", 
			"BLCKBEG", "BLCKEND", "EQUALS", "PLUS", "MINUS", "DIV", "MULT", "RANGESEP", 
			"SEMCOL", "LISTSEP", "QUOT", "COL", "AMP", "DATE", "DATEnoYEAR", "FLOAT", 
			"TIME", "INTEGER", "STRING", "ID", "SIGN"
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

	@Override
	public String getGrammarFileName() { return "Pivot.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PivotParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PivotParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			decls();
			setState(83);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclsContext extends ParserRuleContext {
		public DefineContext defs;
		public DeclVarContext vars;
		public DeclDeviceContext devVars;
		public InitContext inFunc;
		public List<FuncDeclContext> funcDecl() {
			return getRuleContexts(FuncDeclContext.class);
		}
		public FuncDeclContext funcDecl(int i) {
			return getRuleContext(FuncDeclContext.class,i);
		}
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<DeclVarContext> declVar() {
			return getRuleContexts(DeclVarContext.class);
		}
		public DeclVarContext declVar(int i) {
			return getRuleContext(DeclVarContext.class,i);
		}
		public List<DeclDeviceContext> declDevice() {
			return getRuleContexts(DeclDeviceContext.class);
		}
		public DeclDeviceContext declDevice(int i) {
			return getRuleContext(DeclDeviceContext.class,i);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINEKW) {
				{
				{
				setState(85);
				((DeclsContext)_localctx).defs = define();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(93);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRINGKW:
					case INTEGERKW:
					case FLOATKW:
						{
						setState(91);
						((DeclsContext)_localctx).vars = declVar();
						}
						break;
					case ID:
						{
						setState(92);
						((DeclsContext)_localctx).devVars = declDevice();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITFUNCKW) {
				{
				setState(98);
				((DeclsContext)_localctx).inFunc = init();
				}
			}

			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << WHEN) | (1L << EVERY) | (1L << STRINGKW) | (1L << INTEGERKW) | (1L << FLOATKW))) != 0)) {
				{
				setState(103);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VOID:
				case STRINGKW:
				case INTEGERKW:
				case FLOATKW:
					{
					setState(101);
					funcDecl();
					}
					break;
				case WHEN:
				case EVERY:
					{
					setState(102);
					event();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public TerminalNode DEFINEKW() { return getToken(PivotParser.DEFINEKW, 0); }
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public SignalContext signal() {
			return getRuleContext(SignalContext.class,0);
		}
		public DeviceContext device() {
			return getRuleContext(DeviceContext.class,0);
		}
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_define);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(DEFINEKW);
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIGNAL:
				{
				setState(109);
				signal();
				}
				break;
			case DEVICE:
				{
				setState(110);
				device();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(113);
			match(SEMCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignalContext extends ParserRuleContext {
		public TerminalNode SIGNAL() { return getToken(PivotParser.SIGNAL, 0); }
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public EnumerationsContext enumerations() {
			return getRuleContext(EnumerationsContext.class,0);
		}
		public SignalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterSignal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitSignal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitSignal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignalContext signal() throws RecognitionException {
		SignalContext _localctx = new SignalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_signal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(SIGNAL);
			setState(116);
			match(ID);
			setState(117);
			match(COL);
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INTEGER:
				{
				setState(118);
				range();
				}
				break;
			case ID:
				{
				setState(119);
				enumerations();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumerationsContext extends ParserRuleContext {
		public List<EnumerationContext> enumeration() {
			return getRuleContexts(EnumerationContext.class);
		}
		public EnumerationContext enumeration(int i) {
			return getRuleContext(EnumerationContext.class,i);
		}
		public List<TerminalNode> LISTSEP() { return getTokens(PivotParser.LISTSEP); }
		public TerminalNode LISTSEP(int i) {
			return getToken(PivotParser.LISTSEP, i);
		}
		public EnumerationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterEnumerations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitEnumerations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitEnumerations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationsContext enumerations() throws RecognitionException {
		EnumerationsContext _localctx = new EnumerationsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_enumerations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			enumeration();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(123);
				match(LISTSEP);
				setState(124);
				enumeration();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumerationContext extends ParserRuleContext {
		public LitValContext enumVal;
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public LitValContext litVal() {
			return getRuleContext(LitValContext.class,0);
		}
		public EnumerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitEnumeration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitEnumeration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationContext enumeration() throws RecognitionException {
		EnumerationContext _localctx = new EnumerationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_enumeration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(ID);
			setState(131);
			match(EQUALS);
			setState(132);
			((EnumerationContext)_localctx).enumVal = litVal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public LowerBoundContext lowerBound() {
			return getRuleContext(LowerBoundContext.class,0);
		}
		public TerminalNode RANGESEP() { return getToken(PivotParser.RANGESEP, 0); }
		public UpperBoundContext upperBound() {
			return getRuleContext(UpperBoundContext.class,0);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			lowerBound();
			setState(135);
			match(RANGESEP);
			setState(136);
			upperBound();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LowerBoundContext extends ParserRuleContext {
		public LowerBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerBound; }
	 
		public LowerBoundContext() { }
		public void copyFrom(LowerBoundContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntlwRangeContext extends LowerBoundContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public IntlwRangeContext(LowerBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIntlwRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIntlwRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntlwRange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatlwRangeContext extends LowerBoundContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatlwRangeContext(LowerBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFloatlwRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFloatlwRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFloatlwRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerBoundContext lowerBound() throws RecognitionException {
		LowerBoundContext _localctx = new LowerBoundContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lowerBound);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntlwRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatlwRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(FLOAT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpperBoundContext extends ParserRuleContext {
		public UpperBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upperBound; }
	 
		public UpperBoundContext() { }
		public void copyFrom(UpperBoundContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntupRangeContext extends UpperBoundContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public IntupRangeContext(UpperBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIntupRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIntupRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntupRange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatupRangeContext extends UpperBoundContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatupRangeContext(UpperBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFloatupRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFloatupRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFloatupRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperBoundContext upperBound() throws RecognitionException {
		UpperBoundContext _localctx = new UpperBoundContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_upperBound);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntupRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatupRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(FLOAT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeviceContext extends ParserRuleContext {
		public TerminalNode DEVICE() { return getToken(PivotParser.DEVICE, 0); }
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public InputsContext inputs() {
			return getRuleContext(InputsContext.class,0);
		}
		public TerminalNode AMP() { return getToken(PivotParser.AMP, 0); }
		public OutputsContext outputs() {
			return getRuleContext(OutputsContext.class,0);
		}
		public DeviceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_device; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterDevice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitDevice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitDevice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeviceContext device() throws RecognitionException {
		DeviceContext _localctx = new DeviceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_device);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(DEVICE);
			setState(147);
			match(ID);
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INPUT) {
					{
					setState(148);
					inputs();
					}
				}

				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMP) {
					{
					setState(151);
					match(AMP);
					setState(152);
					outputs();
					}
				}

				}
				}
				break;
			case 2:
				{
				{
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTPUT) {
					{
					setState(155);
					outputs();
					}
				}

				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMP) {
					{
					setState(158);
					match(AMP);
					setState(159);
					inputs();
					}
				}

				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputsContext extends ParserRuleContext {
		public Token input;
		public TerminalNode INPUT() { return getToken(PivotParser.INPUT, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public List<TerminalNode> LISTSEP() { return getTokens(PivotParser.LISTSEP); }
		public TerminalNode LISTSEP(int i) {
			return getToken(PivotParser.LISTSEP, i);
		}
		public InputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterInputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitInputs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInputs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputsContext inputs() throws RecognitionException {
		InputsContext _localctx = new InputsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(INPUT);
			setState(165);
			match(COL);
			setState(166);
			((InputsContext)_localctx).input = match(ID);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(167);
				match(LISTSEP);
				setState(168);
				((InputsContext)_localctx).input = match(ID);
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputsContext extends ParserRuleContext {
		public Token output;
		public TerminalNode OUTPUT() { return getToken(PivotParser.OUTPUT, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public List<TerminalNode> LISTSEP() { return getTokens(PivotParser.LISTSEP); }
		public TerminalNode LISTSEP(int i) {
			return getToken(PivotParser.LISTSEP, i);
		}
		public OutputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterOutputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitOutputs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitOutputs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputsContext outputs() throws RecognitionException {
		OutputsContext _localctx = new OutputsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_outputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(OUTPUT);
			setState(175);
			match(COL);
			setState(176);
			((OutputsContext)_localctx).output = match(ID);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(177);
				match(LISTSEP);
				setState(178);
				((OutputsContext)_localctx).output = match(ID);
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclDeviceContext extends ParserRuleContext {
		public Token devType;
		public Token varID;
		public Token val;
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public DeclDeviceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declDevice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterDeclDevice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitDeclDevice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitDeclDevice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclDeviceContext declDevice() throws RecognitionException {
		DeclDeviceContext _localctx = new DeclDeviceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declDevice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((DeclDeviceContext)_localctx).devType = match(ID);
			setState(185);
			((DeclDeviceContext)_localctx).varID = match(ID);
			setState(186);
			match(EQUALS);
			setState(187);
			((DeclDeviceContext)_localctx).val = match(STRING);
			setState(188);
			match(SEMCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public TerminalNode INITFUNCKW() { return getToken(PivotParser.INITFUNCKW, 0); }
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(INITFUNCKW);
			setState(191);
			match(PARANBEG);
			setState(192);
			match(PARANEND);
			setState(193);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDeclContext extends ParserRuleContext {
		public Token id;
		public FParamsContext params;
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public FParamsContext fParams() {
			return getRuleContext(FParamsContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(PivotParser.VOID, 0); }
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRINGKW:
			case INTEGERKW:
			case FLOATKW:
				{
				setState(195);
				varType();
				}
				break;
			case VOID:
				{
				setState(196);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(199);
			((FuncDeclContext)_localctx).id = match(ID);
			setState(200);
			match(PARANBEG);
			setState(201);
			((FuncDeclContext)_localctx).params = fParams();
			setState(202);
			match(PARANEND);
			setState(203);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> LISTSEP() { return getTokens(PivotParser.LISTSEP); }
		public TerminalNode LISTSEP(int i) {
			return getToken(PivotParser.LISTSEP, i);
		}
		public FParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FParamsContext fParams() throws RecognitionException {
		FParamsContext _localctx = new FParamsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRINGKW) | (1L << INTEGERKW) | (1L << FLOATKW))) != 0)) {
				{
				setState(205);
				param();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LISTSEP) {
					{
					{
					setState(206);
					match(LISTSEP);
					setState(207);
					param();
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Token localID;
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			varType();
			setState(216);
			((ParamContext)_localctx).localID = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventContext extends ParserRuleContext {
		public AtomEventContext atomEvent() {
			return getRuleContext(AtomEventContext.class,0);
		}
		public RepeatEventContext repeatEvent() {
			return getRuleContext(RepeatEventContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHEN:
				{
				setState(218);
				atomEvent();
				}
				break;
			case EVERY:
				{
				setState(219);
				repeatEvent();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomEventContext extends ParserRuleContext {
		public Token deviceID;
		public Token signalID;
		public Token enumID;
		public TerminalNode WHEN() { return getToken(PivotParser.WHEN, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public TerminalNode EXCEEDS() { return getToken(PivotParser.EXCEEDS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DECEEDS() { return getToken(PivotParser.DECEEDS, 0); }
		public TimeAndDateContext timeAndDate() {
			return getRuleContext(TimeAndDateContext.class,0);
		}
		public AtomEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomEvent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterAtomEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitAtomEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAtomEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomEventContext atomEvent() throws RecognitionException {
		AtomEventContext _localctx = new AtomEventContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_atomEvent);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(WHEN);
				setState(223);
				((AtomEventContext)_localctx).deviceID = match(ID);
				setState(224);
				((AtomEventContext)_localctx).signalID = match(ID);
				setState(225);
				match(COL);
				setState(231);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(226);
					((AtomEventContext)_localctx).enumID = match(ID);
					}
					break;
				case EXCEEDS:
					{
					setState(227);
					match(EXCEEDS);
					setState(228);
					expr(0);
					}
					break;
				case DECEEDS:
					{
					setState(229);
					match(DECEEDS);
					setState(230);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(233);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(WHEN);
				setState(235);
				timeAndDate();
				setState(236);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatEventContext extends ParserRuleContext {
		public TerminalNode EVERY() { return getToken(PivotParser.EVERY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TimeFrameContext timeFrame() {
			return getRuleContext(TimeFrameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode STARTING() { return getToken(PivotParser.STARTING, 0); }
		public TimeAndDateContext timeAndDate() {
			return getRuleContext(TimeAndDateContext.class,0);
		}
		public RepeatEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatEvent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterRepeatEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitRepeatEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitRepeatEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatEventContext repeatEvent() throws RecognitionException {
		RepeatEventContext _localctx = new RepeatEventContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_repeatEvent);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(EVERY);
				setState(241);
				expr(0);
				setState(242);
				timeFrame();
				setState(243);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(EVERY);
				setState(246);
				expr(0);
				setState(247);
				timeFrame();
				setState(248);
				match(STARTING);
				setState(249);
				timeAndDate();
				setState(250);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeAndDateContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(PivotParser.TIME, 0); }
		public TerminalNode DATE() { return getToken(PivotParser.DATE, 0); }
		public TimeAndDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeAndDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterTimeAndDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitTimeAndDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTimeAndDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeAndDateContext timeAndDate() throws RecognitionException {
		TimeAndDateContext _localctx = new TimeAndDateContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_timeAndDate);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(TIME);
				setState(255);
				match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(DATE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				match(TIME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeFrameContext extends ParserRuleContext {
		public TerminalNode MONTHS() { return getToken(PivotParser.MONTHS, 0); }
		public TerminalNode WEEKS() { return getToken(PivotParser.WEEKS, 0); }
		public TerminalNode DAYS() { return getToken(PivotParser.DAYS, 0); }
		public TerminalNode HOURS() { return getToken(PivotParser.HOURS, 0); }
		public TerminalNode MINUTES() { return getToken(PivotParser.MINUTES, 0); }
		public TerminalNode SECONDS() { return getToken(PivotParser.SECONDS, 0); }
		public TerminalNode MS() { return getToken(PivotParser.MS, 0); }
		public TimeFrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeFrame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterTimeFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitTimeFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTimeFrame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeFrameContext timeFrame() throws RecognitionException {
		TimeFrameContext _localctx = new TimeFrameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_timeFrame);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MS) | (1L << SECONDS) | (1L << MINUTES) | (1L << HOURS) | (1L << DAYS) | (1L << WEEKS) | (1L << MONTHS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode BLCKBEG() { return getToken(PivotParser.BLCKBEG, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode BLCKEND() { return getToken(PivotParser.BLCKEND, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(BLCKBEG);
			setState(263);
			stmts();
			setState(264);
			match(BLCKEND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public List<WaitStmtContext> waitStmt() {
			return getRuleContexts(WaitStmtContext.class);
		}
		public WaitStmtContext waitStmt(int i) {
			return getRuleContext(WaitStmtContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<IfstmtContext> ifstmt() {
			return getRuleContexts(IfstmtContext.class);
		}
		public IfstmtContext ifstmt(int i) {
			return getRuleContext(IfstmtContext.class,i);
		}
		public List<WhilestmtContext> whilestmt() {
			return getRuleContexts(WhilestmtContext.class);
		}
		public WhilestmtContext whilestmt(int i) {
			return getRuleContext(WhilestmtContext.class,i);
		}
		public List<FuncCallContext> funcCall() {
			return getRuleContexts(FuncCallContext.class);
		}
		public FuncCallContext funcCall(int i) {
			return getRuleContext(FuncCallContext.class,i);
		}
		public List<TerminalNode> SEMCOL() { return getTokens(PivotParser.SEMCOL); }
		public TerminalNode SEMCOL(int i) {
			return getToken(PivotParser.SEMCOL, i);
		}
		public List<DeclVarContext> declVar() {
			return getRuleContexts(DeclVarContext.class);
		}
		public DeclVarContext declVar(int i) {
			return getRuleContext(DeclVarContext.class,i);
		}
		public List<BrkContext> brk() {
			return getRuleContexts(BrkContext.class);
		}
		public BrkContext brk(int i) {
			return getRuleContext(BrkContext.class,i);
		}
		public List<RtnContext> rtn() {
			return getRuleContexts(RtnContext.class);
		}
		public RtnContext rtn(int i) {
			return getRuleContext(RtnContext.class,i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (IF - 19)) | (1L << (WHILE - 19)) | (1L << (WAIT - 19)) | (1L << (STRINGKW - 19)) | (1L << (INTEGERKW - 19)) | (1L << (FLOATKW - 19)) | (1L << (SET - 19)) | (1L << (GET - 19)) | (1L << (RETURN - 19)) | (1L << (BREAK - 19)) | (1L << (ID - 19)))) != 0)) {
				{
				setState(276);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(266);
					waitStmt();
					}
					break;
				case 2:
					{
					setState(267);
					assignment();
					}
					break;
				case 3:
					{
					setState(268);
					ifstmt();
					}
					break;
				case 4:
					{
					setState(269);
					whilestmt();
					}
					break;
				case 5:
					{
					setState(270);
					funcCall();
					setState(271);
					match(SEMCOL);
					}
					break;
				case 6:
					{
					setState(273);
					declVar();
					}
					break;
				case 7:
					{
					setState(274);
					brk();
					}
					break;
				case 8:
					{
					setState(275);
					rtn();
					}
					break;
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WaitStmtContext extends ParserRuleContext {
		public TerminalNode WAIT() { return getToken(PivotParser.WAIT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TimeFrameContext timeFrame() {
			return getRuleContext(TimeFrameContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public WaitStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waitStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterWaitStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitWaitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitWaitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitStmtContext waitStmt() throws RecognitionException {
		WaitStmtContext _localctx = new WaitStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_waitStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(WAIT);
			setState(282);
			expr(0);
			setState(283);
			timeFrame();
			setState(284);
			match(SEMCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public Token varID;
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			((AssignmentContext)_localctx).varID = match(ID);
			setState(287);
			match(EQUALS);
			setState(288);
			expr(0);
			setState(289);
			match(SEMCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstmtContext extends ParserRuleContext {
		public BlockContext blck;
		public BlockContext elseblck;
		public TerminalNode IF() { return getToken(PivotParser.IF, 0); }
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PivotParser.ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(IF);
			setState(292);
			match(PARANBEG);
			setState(293);
			logical_expr(0);
			setState(294);
			match(PARANEND);
			setState(295);
			((IfstmtContext)_localctx).blck = block();
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(296);
				match(ELSE);
				setState(297);
				((IfstmtContext)_localctx).elseblck = block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhilestmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PivotParser.WHILE, 0); }
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitWhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(WHILE);
			setState(301);
			match(PARANBEG);
			setState(302);
			logical_expr(0);
			setState(303);
			match(PARANEND);
			setState(304);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
	 
		public FuncCallContext() { }
		public void copyFrom(FuncCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GetFunContext extends FuncCallContext {
		public Token deviceID;
		public Token signalID;
		public TerminalNode GET() { return getToken(PivotParser.GET, 0); }
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public GetFunContext(FuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterGetFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitGetFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitGetFun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunCallContext extends FuncCallContext {
		public Token id;
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public FunCallContext(FuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFunCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFunCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFunCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetFunContext extends FuncCallContext {
		public Token deviceID;
		public Token signalID;
		public TerminalNode SET() { return getToken(PivotParser.SET, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public SetFunContext(FuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterSetFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitSetFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitSetFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_funcCall);
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new FunCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				((FunCallContext)_localctx).id = match(ID);
				setState(307);
				match(PARANBEG);
				setState(308);
				arguments();
				setState(309);
				match(PARANEND);
				}
				break;
			case SET:
				_localctx = new SetFunContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(SET);
				setState(312);
				((SetFunContext)_localctx).deviceID = match(ID);
				setState(313);
				((SetFunContext)_localctx).signalID = match(ID);
				setState(314);
				match(COL);
				setState(315);
				expr(0);
				}
				break;
			case GET:
				_localctx = new GetFunContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				match(GET);
				setState(317);
				((GetFunContext)_localctx).deviceID = match(ID);
				setState(318);
				((GetFunContext)_localctx).signalID = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> LISTSEP() { return getTokens(PivotParser.LISTSEP); }
		public TerminalNode LISTSEP(int i) {
			return getToken(PivotParser.LISTSEP, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (SET - 36)) | (1L << (GET - 36)) | (1L << (NOW - 36)) | (1L << (PARANBEG - 36)) | (1L << (FLOAT - 36)) | (1L << (INTEGER - 36)) | (1L << (STRING - 36)) | (1L << (ID - 36)))) != 0)) {
				{
				setState(321);
				expr(0);
				}
			}

			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(324);
				match(LISTSEP);
				setState(325);
				expr(0);
				}
				}
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclVarContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public DeclVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterDeclVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitDeclVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitDeclVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclVarContext declVar() throws RecognitionException {
		DeclVarContext _localctx = new DeclVarContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_declVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			varType();
			setState(332);
			match(ID);
			setState(333);
			match(EQUALS);
			setState(334);
			expr(0);
			setState(335);
			match(SEMCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BrkContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(PivotParser.BREAK, 0); }
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public BrkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterBrk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitBrk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitBrk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BrkContext brk() throws RecognitionException {
		BrkContext _localctx = new BrkContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_brk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(BREAK);
			setState(338);
			match(SEMCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RtnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(PivotParser.RETURN, 0); }
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RtnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rtn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterRtn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitRtn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitRtn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RtnContext rtn() throws RecognitionException {
		RtnContext _localctx = new RtnContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_rtn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(340);
			match(RETURN);
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (SET - 36)) | (1L << (GET - 36)) | (1L << (NOW - 36)) | (1L << (PARANBEG - 36)) | (1L << (FLOAT - 36)) | (1L << (INTEGER - 36)) | (1L << (STRING - 36)) | (1L << (ID - 36)))) != 0)) {
				{
				setState(341);
				expr(0);
				}
			}

			setState(344);
			match(SEMCOL);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LitValContext extends ParserRuleContext {
		public LitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_litVal; }
	 
		public LitValContext() { }
		public void copyFrom(LitValContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntValContext extends LitValContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public IntValContext(LitValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIntVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValContext extends LitValContext {
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public StringValContext(LitValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterStringVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitStringVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitStringVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatValContext extends LitValContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatValContext(LitValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFloatVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFloatVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFloatVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitValContext litVal() throws RecognitionException {
		LitValContext _localctx = new LitValContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_litVal);
		try {
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunCallExprContext extends ExprContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public FunCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFunCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFunCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFunCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiExprContext extends ExprContext {
		public ExprContext leftChild;
		public Token op;
		public ExprContext rightChild;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(PivotParser.DIV, 0); }
		public TerminalNode MULT() { return getToken(PivotParser.MULT, 0); }
		public MultiExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterMultiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitMultiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitMultiExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanExprContext extends ExprContext {
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public ParanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterParanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitParanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitParanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusExprContext extends ExprContext {
		public ExprContext leftChild;
		public Token op;
		public ExprContext rightChild;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(PivotParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PivotParser.MINUS, 0); }
		public PlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterPlusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitPlusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new ParanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(352);
				match(PARANBEG);
				setState(353);
				expr(0);
				setState(354);
				match(PARANEND);
				}
				break;
			case 2:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356);
				atom();
				}
				break;
			case 3:
				{
				_localctx = new FunCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(357);
				funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(368);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(366);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new MultiExprContext(new ExprContext(_parentctx, _parentState));
						((MultiExprContext)_localctx).leftChild = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(360);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(361);
						((MultiExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIV || _la==MULT) ) {
							((MultiExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(362);
						((MultiExprContext)_localctx).rightChild = expr(6);
						}
						break;
					case 2:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						((PlusExprContext)_localctx).leftChild = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(363);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(364);
						((PlusExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((PlusExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(365);
						((PlusExprContext)_localctx).rightChild = expr(5);
						}
						break;
					}
					} 
				}
				setState(370);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Logical_exprContext extends ParserRuleContext {
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
	 
		public Logical_exprContext() { }
		public void copyFrom(Logical_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalExpressionOrContext extends Logical_exprContext {
		public Logical_exprContext left;
		public Logical_exprContext right;
		public TerminalNode OR() { return getToken(PivotParser.OR, 0); }
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public LogicalExpressionOrContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterLogicalExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitLogicalExpressionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitLogicalExpressionOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpressionContext extends Logical_exprContext {
		public Comparison_exprContext comparison_expr() {
			return getRuleContext(Comparison_exprContext.class,0);
		}
		public ComparisonExpressionContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalLiteralsContext extends Logical_exprContext {
		public TerminalNode TRUE() { return getToken(PivotParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PivotParser.FALSE, 0); }
		public LogicalLiteralsContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterLogicalLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitLogicalLiterals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitLogicalLiterals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExpressionAndContext extends Logical_exprContext {
		public Logical_exprContext left;
		public Logical_exprContext right;
		public TerminalNode AND() { return getToken(PivotParser.AND, 0); }
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public LogicalExpressionAndContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterLogicalExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitLogicalExpressionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitLogicalExpressionAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExpressionInParenContext extends Logical_exprContext {
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public LogicalExpressionInParenContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterLogicalExpressionInParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitLogicalExpressionInParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitLogicalExpressionInParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		return logical_expr(0);
	}

	private Logical_exprContext logical_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, _parentState);
		Logical_exprContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_logical_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(372);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(373);
				match(PARANBEG);
				setState(374);
				logical_expr(0);
				setState(375);
				match(PARANEND);
				}
				break;
			case 3:
				{
				_localctx = new LogicalLiteralsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(377);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(386);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						((LogicalExpressionAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(380);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(381);
						match(AND);
						setState(382);
						((LogicalExpressionAndContext)_localctx).right = logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						((LogicalExpressionOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(383);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(384);
						match(OR);
						setState(385);
						((LogicalExpressionOrContext)_localctx).right = logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(390);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Comparison_exprContext extends ParserRuleContext {
		public Comparison_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_expr; }
	 
		public Comparison_exprContext() { }
		public void copyFrom(Comparison_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComparisonExpressionWithOperatorContext extends Comparison_exprContext {
		public Comparison_operandContext left;
		public Comp_operatorContext op;
		public Comparison_operandContext right;
		public List<Comparison_operandContext> comparison_operand() {
			return getRuleContexts(Comparison_operandContext.class);
		}
		public Comparison_operandContext comparison_operand(int i) {
			return getRuleContext(Comparison_operandContext.class,i);
		}
		public Comp_operatorContext comp_operator() {
			return getRuleContext(Comp_operatorContext.class,0);
		}
		public ComparisonExpressionWithOperatorContext(Comparison_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterComparisonExpressionWithOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitComparisonExpressionWithOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComparisonExpressionWithOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpressionParensContext extends Comparison_exprContext {
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public Comparison_exprContext comparison_expr() {
			return getRuleContext(Comparison_exprContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public ComparisonExpressionParensContext(Comparison_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterComparisonExpressionParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitComparisonExpressionParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComparisonExpressionParens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_exprContext comparison_expr() throws RecognitionException {
		Comparison_exprContext _localctx = new Comparison_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_comparison_expr);
		try {
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new ComparisonExpressionWithOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				((ComparisonExpressionWithOperatorContext)_localctx).left = comparison_operand();
				setState(392);
				((ComparisonExpressionWithOperatorContext)_localctx).op = comp_operator();
				setState(393);
				((ComparisonExpressionWithOperatorContext)_localctx).right = comparison_operand();
				}
				break;
			case 2:
				_localctx = new ComparisonExpressionParensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				match(PARANBEG);
				setState(396);
				comparison_expr();
				setState(397);
				match(PARANEND);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comparison_operandContext extends ParserRuleContext {
		public Comparison_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_operand; }
	 
		public Comparison_operandContext() { }
		public void copyFrom(Comparison_operandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComOperandDateContext extends Comparison_operandContext {
		public TerminalNode DATE() { return getToken(PivotParser.DATE, 0); }
		public TerminalNode DATEnoYEAR() { return getToken(PivotParser.DATEnoYEAR, 0); }
		public ComOperandDateContext(Comparison_operandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterComOperandDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitComOperandDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComOperandDate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComOperandExprContext extends Comparison_operandContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ComOperandExprContext(Comparison_operandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterComOperandExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitComOperandExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComOperandExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompOperandTimeContext extends Comparison_operandContext {
		public TerminalNode TIME() { return getToken(PivotParser.TIME, 0); }
		public CompOperandTimeContext(Comparison_operandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterCompOperandTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitCompOperandTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitCompOperandTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_operandContext comparison_operand() throws RecognitionException {
		Comparison_operandContext _localctx = new Comparison_operandContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_comparison_operand);
		int _la;
		try {
			setState(404);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME:
				_localctx = new CompOperandTimeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(TIME);
				}
				break;
			case DATE:
			case DATEnoYEAR:
				_localctx = new ComOperandDateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				_la = _input.LA(1);
				if ( !(_la==DATE || _la==DATEnoYEAR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case SET:
			case GET:
			case NOW:
			case PARANBEG:
			case FLOAT:
			case INTEGER:
			case STRING:
			case ID:
				_localctx = new ComOperandExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_operatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(PivotParser.GT, 0); }
		public TerminalNode GE() { return getToken(PivotParser.GE, 0); }
		public TerminalNode ST() { return getToken(PivotParser.ST, 0); }
		public TerminalNode SE() { return getToken(PivotParser.SE, 0); }
		public TerminalNode EQ() { return getToken(PivotParser.EQ, 0); }
		public TerminalNode NE() { return getToken(PivotParser.NE, 0); }
		public Comp_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterComp_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitComp_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComp_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_operatorContext comp_operator() throws RecognitionException {
		Comp_operatorContext _localctx = new Comp_operatorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << ST) | (1L << SE) | (1L << EQ) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public Token varID;
		public LitValContext litVal() {
			return getRuleContext(LitValContext.class,0);
		}
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode NOW() { return getToken(PivotParser.NOW, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_atom);
		try {
			setState(411);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INTEGER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				litVal();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
				((AtomContext)_localctx).varID = match(ID);
				}
				break;
			case NOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(410);
				match(NOW);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode STRINGKW() { return getToken(PivotParser.STRINGKW, 0); }
		public TerminalNode INTEGERKW() { return getToken(PivotParser.INTEGERKW, 0); }
		public TerminalNode FLOATKW() { return getToken(PivotParser.FLOATKW, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRINGKW) | (1L << INTEGERKW) | (1L << FLOATKW))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 34:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 35:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u01a2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\3\3\3\7\3`\n\3\f\3\16\3c\13\3\3\3"+
		"\5\3f\n\3\3\3\3\3\7\3j\n\3\f\3\16\3m\13\3\3\4\3\4\3\4\5\4r\n\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\5\5{\n\5\3\6\3\6\3\6\7\6\u0080\n\6\f\6\16\6\u0083"+
		"\13\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\5\t\u008f\n\t\3\n\3\n\5"+
		"\n\u0093\n\n\3\13\3\13\3\13\5\13\u0098\n\13\3\13\3\13\5\13\u009c\n\13"+
		"\3\13\5\13\u009f\n\13\3\13\3\13\5\13\u00a3\n\13\5\13\u00a5\n\13\3\f\3"+
		"\f\3\f\3\f\3\f\7\f\u00ac\n\f\f\f\16\f\u00af\13\f\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u00b6\n\r\f\r\16\r\u00b9\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\5\20\u00c8\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\7\21\u00d3\n\21\f\21\16\21\u00d6\13\21\5\21\u00d8"+
		"\n\21\3\22\3\22\3\22\3\23\3\23\5\23\u00df\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00ea\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f1"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00ff\n\25\3\26\3\26\3\26\3\26\5\26\u0105\n\26\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0117"+
		"\n\31\f\31\16\31\u011a\13\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u012d\n\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u0142\n\36\3\37\5\37\u0145\n\37\3\37\3\37\7\37\u0149"+
		"\n\37\f\37\16\37\u014c\13\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\5\"\u0159"+
		"\n\"\3\"\3\"\3#\3#\3#\5#\u0160\n#\3$\3$\3$\3$\3$\3$\3$\5$\u0169\n$\3$"+
		"\3$\3$\3$\3$\3$\7$\u0171\n$\f$\16$\u0174\13$\3%\3%\3%\3%\3%\3%\3%\5%\u017d"+
		"\n%\3%\3%\3%\3%\3%\3%\7%\u0185\n%\f%\16%\u0188\13%\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\5&\u0192\n&\3\'\3\'\3\'\5\'\u0197\n\'\3(\3(\3)\3)\3)\5)\u019e\n)"+
		"\3*\3*\3*\2\4FH+\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPR\2\t\3\2\33!\3\2\66\67\3\2\64\65\3\2\16\17\3\2>?\3"+
		"\2\b\r\3\2#%\2\u01b1\2T\3\2\2\2\4Z\3\2\2\2\6n\3\2\2\2\bu\3\2\2\2\n|\3"+
		"\2\2\2\f\u0084\3\2\2\2\16\u0088\3\2\2\2\20\u008e\3\2\2\2\22\u0092\3\2"+
		"\2\2\24\u0094\3\2\2\2\26\u00a6\3\2\2\2\30\u00b0\3\2\2\2\32\u00ba\3\2\2"+
		"\2\34\u00c0\3\2\2\2\36\u00c7\3\2\2\2 \u00d7\3\2\2\2\"\u00d9\3\2\2\2$\u00de"+
		"\3\2\2\2&\u00f0\3\2\2\2(\u00fe\3\2\2\2*\u0104\3\2\2\2,\u0106\3\2\2\2."+
		"\u0108\3\2\2\2\60\u0118\3\2\2\2\62\u011b\3\2\2\2\64\u0120\3\2\2\2\66\u0125"+
		"\3\2\2\28\u012e\3\2\2\2:\u0141\3\2\2\2<\u0144\3\2\2\2>\u014d\3\2\2\2@"+
		"\u0153\3\2\2\2B\u0156\3\2\2\2D\u015f\3\2\2\2F\u0168\3\2\2\2H\u017c\3\2"+
		"\2\2J\u0191\3\2\2\2L\u0196\3\2\2\2N\u0198\3\2\2\2P\u019d\3\2\2\2R\u019f"+
		"\3\2\2\2TU\5\4\3\2UV\7\2\2\3V\3\3\2\2\2WY\5\6\4\2XW\3\2\2\2Y\\\3\2\2\2"+
		"ZX\3\2\2\2Z[\3\2\2\2[a\3\2\2\2\\Z\3\2\2\2]`\5> \2^`\5\32\16\2_]\3\2\2"+
		"\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2df\5\34"+
		"\17\2ed\3\2\2\2ef\3\2\2\2fk\3\2\2\2gj\5\36\20\2hj\5$\23\2ig\3\2\2\2ih"+
		"\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\5\3\2\2\2mk\3\2\2\2nq\7\24\2\2"+
		"or\5\b\5\2pr\5\24\13\2qo\3\2\2\2qp\3\2\2\2rs\3\2\2\2st\79\2\2t\7\3\2\2"+
		"\2uv\7\20\2\2vw\7D\2\2wz\7<\2\2x{\5\16\b\2y{\5\n\6\2zx\3\2\2\2zy\3\2\2"+
		"\2{\t\3\2\2\2|\u0081\5\f\7\2}~\7:\2\2~\u0080\5\f\7\2\177}\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\13\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0084\u0085\7D\2\2\u0085\u0086\7\63\2\2\u0086\u0087"+
		"\5D#\2\u0087\r\3\2\2\2\u0088\u0089\5\20\t\2\u0089\u008a\78\2\2\u008a\u008b"+
		"\5\22\n\2\u008b\17\3\2\2\2\u008c\u008f\7B\2\2\u008d\u008f\7@\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\21\3\2\2\2\u0090\u0093\7B\2\2"+
		"\u0091\u0093\7@\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\23\3"+
		"\2\2\2\u0094\u0095\7\23\2\2\u0095\u00a4\7D\2\2\u0096\u0098\5\26\f\2\u0097"+
		"\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u009a\7="+
		"\2\2\u009a\u009c\5\30\r\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u00a5\3\2\2\2\u009d\u009f\5\30\r\2\u009e\u009d\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u00a1\7=\2\2\u00a1\u00a3\5\26\f\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u0097\3\2"+
		"\2\2\u00a4\u009e\3\2\2\2\u00a5\25\3\2\2\2\u00a6\u00a7\7\21\2\2\u00a7\u00a8"+
		"\7<\2\2\u00a8\u00ad\7D\2\2\u00a9\u00aa\7:\2\2\u00aa\u00ac\7D\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\27\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\22\2\2\u00b1\u00b2"+
		"\7<\2\2\u00b2\u00b7\7D\2\2\u00b3\u00b4\7:\2\2\u00b4\u00b6\7D\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\31\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7D\2\2\u00bb\u00bc"+
		"\7D\2\2\u00bc\u00bd\7\63\2\2\u00bd\u00be\7C\2\2\u00be\u00bf\79\2\2\u00bf"+
		"\33\3\2\2\2\u00c0\u00c1\7\27\2\2\u00c1\u00c2\7/\2\2\u00c2\u00c3\7\60\2"+
		"\2\u00c3\u00c4\5.\30\2\u00c4\35\3\2\2\2\u00c5\u00c8\5R*\2\u00c6\u00c8"+
		"\7\30\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2"+
		"\u00c9\u00ca\7D\2\2\u00ca\u00cb\7/\2\2\u00cb\u00cc\5 \21\2\u00cc\u00cd"+
		"\7\60\2\2\u00cd\u00ce\5.\30\2\u00ce\37\3\2\2\2\u00cf\u00d4\5\"\22\2\u00d0"+
		"\u00d1\7:\2\2\u00d1\u00d3\5\"\22\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2"+
		"\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8!\3\2\2\2"+
		"\u00d9\u00da\5R*\2\u00da\u00db\7D\2\2\u00db#\3\2\2\2\u00dc\u00df\5&\24"+
		"\2\u00dd\u00df\5(\25\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df%"+
		"\3\2\2\2\u00e0\u00e1\7\31\2\2\u00e1\u00e2\7D\2\2\u00e2\u00e3\7D\2\2\u00e3"+
		"\u00e9\7<\2\2\u00e4\u00ea\7D\2\2\u00e5\u00e6\7(\2\2\u00e6\u00ea\5F$\2"+
		"\u00e7\u00e8\7)\2\2\u00e8\u00ea\5F$\2\u00e9\u00e4\3\2\2\2\u00e9\u00e5"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f1\5.\30\2\u00ec"+
		"\u00ed\7\31\2\2\u00ed\u00ee\5*\26\2\u00ee\u00ef\5.\30\2\u00ef\u00f1\3"+
		"\2\2\2\u00f0\u00e0\3\2\2\2\u00f0\u00ec\3\2\2\2\u00f1\'\3\2\2\2\u00f2\u00f3"+
		"\7\32\2\2\u00f3\u00f4\5F$\2\u00f4\u00f5\5,\27\2\u00f5\u00f6\5.\30\2\u00f6"+
		"\u00ff\3\2\2\2\u00f7\u00f8\7\32\2\2\u00f8\u00f9\5F$\2\u00f9\u00fa\5,\27"+
		"\2\u00fa\u00fb\7.\2\2\u00fb\u00fc\5*\26\2\u00fc\u00fd\5.\30\2\u00fd\u00ff"+
		"\3\2\2\2\u00fe\u00f2\3\2\2\2\u00fe\u00f7\3\2\2\2\u00ff)\3\2\2\2\u0100"+
		"\u0101\7A\2\2\u0101\u0105\7>\2\2\u0102\u0105\7>\2\2\u0103\u0105\7A\2\2"+
		"\u0104\u0100\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105+\3"+
		"\2\2\2\u0106\u0107\t\2\2\2\u0107-\3\2\2\2\u0108\u0109\7\61\2\2\u0109\u010a"+
		"\5\60\31\2\u010a\u010b\7\62\2\2\u010b/\3\2\2\2\u010c\u0117\5\62\32\2\u010d"+
		"\u0117\5\64\33\2\u010e\u0117\5\66\34\2\u010f\u0117\58\35\2\u0110\u0111"+
		"\5:\36\2\u0111\u0112\79\2\2\u0112\u0117\3\2\2\2\u0113\u0117\5> \2\u0114"+
		"\u0117\5@!\2\u0115\u0117\5B\"\2\u0116\u010c\3\2\2\2\u0116\u010d\3\2\2"+
		"\2\u0116\u010e\3\2\2\2\u0116\u010f\3\2\2\2\u0116\u0110\3\2\2\2\u0116\u0113"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\61\3\2\2\2\u011a\u0118\3\2\2"+
		"\2\u011b\u011c\7\"\2\2\u011c\u011d\5F$\2\u011d\u011e\5,\27\2\u011e\u011f"+
		"\79\2\2\u011f\63\3\2\2\2\u0120\u0121\7D\2\2\u0121\u0122\7\63\2\2\u0122"+
		"\u0123\5F$\2\u0123\u0124\79\2\2\u0124\65\3\2\2\2\u0125\u0126\7\25\2\2"+
		"\u0126\u0127\7/\2\2\u0127\u0128\5H%\2\u0128\u0129\7\60\2\2\u0129\u012c"+
		"\5.\30\2\u012a\u012b\7+\2\2\u012b\u012d\5.\30\2\u012c\u012a\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012d\67\3\2\2\2\u012e\u012f\7\26\2\2\u012f\u0130\7/\2"+
		"\2\u0130\u0131\5H%\2\u0131\u0132\7\60\2\2\u0132\u0133\5.\30\2\u01339\3"+
		"\2\2\2\u0134\u0135\7D\2\2\u0135\u0136\7/\2\2\u0136\u0137\5<\37\2\u0137"+
		"\u0138\7\60\2\2\u0138\u0142\3\2\2\2\u0139\u013a\7&\2\2\u013a\u013b\7D"+
		"\2\2\u013b\u013c\7D\2\2\u013c\u013d\7<\2\2\u013d\u0142\5F$\2\u013e\u013f"+
		"\7\'\2\2\u013f\u0140\7D\2\2\u0140\u0142\7D\2\2\u0141\u0134\3\2\2\2\u0141"+
		"\u0139\3\2\2\2\u0141\u013e\3\2\2\2\u0142;\3\2\2\2\u0143\u0145\5F$\2\u0144"+
		"\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u014a\3\2\2\2\u0146\u0147\7:"+
		"\2\2\u0147\u0149\5F$\2\u0148\u0146\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b=\3\2\2\2\u014c\u014a\3\2\2\2\u014d"+
		"\u014e\5R*\2\u014e\u014f\7D\2\2\u014f\u0150\7\63\2\2\u0150\u0151\5F$\2"+
		"\u0151\u0152\79\2\2\u0152?\3\2\2\2\u0153\u0154\7-\2\2\u0154\u0155\79\2"+
		"\2\u0155A\3\2\2\2\u0156\u0158\7,\2\2\u0157\u0159\5F$\2\u0158\u0157\3\2"+
		"\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\79\2\2\u015b"+
		"C\3\2\2\2\u015c\u0160\7B\2\2\u015d\u0160\7@\2\2\u015e\u0160\7C\2\2\u015f"+
		"\u015c\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u0160E\3\2\2\2"+
		"\u0161\u0162\b$\1\2\u0162\u0163\7/\2\2\u0163\u0164\5F$\2\u0164\u0165\7"+
		"\60\2\2\u0165\u0169\3\2\2\2\u0166\u0169\5P)\2\u0167\u0169\5:\36\2\u0168"+
		"\u0161\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u0172\3\2"+
		"\2\2\u016a\u016b\f\7\2\2\u016b\u016c\t\3\2\2\u016c\u0171\5F$\b\u016d\u016e"+
		"\f\6\2\2\u016e\u016f\t\4\2\2\u016f\u0171\5F$\7\u0170\u016a\3\2\2\2\u0170"+
		"\u016d\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173G\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176\b%\1\2\u0176\u017d"+
		"\5J&\2\u0177\u0178\7/\2\2\u0178\u0179\5H%\2\u0179\u017a\7\60\2\2\u017a"+
		"\u017d\3\2\2\2\u017b\u017d\t\5\2\2\u017c\u0175\3\2\2\2\u017c\u0177\3\2"+
		"\2\2\u017c\u017b\3\2\2\2\u017d\u0186\3\2\2\2\u017e\u017f\f\7\2\2\u017f"+
		"\u0180\7\6\2\2\u0180\u0185\5H%\b\u0181\u0182\f\6\2\2\u0182\u0183\7\7\2"+
		"\2\u0183\u0185\5H%\7\u0184\u017e\3\2\2\2\u0184\u0181\3\2\2\2\u0185\u0188"+
		"\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187I\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0189\u018a\5L\'\2\u018a\u018b\5N(\2\u018b\u018c\5L\'\2"+
		"\u018c\u0192\3\2\2\2\u018d\u018e\7/\2\2\u018e\u018f\5J&\2\u018f\u0190"+
		"\7\60\2\2\u0190\u0192\3\2\2\2\u0191\u0189\3\2\2\2\u0191\u018d\3\2\2\2"+
		"\u0192K\3\2\2\2\u0193\u0197\7A\2\2\u0194\u0197\t\6\2\2\u0195\u0197\5F"+
		"$\2\u0196\u0193\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0197"+
		"M\3\2\2\2\u0198\u0199\t\7\2\2\u0199O\3\2\2\2\u019a\u019e\5D#\2\u019b\u019e"+
		"\7D\2\2\u019c\u019e\7*\2\2\u019d\u019a\3\2\2\2\u019d\u019b\3\2\2\2\u019d"+
		"\u019c\3\2\2\2\u019eQ\3\2\2\2\u019f\u01a0\t\b\2\2\u01a0S\3\2\2\2-Z_ae"+
		"ikqz\u0081\u008e\u0092\u0097\u009b\u009e\u00a2\u00a4\u00ad\u00b7\u00c7"+
		"\u00d4\u00d7\u00de\u00e9\u00f0\u00fe\u0104\u0116\u0118\u012c\u0141\u0144"+
		"\u014a\u0158\u015f\u0168\u0170\u0172\u017c\u0184\u0186\u0191\u0196\u019d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
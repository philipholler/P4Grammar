// Generated from /Users/philip/Library/Mobile Documents/com~apple~CloudDocs/Cloud dokumenter/Java projects/P4Grammar/Pivot.g4 by ANTLR 4.7.2
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
		WhiteSpace=1, NewLine=2, LINE_COMMENT=3, TRUE=4, FALSE=5, AND=6, OR=7, 
		GT=8, GE=9, LT=10, LE=11, EQ=12, NE=13, SIGNALKW=14, INPUTKW=15, OUTPUTKW=16, 
		DEVICE=17, DEFINEKW=18, IF=19, WHILE=20, INITFUNCKW=21, VOID=22, WHEN=23, 
		EVERY=24, MS=25, SECONDS=26, MINUTES=27, HOURS=28, DAYS=29, WAIT=30, STRINGKW=31, 
		INTEGERKW=32, FLOATKW=33, SET=34, GET=35, EXCEEDS=36, DECEEDS=37, NOW=38, 
		ELSE=39, RETURN=40, BREAK=41, PARANBEG=42, PARANEND=43, BLCKBEG=44, BLCKEND=45, 
		EQUALS=46, PLUS=47, MINUS=48, DIV=49, MULT=50, RANGESEP=51, SEMCOL=52, 
		LISTSEP=53, QUOT=54, COL=55, AMP=56, FLOAT=57, TIME=58, IP=59, INTEGER=60, 
		STRING=61, ID=62, SIGN=63;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_define = 2, RULE_signal = 3, RULE_signalID = 4, 
		RULE_device = 5, RULE_init = 6, RULE_func = 7, RULE_fParams = 8, RULE_param = 9, 
		RULE_event = 10, RULE_atomEvent = 11, RULE_repeatEvent = 12, RULE_inputs = 13, 
		RULE_input = 14, RULE_inputID = 15, RULE_outputs = 16, RULE_output = 17, 
		RULE_outputID = 18, RULE_deviceID = 19, RULE_ip = 20, RULE_varID = 21, 
		RULE_block = 22, RULE_rtn = 23, RULE_ifstmt = 24, RULE_stmts = 25, RULE_brk = 26, 
		RULE_declVar = 27, RULE_funcCall = 28, RULE_inputParam = 29, RULE_wait = 30, 
		RULE_timeVal = 31, RULE_whilestmt = 32, RULE_assignment = 33, RULE_expr = 34, 
		RULE_logical_expr = 35, RULE_comparison_expr = 36, RULE_comparison_operand = 37, 
		RULE_time = 38, RULE_comp_operator = 39, RULE_atom = 40, RULE_type = 41, 
		RULE_range = 42, RULE_lowerBound = 43, RULE_upperBound = 44, RULE_togglevalues = 45, 
		RULE_togglevalue = 46, RULE_toggleID = 47, RULE_toggleVal = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "define", "signal", "signalID", "device", "init", 
			"func", "fParams", "param", "event", "atomEvent", "repeatEvent", "inputs", 
			"input", "inputID", "outputs", "output", "outputID", "deviceID", "ip", 
			"varID", "block", "rtn", "ifstmt", "stmts", "brk", "declVar", "funcCall", 
			"inputParam", "wait", "timeVal", "whilestmt", "assignment", "expr", "logical_expr", 
			"comparison_expr", "comparison_operand", "time", "comp_operator", "atom", 
			"type", "range", "lowerBound", "upperBound", "togglevalues", "togglevalue", 
			"toggleID", "toggleVal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'true'", "'false'", "'&&'", "'||'", "'>'", "'>='", 
			"'<'", "'<='", "'=='", "'!='", "'Signal'", "'input'", "'output'", "'Device'", 
			"'define'", "'if'", "'while'", "'init'", "'void'", "'when'", "'every'", 
			"'ms'", "'seconds'", "'minutes'", "'hours'", "'days'", "'wait'", "'string'", 
			"'int'", "'float'", "'set'", "'get'", "'exceeds'", "'deceeds'", "'now'", 
			"'else'", "'return'", "'break'", "'('", "')'", "'{'", "'}'", "'='", "'+'", 
			"'-'", "'/'", "'*'", "'..'", "';'", "','", "'\"'", "':'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WhiteSpace", "NewLine", "LINE_COMMENT", "TRUE", "FALSE", "AND", 
			"OR", "GT", "GE", "LT", "LE", "EQ", "NE", "SIGNALKW", "INPUTKW", "OUTPUTKW", 
			"DEVICE", "DEFINEKW", "IF", "WHILE", "INITFUNCKW", "VOID", "WHEN", "EVERY", 
			"MS", "SECONDS", "MINUTES", "HOURS", "DAYS", "WAIT", "STRINGKW", "INTEGERKW", 
			"FLOATKW", "SET", "GET", "EXCEEDS", "DECEEDS", "NOW", "ELSE", "RETURN", 
			"BREAK", "PARANBEG", "PARANEND", "BLCKBEG", "BLCKEND", "EQUALS", "PLUS", 
			"MINUS", "DIV", "MULT", "RANGESEP", "SEMCOL", "LISTSEP", "QUOT", "COL", 
			"AMP", "FLOAT", "TIME", "IP", "INTEGER", "STRING", "ID", "SIGN"
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
			setState(98);
			decls();
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
		public TerminalNode EOF() { return getToken(PivotParser.EOF, 0); }
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
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINEKW) {
				{
				{
				setState(100);
				define();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(106);
					declVar();
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITFUNCKW) {
				{
				setState(112);
				init();
				}
			}

			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << WHEN) | (1L << EVERY) | (1L << STRINGKW) | (1L << INTEGERKW) | (1L << FLOATKW))) != 0)) {
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VOID:
				case STRINGKW:
				case INTEGERKW:
				case FLOATKW:
					{
					setState(115);
					func();
					}
					break;
				case WHEN:
				case EVERY:
					{
					setState(116);
					event();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
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
			setState(124);
			match(DEFINEKW);
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIGNALKW:
				{
				setState(125);
				signal();
				}
				break;
			case DEVICE:
				{
				setState(126);
				device();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(129);
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
		public TerminalNode SIGNALKW() { return getToken(PivotParser.SIGNALKW, 0); }
		public SignalIDContext signalID() {
			return getRuleContext(SignalIDContext.class,0);
		}
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TogglevaluesContext togglevalues() {
			return getRuleContext(TogglevaluesContext.class,0);
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
			setState(131);
			match(SIGNALKW);
			setState(132);
			signalID();
			setState(133);
			match(COL);
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INTEGER:
				{
				setState(134);
				range();
				}
				break;
			case ID:
				{
				setState(135);
				togglevalues();
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

	public static class SignalIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public SignalIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signalID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterSignalID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitSignalID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitSignalID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignalIDContext signalID() throws RecognitionException {
		SignalIDContext _localctx = new SignalIDContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_signalID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ID);
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
		public DeviceIDContext deviceID() {
			return getRuleContext(DeviceIDContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_device);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(DEVICE);
			setState(141);
			deviceID();
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				{
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INPUTKW) {
					{
					setState(142);
					inputs();
					}
				}

				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMP) {
					{
					setState(145);
					match(AMP);
					setState(146);
					outputs();
					}
				}

				}
				}
				break;
			case 2:
				{
				{
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTPUTKW) {
					{
					setState(149);
					outputs();
					}
				}

				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMP) {
					{
					setState(152);
					match(AMP);
					setState(153);
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
		enterRule(_localctx, 12, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(INITFUNCKW);
			setState(159);
			match(PARANBEG);
			setState(160);
			match(PARANEND);
			setState(161);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public FParamsContext fParams() {
			return getRuleContext(FParamsContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(PivotParser.VOID, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRINGKW:
			case INTEGERKW:
			case FLOATKW:
				{
				setState(163);
				type();
				}
				break;
			case VOID:
				{
				setState(164);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(167);
			match(ID);
			setState(168);
			match(PARANBEG);
			setState(169);
			fParams();
			setState(170);
			match(PARANEND);
			setState(171);
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
		enterRule(_localctx, 16, RULE_fParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRINGKW) | (1L << INTEGERKW) | (1L << FLOATKW))) != 0)) {
				{
				setState(173);
				param();
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LISTSEP) {
					{
					{
					setState(174);
					match(LISTSEP);
					setState(175);
					param();
					}
					}
					setState(180);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		enterRule(_localctx, 18, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			type();
			setState(184);
			match(ID);
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
		enterRule(_localctx, 20, RULE_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHEN:
				{
				setState(186);
				atomEvent();
				}
				break;
			case EVERY:
				{
				setState(187);
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
		public TerminalNode WHEN() { return getToken(PivotParser.WHEN, 0); }
		public DeviceIDContext deviceID() {
			return getRuleContext(DeviceIDContext.class,0);
		}
		public SignalIDContext signalID() {
			return getRuleContext(SignalIDContext.class,0);
		}
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ToggleIDContext toggleID() {
			return getRuleContext(ToggleIDContext.class,0);
		}
		public TerminalNode EXCEEDS() { return getToken(PivotParser.EXCEEDS, 0); }
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public TerminalNode DECEEDS() { return getToken(PivotParser.DECEEDS, 0); }
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
		enterRule(_localctx, 22, RULE_atomEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(WHEN);
			setState(191);
			deviceID();
			setState(192);
			signalID();
			setState(193);
			match(COL);
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(194);
				toggleID();
				}
				break;
			case EXCEEDS:
				{
				setState(195);
				match(EXCEEDS);
				setState(196);
				match(INTEGER);
				}
				break;
			case DECEEDS:
				{
				setState(197);
				match(DECEEDS);
				setState(198);
				match(INTEGER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(201);
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

	public static class RepeatEventContext extends ParserRuleContext {
		public TerminalNode EVERY() { return getToken(PivotParser.EVERY, 0); }
		public TimeValContext timeVal() {
			return getRuleContext(TimeValContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DAYS() { return getToken(PivotParser.DAYS, 0); }
		public TerminalNode HOURS() { return getToken(PivotParser.HOURS, 0); }
		public TerminalNode MINUTES() { return getToken(PivotParser.MINUTES, 0); }
		public TerminalNode SECONDS() { return getToken(PivotParser.SECONDS, 0); }
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
		enterRule(_localctx, 24, RULE_repeatEvent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(EVERY);
			setState(204);
			timeVal();
			setState(205);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SECONDS) | (1L << MINUTES) | (1L << HOURS) | (1L << DAYS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(206);
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

	public static class InputsContext extends ParserRuleContext {
		public TerminalNode INPUTKW() { return getToken(PivotParser.INPUTKW, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public List<InputContext> input() {
			return getRuleContexts(InputContext.class);
		}
		public InputContext input(int i) {
			return getRuleContext(InputContext.class,i);
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
		enterRule(_localctx, 26, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(INPUTKW);
			setState(209);
			match(COL);
			setState(210);
			input();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(211);
				match(LISTSEP);
				setState(212);
				input();
				}
				}
				setState(217);
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

	public static class InputContext extends ParserRuleContext {
		public InputIDContext inputID() {
			return getRuleContext(InputIDContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			inputID();
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

	public static class InputIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public InputIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterInputID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitInputID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInputID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputIDContext inputID() throws RecognitionException {
		InputIDContext _localctx = new InputIDContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inputID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(ID);
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
		public TerminalNode OUTPUTKW() { return getToken(PivotParser.OUTPUTKW, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public List<OutputContext> output() {
			return getRuleContexts(OutputContext.class);
		}
		public OutputContext output(int i) {
			return getRuleContext(OutputContext.class,i);
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
		enterRule(_localctx, 32, RULE_outputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(OUTPUTKW);
			setState(223);
			match(COL);
			setState(224);
			output();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(225);
				match(LISTSEP);
				setState(226);
				output();
				}
				}
				setState(231);
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

	public static class OutputContext extends ParserRuleContext {
		public OutputIDContext outputID() {
			return getRuleContext(OutputIDContext.class,0);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			outputID();
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

	public static class OutputIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public OutputIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterOutputID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitOutputID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitOutputID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputIDContext outputID() throws RecognitionException {
		OutputIDContext _localctx = new OutputIDContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_outputID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(ID);
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

	public static class DeviceIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public DeviceIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deviceID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterDeviceID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitDeviceID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitDeviceID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeviceIDContext deviceID() throws RecognitionException {
		DeviceIDContext _localctx = new DeviceIDContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_deviceID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(ID);
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

	public static class IpContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public IpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IpContext ip() throws RecognitionException {
		IpContext _localctx = new IpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(STRING);
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

	public static class VarIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public VarIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterVarID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitVarID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitVarID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarIDContext varID() throws RecognitionException {
		VarIDContext _localctx = new VarIDContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_varID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(ID);
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
			setState(242);
			match(BLCKBEG);
			setState(243);
			stmts();
			setState(244);
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

	public static class RtnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(PivotParser.RETURN, 0); }
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public VarIDContext varID() {
			return getRuleContext(VarIDContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
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
		enterRule(_localctx, 46, RULE_rtn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(246);
			match(RETURN);
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(247);
				varID();
				}
				break;
			case INTEGER:
				{
				setState(248);
				match(INTEGER);
				}
				break;
			case FLOAT:
				{
				setState(249);
				match(FLOAT);
				}
				break;
			case STRING:
				{
				setState(250);
				match(STRING);
				}
				break;
			case SEMCOL:
				break;
			default:
				break;
			}
			setState(253);
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

	public static class IfstmtContext extends ParserRuleContext {
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
		enterRule(_localctx, 48, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(IF);
			setState(256);
			match(PARANBEG);
			setState(257);
			logical_expr(0);
			setState(258);
			match(PARANEND);
			setState(259);
			block();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(260);
				match(ELSE);
				setState(261);
				block();
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

	public static class StmtsContext extends ParserRuleContext {
		public List<WaitContext> wait() {
			return getRuleContexts(WaitContext.class);
		}
		public WaitContext wait(int i) {
			return getRuleContext(WaitContext.class,i);
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
		public List<RtnContext> rtn() {
			return getRuleContexts(RtnContext.class);
		}
		public RtnContext rtn(int i) {
			return getRuleContext(RtnContext.class,i);
		}
		public List<BrkContext> brk() {
			return getRuleContexts(BrkContext.class);
		}
		public BrkContext brk(int i) {
			return getRuleContext(BrkContext.class,i);
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
		enterRule(_localctx, 50, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << WAIT) | (1L << STRINGKW) | (1L << INTEGERKW) | (1L << FLOATKW) | (1L << SET) | (1L << GET) | (1L << RETURN) | (1L << BREAK) | (1L << ID))) != 0)) {
				{
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(264);
					wait();
					}
					break;
				case 2:
					{
					setState(265);
					assignment();
					}
					break;
				case 3:
					{
					setState(266);
					ifstmt();
					}
					break;
				case 4:
					{
					setState(267);
					whilestmt();
					}
					break;
				case 5:
					{
					setState(268);
					funcCall();
					setState(269);
					match(SEMCOL);
					}
					break;
				case 6:
					{
					setState(271);
					declVar();
					}
					break;
				case 7:
					{
					setState(272);
					rtn();
					}
					break;
				case 8:
					{
					setState(273);
					brk();
					}
					break;
				}
				}
				setState(278);
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
		enterRule(_localctx, 52, RULE_brk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(BREAK);
			setState(280);
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

	public static class DeclVarContext extends ParserRuleContext {
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarIDContext varID() {
			return getRuleContext(VarIDContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public DeviceIDContext deviceID() {
			return getRuleContext(DeviceIDContext.class,0);
		}
		public IpContext ip() {
			return getRuleContext(IpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
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
		enterRule(_localctx, 54, RULE_declVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRINGKW:
			case INTEGERKW:
			case FLOATKW:
				{
				setState(282);
				type();
				setState(283);
				varID();
				setState(284);
				match(EQUALS);
				setState(287);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(285);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FLOAT) | (1L << INTEGER) | (1L << STRING))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case 2:
					{
					setState(286);
					expr(0);
					}
					break;
				}
				}
				break;
			case ID:
				{
				setState(289);
				deviceID();
				setState(290);
				varID();
				setState(291);
				match(EQUALS);
				setState(292);
				ip();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(296);
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

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public InputParamContext inputParam() {
			return getRuleContext(InputParamContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public TerminalNode SET() { return getToken(PivotParser.SET, 0); }
		public DeviceIDContext deviceID() {
			return getRuleContext(DeviceIDContext.class,0);
		}
		public SignalIDContext signalID() {
			return getRuleContext(SignalIDContext.class,0);
		}
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public ToggleIDContext toggleID() {
			return getRuleContext(ToggleIDContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public TerminalNode GET() { return getToken(PivotParser.GET, 0); }
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_funcCall);
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				match(ID);
				setState(299);
				match(PARANBEG);
				setState(300);
				inputParam();
				setState(301);
				match(PARANEND);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(SET);
				setState(304);
				deviceID();
				setState(305);
				signalID();
				setState(306);
				match(COL);
				setState(311);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(307);
					toggleID();
					}
					break;
				case INTEGER:
					{
					setState(308);
					match(INTEGER);
					}
					break;
				case FLOAT:
					{
					setState(309);
					match(FLOAT);
					}
					break;
				case STRING:
					{
					setState(310);
					match(STRING);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				match(GET);
				setState(314);
				deviceID();
				setState(315);
				signalID();
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

	public static class InputParamContext extends ParserRuleContext {
		public List<TerminalNode> LISTSEP() { return getTokens(PivotParser.LISTSEP); }
		public TerminalNode LISTSEP(int i) {
			return getToken(PivotParser.LISTSEP, i);
		}
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(PivotParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(PivotParser.INTEGER, i);
		}
		public InputParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterInputParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitInputParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInputParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputParamContext inputParam() throws RecognitionException {
		InputParamContext _localctx = new InputParamContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_inputParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTEGER || _la==ID) {
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==INTEGER || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(322);
				match(LISTSEP);
				setState(323);
				_la = _input.LA(1);
				if ( !(_la==INTEGER || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(328);
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

	public static class WaitContext extends ParserRuleContext {
		public TerminalNode WAIT() { return getToken(PivotParser.WAIT, 0); }
		public TimeValContext timeVal() {
			return getRuleContext(TimeValContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public TerminalNode DAYS() { return getToken(PivotParser.DAYS, 0); }
		public TerminalNode HOURS() { return getToken(PivotParser.HOURS, 0); }
		public TerminalNode MINUTES() { return getToken(PivotParser.MINUTES, 0); }
		public TerminalNode SECONDS() { return getToken(PivotParser.SECONDS, 0); }
		public TerminalNode MS() { return getToken(PivotParser.MS, 0); }
		public WaitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wait; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterWait(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitWait(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitWait(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitContext wait() throws RecognitionException {
		WaitContext _localctx = new WaitContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_wait);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(WAIT);
			setState(330);
			timeVal();
			setState(331);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MS) | (1L << SECONDS) | (1L << MINUTES) | (1L << HOURS) | (1L << DAYS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(332);
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

	public static class TimeValContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public TimeValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterTimeVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitTimeVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTimeVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeValContext timeVal() throws RecognitionException {
		TimeValContext _localctx = new TimeValContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_timeVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(INTEGER);
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
		enterRule(_localctx, 64, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(WHILE);
			setState(337);
			match(PARANBEG);
			setState(338);
			logical_expr(0);
			setState(339);
			match(PARANEND);
			setState(340);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
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
		enterRule(_localctx, 66, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(ID);
			setState(343);
			match(EQUALS);
			setState(344);
			expr(0);
			setState(345);
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
	public static class FuncexprContext extends ExprContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public FuncexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFuncexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFuncexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFuncexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(PivotParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PivotParser.MINUS, 0); }
		public AddexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterAddexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitAddexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAddexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomexprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterAtomexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitAtomexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAtomexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(PivotParser.DIV, 0); }
		public TerminalNode MULT() { return getToken(PivotParser.MULT, 0); }
		public MultiexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterMultiexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitMultiexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitMultiexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanexprContext extends ExprContext {
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public ParanexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterParanexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitParanexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitParanexpr(this);
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
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new ParanexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(348);
				match(PARANBEG);
				setState(349);
				expr(0);
				setState(350);
				match(PARANEND);
				}
				break;
			case 2:
				{
				_localctx = new AtomexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(352);
				atom();
				}
				break;
			case 3:
				{
				_localctx = new FuncexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353);
				funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(362);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MultiexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(356);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(357);
						_la = _input.LA(1);
						if ( !(_la==DIV || _la==MULT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(358);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new AddexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(359);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(360);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(361);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(PivotParser.OR, 0); }
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
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(PivotParser.AND, 0); }
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
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(368);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(369);
				match(PARANBEG);
				setState(370);
				logical_expr(0);
				setState(371);
				match(PARANEND);
				}
				break;
			case 3:
				{
				_localctx = new LogicalLiteralsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(373);
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
			setState(384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(382);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(376);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(377);
						match(AND);
						setState(378);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(379);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(380);
						match(OR);
						setState(381);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(386);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
	public static class ComparisonExpressionWithOperatorContext extends Comparison_exprContext {
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

	public final Comparison_exprContext comparison_expr() throws RecognitionException {
		Comparison_exprContext _localctx = new Comparison_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_comparison_expr);
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new ComparisonExpressionWithOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				comparison_operand();
				setState(388);
				comp_operator();
				setState(389);
				comparison_operand();
				}
				break;
			case 2:
				_localctx = new ComparisonExpressionParensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				match(PARANBEG);
				setState(392);
				comparison_expr();
				setState(393);
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
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Comparison_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterComparison_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitComparison_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComparison_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_operandContext comparison_operand() throws RecognitionException {
		Comparison_operandContext _localctx = new Comparison_operandContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_comparison_operand);
		try {
			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				time();
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
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
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

	public static class TimeContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(PivotParser.TIME, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(TIME);
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
		public TerminalNode LT() { return getToken(PivotParser.LT, 0); }
		public TerminalNode LE() { return getToken(PivotParser.LE, 0); }
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
		enterRule(_localctx, 78, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NE))) != 0)) ) {
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
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FloatAtomContext extends AtomContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFloatAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFloatAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFloatAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VaridAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public VaridAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterVaridAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitVaridAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitVaridAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NowAtomContext extends AtomContext {
		public TerminalNode NOW() { return getToken(PivotParser.NOW, 0); }
		public NowAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterNowAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitNowAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitNowAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntAtomContext extends AtomContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public IntAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIntAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIntAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitStringAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_atom);
		try {
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(406);
				match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(407);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new VaridAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(408);
				match(ID);
				}
				break;
			case NOW:
				_localctx = new NowAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(409);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode STRINGKW() { return getToken(PivotParser.STRINGKW, 0); }
		public TerminalNode INTEGERKW() { return getToken(PivotParser.INTEGERKW, 0); }
		public TerminalNode FLOATKW() { return getToken(PivotParser.FLOATKW, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
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
		enterRule(_localctx, 84, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			lowerBound();
			setState(415);
			match(RANGESEP);
			setState(416);
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
	public static class FloatLBContext extends LowerBoundContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatLBContext(LowerBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFloatLB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFloatLB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFloatLB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLBContext extends LowerBoundContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public IntLBContext(LowerBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIntLB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIntLB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntLB(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerBoundContext lowerBound() throws RecognitionException {
		LowerBoundContext _localctx = new LowerBoundContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_lowerBound);
		try {
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntLBContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatLBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
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
	public static class IntUPContext extends UpperBoundContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public IntUPContext(UpperBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIntUP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIntUP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntUP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatUPContext extends UpperBoundContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatUPContext(UpperBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterFloatUP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitFloatUP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFloatUP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperBoundContext upperBound() throws RecognitionException {
		UpperBoundContext _localctx = new UpperBoundContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_upperBound);
		try {
			setState(424);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntUPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatUPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
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

	public static class TogglevaluesContext extends ParserRuleContext {
		public List<TogglevalueContext> togglevalue() {
			return getRuleContexts(TogglevalueContext.class);
		}
		public TogglevalueContext togglevalue(int i) {
			return getRuleContext(TogglevalueContext.class,i);
		}
		public List<TerminalNode> LISTSEP() { return getTokens(PivotParser.LISTSEP); }
		public TerminalNode LISTSEP(int i) {
			return getToken(PivotParser.LISTSEP, i);
		}
		public TogglevaluesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_togglevalues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterTogglevalues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitTogglevalues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTogglevalues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TogglevaluesContext togglevalues() throws RecognitionException {
		TogglevaluesContext _localctx = new TogglevaluesContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_togglevalues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			togglevalue();
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(427);
				match(LISTSEP);
				setState(428);
				togglevalue();
				}
				}
				setState(433);
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

	public static class TogglevalueContext extends ParserRuleContext {
		public ToggleIDContext toggleID() {
			return getRuleContext(ToggleIDContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public ToggleValContext toggleVal() {
			return getRuleContext(ToggleValContext.class,0);
		}
		public TogglevalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_togglevalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterTogglevalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitTogglevalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTogglevalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TogglevalueContext togglevalue() throws RecognitionException {
		TogglevalueContext _localctx = new TogglevalueContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_togglevalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			toggleID();
			setState(435);
			match(EQUALS);
			setState(436);
			toggleVal();
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

	public static class ToggleIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public ToggleIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toggleID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterToggleID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitToggleID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitToggleID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToggleIDContext toggleID() throws RecognitionException {
		ToggleIDContext _localctx = new ToggleIDContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_toggleID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(ID);
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

	public static class ToggleValContext extends ParserRuleContext {
		public ToggleValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toggleVal; }
	 
		public ToggleValContext() { }
		public void copyFrom(ToggleValContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringValContext extends ToggleValContext {
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public StringValContext(ToggleValContext ctx) { copyFrom(ctx); }
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
	public static class FloatValContext extends ToggleValContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatValContext(ToggleValContext ctx) { copyFrom(ctx); }
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
	public static class IntegerValContext extends ToggleValContext {
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
		public IntegerValContext(ToggleValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterIntegerVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitIntegerVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntegerVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToggleValContext toggleVal() throws RecognitionException {
		ToggleValContext _localctx = new ToggleValContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_toggleVal);
		try {
			setState(443);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(440);
				match(STRING);
				}
				break;
			case INTEGER:
				_localctx = new IntegerValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(441);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(442);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u01c0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\7\3h"+
		"\n\3\f\3\16\3k\13\3\3\3\7\3n\n\3\f\3\16\3q\13\3\3\3\5\3t\n\3\3\3\3\3\7"+
		"\3x\n\3\f\3\16\3{\13\3\3\3\3\3\3\4\3\4\3\4\5\4\u0082\n\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\5\5\u008b\n\5\3\6\3\6\3\7\3\7\3\7\5\7\u0092\n\7\3\7\3\7"+
		"\5\7\u0096\n\7\3\7\5\7\u0099\n\7\3\7\3\7\5\7\u009d\n\7\5\7\u009f\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\5\t\u00a8\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\7\n\u00b3\n\n\f\n\16\n\u00b6\13\n\5\n\u00b8\n\n\3\13\3\13\3\13"+
		"\3\f\3\f\5\f\u00bf\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ca\n"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17\u00d8"+
		"\n\17\f\17\16\17\u00db\13\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u00e6\n\22\f\22\16\22\u00e9\13\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u00fe\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0109"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0115\n\33"+
		"\f\33\16\33\u0118\13\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u0122"+
		"\n\35\3\35\3\35\3\35\3\35\3\35\5\35\u0129\n\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u013a\n\36\3\36"+
		"\3\36\3\36\3\36\5\36\u0140\n\36\3\37\5\37\u0143\n\37\3\37\3\37\7\37\u0147"+
		"\n\37\f\37\16\37\u014a\13\37\3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\5$\u0165\n$\3$\3$\3$\3$\3$\3"+
		"$\7$\u016d\n$\f$\16$\u0170\13$\3%\3%\3%\3%\3%\3%\3%\5%\u0179\n%\3%\3%"+
		"\3%\3%\3%\3%\7%\u0181\n%\f%\16%\u0184\13%\3&\3&\3&\3&\3&\3&\3&\3&\5&\u018e"+
		"\n&\3\'\3\'\5\'\u0192\n\'\3(\3(\3)\3)\3*\3*\3*\3*\3*\5*\u019d\n*\3+\3"+
		"+\3,\3,\3,\3,\3-\3-\5-\u01a7\n-\3.\3.\5.\u01ab\n.\3/\3/\3/\7/\u01b0\n"+
		"/\f/\16/\u01b3\13/\3\60\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\5\62\u01be"+
		"\n\62\3\62\2\4FH\63\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`b\2\13\3\2\34\37\4\2;;>?\4\2>>@@\3\2\33"+
		"\37\3\2\63\64\3\2\61\62\3\2\6\7\3\2\n\17\3\2!#\2\u01cb\2d\3\2\2\2\4i\3"+
		"\2\2\2\6~\3\2\2\2\b\u0085\3\2\2\2\n\u008c\3\2\2\2\f\u008e\3\2\2\2\16\u00a0"+
		"\3\2\2\2\20\u00a7\3\2\2\2\22\u00b7\3\2\2\2\24\u00b9\3\2\2\2\26\u00be\3"+
		"\2\2\2\30\u00c0\3\2\2\2\32\u00cd\3\2\2\2\34\u00d2\3\2\2\2\36\u00dc\3\2"+
		"\2\2 \u00de\3\2\2\2\"\u00e0\3\2\2\2$\u00ea\3\2\2\2&\u00ec\3\2\2\2(\u00ee"+
		"\3\2\2\2*\u00f0\3\2\2\2,\u00f2\3\2\2\2.\u00f4\3\2\2\2\60\u00f8\3\2\2\2"+
		"\62\u0101\3\2\2\2\64\u0116\3\2\2\2\66\u0119\3\2\2\28\u0128\3\2\2\2:\u013f"+
		"\3\2\2\2<\u0142\3\2\2\2>\u014b\3\2\2\2@\u0150\3\2\2\2B\u0152\3\2\2\2D"+
		"\u0158\3\2\2\2F\u0164\3\2\2\2H\u0178\3\2\2\2J\u018d\3\2\2\2L\u0191\3\2"+
		"\2\2N\u0193\3\2\2\2P\u0195\3\2\2\2R\u019c\3\2\2\2T\u019e\3\2\2\2V\u01a0"+
		"\3\2\2\2X\u01a6\3\2\2\2Z\u01aa\3\2\2\2\\\u01ac\3\2\2\2^\u01b4\3\2\2\2"+
		"`\u01b8\3\2\2\2b\u01bd\3\2\2\2de\5\4\3\2e\3\3\2\2\2fh\5\6\4\2gf\3\2\2"+
		"\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jo\3\2\2\2ki\3\2\2\2ln\58\35\2ml\3\2\2"+
		"\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2\2rt\5\16\b\2sr\3\2"+
		"\2\2st\3\2\2\2ty\3\2\2\2ux\5\20\t\2vx\5\26\f\2wu\3\2\2\2wv\3\2\2\2x{\3"+
		"\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7\2\2\3}\5\3\2\2\2~\u0081"+
		"\7\24\2\2\177\u0082\5\b\5\2\u0080\u0082\5\f\7\2\u0081\177\3\2\2\2\u0081"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\66\2\2\u0084\7\3\2\2"+
		"\2\u0085\u0086\7\20\2\2\u0086\u0087\5\n\6\2\u0087\u008a\79\2\2\u0088\u008b"+
		"\5V,\2\u0089\u008b\5\\/\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\t\3\2\2\2\u008c\u008d\7@\2\2\u008d\13\3\2\2\2\u008e\u008f\7\23\2\2\u008f"+
		"\u009e\5(\25\2\u0090\u0092\5\34\17\2\u0091\u0090\3\2\2\2\u0091\u0092\3"+
		"\2\2\2\u0092\u0095\3\2\2\2\u0093\u0094\7:\2\2\u0094\u0096\5\"\22\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009f\3\2\2\2\u0097\u0099\5\""+
		"\22\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u009b\7:\2\2\u009b\u009d\5\34\17\2\u009c\u009a\3\2\2\2\u009c\u009d\3"+
		"\2\2\2\u009d\u009f\3\2\2\2\u009e\u0091\3\2\2\2\u009e\u0098\3\2\2\2\u009f"+
		"\r\3\2\2\2\u00a0\u00a1\7\27\2\2\u00a1\u00a2\7,\2\2\u00a2\u00a3\7-\2\2"+
		"\u00a3\u00a4\5.\30\2\u00a4\17\3\2\2\2\u00a5\u00a8\5T+\2\u00a6\u00a8\7"+
		"\30\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\7@\2\2\u00aa\u00ab\7,\2\2\u00ab\u00ac\5\22\n\2\u00ac\u00ad\7-\2"+
		"\2\u00ad\u00ae\5.\30\2\u00ae\21\3\2\2\2\u00af\u00b4\5\24\13\2\u00b0\u00b1"+
		"\7\67\2\2\u00b1\u00b3\5\24\13\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2"+
		"\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b7\u00af\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\23\3\2\2\2\u00b9"+
		"\u00ba\5T+\2\u00ba\u00bb\7@\2\2\u00bb\25\3\2\2\2\u00bc\u00bf\5\30\r\2"+
		"\u00bd\u00bf\5\32\16\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\27"+
		"\3\2\2\2\u00c0\u00c1\7\31\2\2\u00c1\u00c2\5(\25\2\u00c2\u00c3\5\n\6\2"+
		"\u00c3\u00c9\79\2\2\u00c4\u00ca\5`\61\2\u00c5\u00c6\7&\2\2\u00c6\u00ca"+
		"\7>\2\2\u00c7\u00c8\7\'\2\2\u00c8\u00ca\7>\2\2\u00c9\u00c4\3\2\2\2\u00c9"+
		"\u00c5\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\5."+
		"\30\2\u00cc\31\3\2\2\2\u00cd\u00ce\7\32\2\2\u00ce\u00cf\5@!\2\u00cf\u00d0"+
		"\t\2\2\2\u00d0\u00d1\5.\30\2\u00d1\33\3\2\2\2\u00d2\u00d3\7\21\2\2\u00d3"+
		"\u00d4\79\2\2\u00d4\u00d9\5\36\20\2\u00d5\u00d6\7\67\2\2\u00d6\u00d8\5"+
		"\36\20\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\35\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\5 \21"+
		"\2\u00dd\37\3\2\2\2\u00de\u00df\7@\2\2\u00df!\3\2\2\2\u00e0\u00e1\7\22"+
		"\2\2\u00e1\u00e2\79\2\2\u00e2\u00e7\5$\23\2\u00e3\u00e4\7\67\2\2\u00e4"+
		"\u00e6\5$\23\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e7\u00e8\3\2\2\2\u00e8#\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb"+
		"\5&\24\2\u00eb%\3\2\2\2\u00ec\u00ed\7@\2\2\u00ed\'\3\2\2\2\u00ee\u00ef"+
		"\7@\2\2\u00ef)\3\2\2\2\u00f0\u00f1\7?\2\2\u00f1+\3\2\2\2\u00f2\u00f3\7"+
		"@\2\2\u00f3-\3\2\2\2\u00f4\u00f5\7.\2\2\u00f5\u00f6\5\64\33\2\u00f6\u00f7"+
		"\7/\2\2\u00f7/\3\2\2\2\u00f8\u00fd\7*\2\2\u00f9\u00fe\5,\27\2\u00fa\u00fe"+
		"\7>\2\2\u00fb\u00fe\7;\2\2\u00fc\u00fe\7?\2\2\u00fd\u00f9\3\2\2\2\u00fd"+
		"\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\7\66\2\2\u0100\61\3\2\2\2\u0101\u0102"+
		"\7\25\2\2\u0102\u0103\7,\2\2\u0103\u0104\5H%\2\u0104\u0105\7-\2\2\u0105"+
		"\u0108\5.\30\2\u0106\u0107\7)\2\2\u0107\u0109\5.\30\2\u0108\u0106\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\63\3\2\2\2\u010a\u0115\5> \2\u010b\u0115"+
		"\5D#\2\u010c\u0115\5\62\32\2\u010d\u0115\5B\"\2\u010e\u010f\5:\36\2\u010f"+
		"\u0110\7\66\2\2\u0110\u0115\3\2\2\2\u0111\u0115\58\35\2\u0112\u0115\5"+
		"\60\31\2\u0113\u0115\5\66\34\2\u0114\u010a\3\2\2\2\u0114\u010b\3\2\2\2"+
		"\u0114\u010c\3\2\2\2\u0114\u010d\3\2\2\2\u0114\u010e\3\2\2\2\u0114\u0111"+
		"\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\65\3\2\2\2\u0118\u0116\3\2\2"+
		"\2\u0119\u011a\7+\2\2\u011a\u011b\7\66\2\2\u011b\67\3\2\2\2\u011c\u011d"+
		"\5T+\2\u011d\u011e\5,\27\2\u011e\u0121\7\60\2\2\u011f\u0122\t\3\2\2\u0120"+
		"\u0122\5F$\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122\u0129\3\2\2"+
		"\2\u0123\u0124\5(\25\2\u0124\u0125\5,\27\2\u0125\u0126\7\60\2\2\u0126"+
		"\u0127\5*\26\2\u0127\u0129\3\2\2\2\u0128\u011c\3\2\2\2\u0128\u0123\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\66\2\2\u012b9\3\2\2\2\u012c\u012d"+
		"\7@\2\2\u012d\u012e\7,\2\2\u012e\u012f\5<\37\2\u012f\u0130\7-\2\2\u0130"+
		"\u0140\3\2\2\2\u0131\u0132\7$\2\2\u0132\u0133\5(\25\2\u0133\u0134\5\n"+
		"\6\2\u0134\u0139\79\2\2\u0135\u013a\5`\61\2\u0136\u013a\7>\2\2\u0137\u013a"+
		"\7;\2\2\u0138\u013a\7?\2\2\u0139\u0135\3\2\2\2\u0139\u0136\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u0138\3\2\2\2\u013a\u0140\3\2\2\2\u013b\u013c\7%"+
		"\2\2\u013c\u013d\5(\25\2\u013d\u013e\5\n\6\2\u013e\u0140\3\2\2\2\u013f"+
		"\u012c\3\2\2\2\u013f\u0131\3\2\2\2\u013f\u013b\3\2\2\2\u0140;\3\2\2\2"+
		"\u0141\u0143\t\4\2\2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0148"+
		"\3\2\2\2\u0144\u0145\7\67\2\2\u0145\u0147\t\4\2\2\u0146\u0144\3\2\2\2"+
		"\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149=\3"+
		"\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c\7 \2\2\u014c\u014d\5@!\2\u014d"+
		"\u014e\t\5\2\2\u014e\u014f\7\66\2\2\u014f?\3\2\2\2\u0150\u0151\7>\2\2"+
		"\u0151A\3\2\2\2\u0152\u0153\7\26\2\2\u0153\u0154\7,\2\2\u0154\u0155\5"+
		"H%\2\u0155\u0156\7-\2\2\u0156\u0157\5.\30\2\u0157C\3\2\2\2\u0158\u0159"+
		"\7@\2\2\u0159\u015a\7\60\2\2\u015a\u015b\5F$\2\u015b\u015c\7\66\2\2\u015c"+
		"E\3\2\2\2\u015d\u015e\b$\1\2\u015e\u015f\7,\2\2\u015f\u0160\5F$\2\u0160"+
		"\u0161\7-\2\2\u0161\u0165\3\2\2\2\u0162\u0165\5R*\2\u0163\u0165\5:\36"+
		"\2\u0164\u015d\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0163\3\2\2\2\u0165\u016e"+
		"\3\2\2\2\u0166\u0167\f\7\2\2\u0167\u0168\t\6\2\2\u0168\u016d\5F$\b\u0169"+
		"\u016a\f\6\2\2\u016a\u016b\t\7\2\2\u016b\u016d\5F$\7\u016c\u0166\3\2\2"+
		"\2\u016c\u0169\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f"+
		"\3\2\2\2\u016fG\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\b%\1\2\u0172\u0179"+
		"\5J&\2\u0173\u0174\7,\2\2\u0174\u0175\5H%\2\u0175\u0176\7-\2\2\u0176\u0179"+
		"\3\2\2\2\u0177\u0179\t\b\2\2\u0178\u0171\3\2\2\2\u0178\u0173\3\2\2\2\u0178"+
		"\u0177\3\2\2\2\u0179\u0182\3\2\2\2\u017a\u017b\f\7\2\2\u017b\u017c\7\b"+
		"\2\2\u017c\u0181\5H%\b\u017d\u017e\f\6\2\2\u017e\u017f\7\t\2\2\u017f\u0181"+
		"\5H%\7\u0180\u017a\3\2\2\2\u0180\u017d\3\2\2\2\u0181\u0184\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183I\3\2\2\2\u0184\u0182\3\2\2\2"+
		"\u0185\u0186\5L\'\2\u0186\u0187\5P)\2\u0187\u0188\5L\'\2\u0188\u018e\3"+
		"\2\2\2\u0189\u018a\7,\2\2\u018a\u018b\5J&\2\u018b\u018c\7-\2\2\u018c\u018e"+
		"\3\2\2\2\u018d\u0185\3\2\2\2\u018d\u0189\3\2\2\2\u018eK\3\2\2\2\u018f"+
		"\u0192\5N(\2\u0190\u0192\5F$\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2"+
		"\u0192M\3\2\2\2\u0193\u0194\7<\2\2\u0194O\3\2\2\2\u0195\u0196\t\t\2\2"+
		"\u0196Q\3\2\2\2\u0197\u019d\7>\2\2\u0198\u019d\7;\2\2\u0199\u019d\7?\2"+
		"\2\u019a\u019d\7@\2\2\u019b\u019d\7(\2\2\u019c\u0197\3\2\2\2\u019c\u0198"+
		"\3\2\2\2\u019c\u0199\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019b\3\2\2\2\u019d"+
		"S\3\2\2\2\u019e\u019f\t\n\2\2\u019fU\3\2\2\2\u01a0\u01a1\5X-\2\u01a1\u01a2"+
		"\7\65\2\2\u01a2\u01a3\5Z.\2\u01a3W\3\2\2\2\u01a4\u01a7\7>\2\2\u01a5\u01a7"+
		"\7;\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7Y\3\2\2\2\u01a8\u01ab"+
		"\7>\2\2\u01a9\u01ab\7;\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01ab"+
		"[\3\2\2\2\u01ac\u01b1\5^\60\2\u01ad\u01ae\7\67\2\2\u01ae\u01b0\5^\60\2"+
		"\u01af\u01ad\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2"+
		"\3\2\2\2\u01b2]\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\5`\61\2\u01b5"+
		"\u01b6\7\60\2\2\u01b6\u01b7\5b\62\2\u01b7_\3\2\2\2\u01b8\u01b9\7@\2\2"+
		"\u01b9a\3\2\2\2\u01ba\u01be\7?\2\2\u01bb\u01be\7>\2\2\u01bc\u01be\7;\2"+
		"\2\u01bd\u01ba\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01bc\3\2\2\2\u01bec"+
		"\3\2\2\2,ioswy\u0081\u008a\u0091\u0095\u0098\u009c\u009e\u00a7\u00b4\u00b7"+
		"\u00be\u00c9\u00d9\u00e7\u00fd\u0108\u0114\u0116\u0121\u0128\u0139\u013f"+
		"\u0142\u0148\u0164\u016c\u016e\u0178\u0180\u0182\u018d\u0191\u019c\u01a6"+
		"\u01aa\u01b1\u01bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
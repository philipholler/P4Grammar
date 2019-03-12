// Generated from C:/Users/phili/IdeaProjects/P4Grammar/src\Pivot.g4 by ANTLR 4.7.2
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
		T__0=1, T__1=2, T__2=3, T__3=4, WhiteSpace=5, NewLine=6, LINE_COMMENT=7, 
		TRUE=8, FALSE=9, AND=10, OR=11, GT=12, GE=13, LT=14, LE=15, EQ=16, SIGNALKW=17, 
		INPUTKW=18, OUTPUTKW=19, DEVICE=20, DEFINEKW=21, IF=22, WHILE=23, INITFUNCKW=24, 
		VOID=25, WHEN=26, EVERY=27, PARANBEG=28, PARANEND=29, BLCKBEG=30, BLCKEND=31, 
		EQUALS=32, PLUS=33, MINUS=34, DIV=35, MULT=36, RANGESEP=37, END=38, LISTSEP=39, 
		QUOT=40, SINTEGER=41, ID=42, STRING=43, IP=44;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_define = 2, RULE_signal = 3, RULE_signalID = 4, 
		RULE_device = 5, RULE_inst = 6, RULE_init = 7, RULE_func = 8, RULE_event = 9, 
		RULE_atomEvent = 10, RULE_repeatEvent = 11, RULE_initReturnValue = 12, 
		RULE_inputs = 13, RULE_input = 14, RULE_outputs = 15, RULE_output = 16, 
		RULE_deviceID = 17, RULE_ip = 18, RULE_varID = 19, RULE_block = 20, RULE_ifstmt = 21, 
		RULE_stat = 22, RULE_whilestmt = 23, RULE_assignment = 24, RULE_expr = 25, 
		RULE_logical_expr = 26, RULE_comparison_expr = 27, RULE_comparison_operand = 28, 
		RULE_comp_operator = 29, RULE_atom = 30, RULE_range = 31, RULE_lowerBound = 32, 
		RULE_upperBound = 33, RULE_togglevalues = 34, RULE_togglevalue = 35, RULE_toggleID = 36, 
		RULE_toggleVal = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "define", "signal", "signalID", "device", "inst", 
			"init", "func", "event", "atomEvent", "repeatEvent", "initReturnValue", 
			"inputs", "input", "outputs", "output", "deviceID", "ip", "varID", "block", 
			"ifstmt", "stat", "whilestmt", "assignment", "expr", "logical_expr", 
			"comparison_expr", "comparison_operand", "comp_operator", "atom", "range", 
			"lowerBound", "upperBound", "togglevalues", "togglevalue", "toggleID", 
			"toggleVal"
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
			setState(76);
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
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINEKW) {
				{
				{
				setState(78);
				define();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(84);
				inst();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			init();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << WHEN))) != 0)) {
				{
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(91);
					func();
					}
					break;
				case T__3:
				case WHEN:
					{
					setState(92);
					event();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(97);
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
		public TerminalNode END() { return getToken(PivotParser.END, 0); }
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
			setState(98);
			match(DEFINEKW);
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIGNALKW:
				{
				setState(99);
				signal();
				}
				break;
			case DEVICE:
				{
				setState(100);
				device();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(103);
			match(END);
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
			setState(105);
			match(SIGNALKW);
			setState(106);
			signalID();
			setState(107);
			match(T__0);
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINTEGER:
				{
				setState(108);
				range();
				}
				break;
			case ID:
				{
				setState(109);
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
			setState(112);
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
			setState(114);
			match(DEVICE);
			setState(115);
			deviceID();
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				{
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INPUTKW) {
					{
					setState(116);
					inputs();
					}
				}

				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(119);
					match(T__1);
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OUTPUTKW) {
						{
						setState(120);
						outputs();
						}
					}

					}
				}

				}
				}
				break;
			case 2:
				{
				{
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTPUTKW) {
					{
					setState(125);
					outputs();
					}
				}

				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(128);
					match(T__1);
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==INPUTKW) {
						{
						setState(129);
						inputs();
						}
					}

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

	public static class InstContext extends ParserRuleContext {
		public DeviceIDContext deviceID() {
			return getRuleContext(DeviceIDContext.class,0);
		}
		public VarIDContext varID() {
			return getRuleContext(VarIDContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(PivotParser.EQUALS, 0); }
		public IpContext ip() {
			return getRuleContext(IpContext.class,0);
		}
		public TerminalNode END() { return getToken(PivotParser.END, 0); }
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			deviceID();
			setState(137);
			varID();
			setState(138);
			match(EQUALS);
			setState(139);
			ip();
			setState(140);
			match(END);
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
		public InitReturnValueContext initReturnValue() {
			return getRuleContext(InitReturnValueContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			initReturnValue();
			setState(143);
			match(INITFUNCKW);
			setState(144);
			match(PARANBEG);
			setState(145);
			match(PARANEND);
			setState(146);
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
		public TerminalNode END() { return getToken(PivotParser.END, 0); }
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
		enterRule(_localctx, 16, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__2);
			setState(149);
			match(END);
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
		enterRule(_localctx, 18, RULE_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(151);
				atomEvent();
				}
				break;
			case WHEN:
				{
				setState(152);
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
		enterRule(_localctx, 20, RULE_atomEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__3);
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
		public TerminalNode WHEN() { return getToken(PivotParser.WHEN, 0); }
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public ToggleIDContext toggleID() {
			return getRuleContext(ToggleIDContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 22, RULE_repeatEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(WHEN);
			setState(158);
			match(ID);
			setState(159);
			match(ID);
			setState(160);
			match(T__0);
			setState(161);
			toggleID();
			setState(162);
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

	public static class InitReturnValueContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(PivotParser.VOID, 0); }
		public InitReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initReturnValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterInitReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitInitReturnValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInitReturnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitReturnValueContext initReturnValue() throws RecognitionException {
		InitReturnValueContext _localctx = new InitReturnValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_initReturnValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(VOID);
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
			setState(166);
			match(INPUTKW);
			setState(167);
			match(T__0);
			setState(168);
			input();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(169);
				match(LISTSEP);
				setState(170);
				input();
				}
				}
				setState(175);
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
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
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
			setState(176);
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
		enterRule(_localctx, 30, RULE_outputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(OUTPUTKW);
			setState(179);
			match(T__0);
			setState(180);
			output();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(181);
				match(LISTSEP);
				setState(182);
				output();
				}
				}
				setState(187);
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
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
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
		enterRule(_localctx, 32, RULE_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		enterRule(_localctx, 34, RULE_deviceID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
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
		public TerminalNode IP() { return getToken(PivotParser.IP, 0); }
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
		enterRule(_localctx, 36, RULE_ip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(IP);
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
		enterRule(_localctx, 38, RULE_varID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
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
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
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
		enterRule(_localctx, 40, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(BLCKBEG);
			setState(197);
			stat();
			setState(198);
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

	public static class IfstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PivotParser.IF, 0); }
		public TerminalNode PARANBEG() { return getToken(PivotParser.PARANBEG, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode PARANEND() { return getToken(PivotParser.PARANEND, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
		enterRule(_localctx, 42, RULE_ifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(IF);
			setState(201);
			match(PARANBEG);
			setState(202);
			logical_expr(0);
			setState(203);
			match(PARANEND);
			setState(204);
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

	public static class StatContext extends ParserRuleContext {
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(206);
				assignment();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF) {
				{
				{
				setState(212);
				ifstmt();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHILE) {
				{
				{
				setState(218);
				whilestmt();
				}
				}
				setState(223);
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
		enterRule(_localctx, 46, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(WHILE);
			setState(225);
			match(PARANBEG);
			setState(226);
			logical_expr(0);
			setState(227);
			match(PARANEND);
			setState(228);
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
		public TerminalNode END() { return getToken(PivotParser.END, 0); }
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
		enterRule(_localctx, 48, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(ID);
			setState(231);
			match(EQUALS);
			setState(232);
			expr(0);
			setState(233);
			match(END);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARANBEG:
				{
				_localctx = new ParanexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(236);
				match(PARANBEG);
				setState(237);
				expr(0);
				setState(238);
				match(PARANEND);
				}
				break;
			case SINTEGER:
			case ID:
				{
				_localctx = new AtomexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(249);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MultiexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(244);
						_la = _input.LA(1);
						if ( !(_la==DIV || _la==MULT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new AddexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(247);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public final Logical_exprContext logical_expr() throws RecognitionException {
		return logical_expr(0);
	}

	private Logical_exprContext logical_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, _parentState);
		Logical_exprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_logical_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(255);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(PARANBEG);
				setState(257);
				logical_expr(0);
				setState(258);
				match(PARANEND);
				}
				break;
			case 3:
				{
				_localctx = new LogicalLiteralsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
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
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(263);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(264);
						match(AND);
						setState(265);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(266);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(267);
						match(OR);
						setState(268);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 54, RULE_comparison_expr);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ComparisonExpressionWithOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				comparison_operand();
				setState(275);
				comp_operator();
				setState(276);
				comparison_operand();
				}
				break;
			case 2:
				_localctx = new ComparisonExpressionParensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(PARANBEG);
				setState(279);
				comparison_expr();
				setState(280);
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
		enterRule(_localctx, 56, RULE_comparison_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			expr(0);
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
		enterRule(_localctx, 58, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ))) != 0)) ) {
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
		public TerminalNode ID() { return getToken(PivotParser.ID, 0); }
		public TerminalNode SINTEGER() { return getToken(PivotParser.SINTEGER, 0); }
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
		enterRule(_localctx, 60, RULE_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_la = _input.LA(1);
			if ( !(_la==SINTEGER || _la==ID) ) {
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
		enterRule(_localctx, 62, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			lowerBound();
			setState(291);
			match(RANGESEP);
			setState(292);
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
		public TerminalNode SINTEGER() { return getToken(PivotParser.SINTEGER, 0); }
		public LowerBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterLowerBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitLowerBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitLowerBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerBoundContext lowerBound() throws RecognitionException {
		LowerBoundContext _localctx = new LowerBoundContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_lowerBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(SINTEGER);
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
		public TerminalNode SINTEGER() { return getToken(PivotParser.SINTEGER, 0); }
		public UpperBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upperBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterUpperBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitUpperBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitUpperBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperBoundContext upperBound() throws RecognitionException {
		UpperBoundContext _localctx = new UpperBoundContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_upperBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(SINTEGER);
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
		enterRule(_localctx, 68, RULE_togglevalues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			togglevalue();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(299);
				match(LISTSEP);
				setState(300);
				togglevalue();
				}
				}
				setState(305);
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
		enterRule(_localctx, 70, RULE_togglevalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			toggleID();
			setState(307);
			match(EQUALS);
			setState(308);
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
		enterRule(_localctx, 72, RULE_toggleID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
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
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public TerminalNode SINTEGER() { return getToken(PivotParser.SINTEGER, 0); }
		public ToggleValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toggleVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).enterToggleVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PivotListener ) ((PivotListener)listener).exitToggleVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitToggleVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToggleValContext toggleVal() throws RecognitionException {
		ToggleValContext _localctx = new ToggleValContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_toggleVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_la = _input.LA(1);
			if ( !(_la==SINTEGER || _la==STRING) ) {
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
		case 25:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 26:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u013d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\7\3R\n\3\f\3\16"+
		"\3U\13\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\3\3\3\3\3\7\3`\n\3\f\3\16\3c\13"+
		"\3\3\4\3\4\3\4\5\4h\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5q\n\5\3\6\3\6\3"+
		"\7\3\7\3\7\5\7x\n\7\3\7\3\7\5\7|\n\7\5\7~\n\7\3\7\5\7\u0081\n\7\3\7\3"+
		"\7\5\7\u0085\n\7\5\7\u0087\n\7\5\7\u0089\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\5\13\u009c\n\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17\u00ae"+
		"\n\17\f\17\16\17\u00b1\13\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u00ba"+
		"\n\21\f\21\16\21\u00bd\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\7\30\u00d2\n\30"+
		"\f\30\16\30\u00d5\13\30\3\30\7\30\u00d8\n\30\f\30\16\30\u00db\13\30\3"+
		"\30\7\30\u00de\n\30\f\30\16\30\u00e1\13\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00f4"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u00fc\n\33\f\33\16\33\u00ff\13"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0108\n\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u0110\n\34\f\34\16\34\u0113\13\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u011d\n\35\3\36\3\36\3\37\3\37\3 \3 \3"+
		"!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\7$\u0130\n$\f$\16$\u0133\13$\3%\3%\3"+
		"%\3%\3&\3&\3\'\3\'\3\'\2\4\64\66(\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJL\2\b\3\2%&\3\2#$\3\2\n\13\3\2\16\22"+
		"\3\2+,\4\2++--\2\u0132\2N\3\2\2\2\4S\3\2\2\2\6d\3\2\2\2\bk\3\2\2\2\nr"+
		"\3\2\2\2\ft\3\2\2\2\16\u008a\3\2\2\2\20\u0090\3\2\2\2\22\u0096\3\2\2\2"+
		"\24\u009b\3\2\2\2\26\u009d\3\2\2\2\30\u009f\3\2\2\2\32\u00a6\3\2\2\2\34"+
		"\u00a8\3\2\2\2\36\u00b2\3\2\2\2 \u00b4\3\2\2\2\"\u00be\3\2\2\2$\u00c0"+
		"\3\2\2\2&\u00c2\3\2\2\2(\u00c4\3\2\2\2*\u00c6\3\2\2\2,\u00ca\3\2\2\2."+
		"\u00d3\3\2\2\2\60\u00e2\3\2\2\2\62\u00e8\3\2\2\2\64\u00f3\3\2\2\2\66\u0107"+
		"\3\2\2\28\u011c\3\2\2\2:\u011e\3\2\2\2<\u0120\3\2\2\2>\u0122\3\2\2\2@"+
		"\u0124\3\2\2\2B\u0128\3\2\2\2D\u012a\3\2\2\2F\u012c\3\2\2\2H\u0134\3\2"+
		"\2\2J\u0138\3\2\2\2L\u013a\3\2\2\2NO\5\4\3\2O\3\3\2\2\2PR\5\6\4\2QP\3"+
		"\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TY\3\2\2\2US\3\2\2\2VX\5\16\b\2WV"+
		"\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\a\5\20\t"+
		"\2]`\5\22\n\2^`\5\24\13\2_]\3\2\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3"+
		"\2\2\2b\5\3\2\2\2ca\3\2\2\2dg\7\27\2\2eh\5\b\5\2fh\5\f\7\2ge\3\2\2\2g"+
		"f\3\2\2\2hi\3\2\2\2ij\7(\2\2j\7\3\2\2\2kl\7\23\2\2lm\5\n\6\2mp\7\3\2\2"+
		"nq\5@!\2oq\5F$\2pn\3\2\2\2po\3\2\2\2q\t\3\2\2\2rs\7,\2\2s\13\3\2\2\2t"+
		"u\7\26\2\2u\u0088\5$\23\2vx\5\34\17\2wv\3\2\2\2wx\3\2\2\2x}\3\2\2\2y{"+
		"\7\4\2\2z|\5 \21\2{z\3\2\2\2{|\3\2\2\2|~\3\2\2\2}y\3\2\2\2}~\3\2\2\2~"+
		"\u0089\3\2\2\2\177\u0081\5 \21\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\u0086\3\2\2\2\u0082\u0084\7\4\2\2\u0083\u0085\5\34\17\2\u0084\u0083"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0082\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088w\3\2\2\2\u0088\u0080\3\2\2\2"+
		"\u0089\r\3\2\2\2\u008a\u008b\5$\23\2\u008b\u008c\5(\25\2\u008c\u008d\7"+
		"\"\2\2\u008d\u008e\5&\24\2\u008e\u008f\7(\2\2\u008f\17\3\2\2\2\u0090\u0091"+
		"\5\32\16\2\u0091\u0092\7\32\2\2\u0092\u0093\7\36\2\2\u0093\u0094\7\37"+
		"\2\2\u0094\u0095\5*\26\2\u0095\21\3\2\2\2\u0096\u0097\7\5\2\2\u0097\u0098"+
		"\7(\2\2\u0098\23\3\2\2\2\u0099\u009c\5\26\f\2\u009a\u009c\5\30\r\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\25\3\2\2\2\u009d\u009e\7\6\2"+
		"\2\u009e\27\3\2\2\2\u009f\u00a0\7\34\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2"+
		"\7,\2\2\u00a2\u00a3\7\3\2\2\u00a3\u00a4\5J&\2\u00a4\u00a5\5*\26\2\u00a5"+
		"\31\3\2\2\2\u00a6\u00a7\7\33\2\2\u00a7\33\3\2\2\2\u00a8\u00a9\7\24\2\2"+
		"\u00a9\u00aa\7\3\2\2\u00aa\u00af\5\36\20\2\u00ab\u00ac\7)\2\2\u00ac\u00ae"+
		"\5\36\20\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\35\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3"+
		"\7,\2\2\u00b3\37\3\2\2\2\u00b4\u00b5\7\25\2\2\u00b5\u00b6\7\3\2\2\u00b6"+
		"\u00bb\5\"\22\2\u00b7\u00b8\7)\2\2\u00b8\u00ba\5\"\22\2\u00b9\u00b7\3"+
		"\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"!\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7,\2\2\u00bf#\3\2\2\2\u00c0"+
		"\u00c1\7,\2\2\u00c1%\3\2\2\2\u00c2\u00c3\7.\2\2\u00c3\'\3\2\2\2\u00c4"+
		"\u00c5\7,\2\2\u00c5)\3\2\2\2\u00c6\u00c7\7 \2\2\u00c7\u00c8\5.\30\2\u00c8"+
		"\u00c9\7!\2\2\u00c9+\3\2\2\2\u00ca\u00cb\7\30\2\2\u00cb\u00cc\7\36\2\2"+
		"\u00cc\u00cd\5\66\34\2\u00cd\u00ce\7\37\2\2\u00ce\u00cf\5*\26\2\u00cf"+
		"-\3\2\2\2\u00d0\u00d2\5\62\32\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2"+
		"\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d9\3\2\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d6\u00d8\5,\27\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00df\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00dc\u00de\5\60\31\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0/\3\2\2\2\u00e1\u00df\3\2\2\2"+
		"\u00e2\u00e3\7\31\2\2\u00e3\u00e4\7\36\2\2\u00e4\u00e5\5\66\34\2\u00e5"+
		"\u00e6\7\37\2\2\u00e6\u00e7\5*\26\2\u00e7\61\3\2\2\2\u00e8\u00e9\7,\2"+
		"\2\u00e9\u00ea\7\"\2\2\u00ea\u00eb\5\64\33\2\u00eb\u00ec\7(\2\2\u00ec"+
		"\63\3\2\2\2\u00ed\u00ee\b\33\1\2\u00ee\u00ef\7\36\2\2\u00ef\u00f0\5\64"+
		"\33\2\u00f0\u00f1\7\37\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f4\5> \2\u00f3"+
		"\u00ed\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00fd\3\2\2\2\u00f5\u00f6\f\6"+
		"\2\2\u00f6\u00f7\t\2\2\2\u00f7\u00fc\5\64\33\7\u00f8\u00f9\f\5\2\2\u00f9"+
		"\u00fa\t\3\2\2\u00fa\u00fc\5\64\33\6\u00fb\u00f5\3\2\2\2\u00fb\u00f8\3"+
		"\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\65\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\b\34\1\2\u0101\u0108\58\35"+
		"\2\u0102\u0103\7\36\2\2\u0103\u0104\5\66\34\2\u0104\u0105\7\37\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0108\t\4\2\2\u0107\u0100\3\2\2\2\u0107\u0102\3\2"+
		"\2\2\u0107\u0106\3\2\2\2\u0108\u0111\3\2\2\2\u0109\u010a\f\7\2\2\u010a"+
		"\u010b\7\f\2\2\u010b\u0110\5\66\34\b\u010c\u010d\f\6\2\2\u010d\u010e\7"+
		"\r\2\2\u010e\u0110\5\66\34\7\u010f\u0109\3\2\2\2\u010f\u010c\3\2\2\2\u0110"+
		"\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\67\3\2\2"+
		"\2\u0113\u0111\3\2\2\2\u0114\u0115\5:\36\2\u0115\u0116\5<\37\2\u0116\u0117"+
		"\5:\36\2\u0117\u011d\3\2\2\2\u0118\u0119\7\36\2\2\u0119\u011a\58\35\2"+
		"\u011a\u011b\7\37\2\2\u011b\u011d\3\2\2\2\u011c\u0114\3\2\2\2\u011c\u0118"+
		"\3\2\2\2\u011d9\3\2\2\2\u011e\u011f\5\64\33\2\u011f;\3\2\2\2\u0120\u0121"+
		"\t\5\2\2\u0121=\3\2\2\2\u0122\u0123\t\6\2\2\u0123?\3\2\2\2\u0124\u0125"+
		"\5B\"\2\u0125\u0126\7\'\2\2\u0126\u0127\5D#\2\u0127A\3\2\2\2\u0128\u0129"+
		"\7+\2\2\u0129C\3\2\2\2\u012a\u012b\7+\2\2\u012bE\3\2\2\2\u012c\u0131\5"+
		"H%\2\u012d\u012e\7)\2\2\u012e\u0130\5H%\2\u012f\u012d\3\2\2\2\u0130\u0133"+
		"\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132G\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u0135\5J&\2\u0135\u0136\7\"\2\2\u0136\u0137\5L\'"+
		"\2\u0137I\3\2\2\2\u0138\u0139\7,\2\2\u0139K\3\2\2\2\u013a\u013b\t\7\2"+
		"\2\u013bM\3\2\2\2\35SY_agpw{}\u0080\u0084\u0086\u0088\u009b\u00af\u00bb"+
		"\u00d3\u00d9\u00df\u00f3\u00fb\u00fd\u0107\u010f\u0111\u011c\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from /home/alboteinsten/IdeaProjects/P4Grammar/Pivot.g4 by ANTLR 4.7.2
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
		SE=9, EQ=10, NE=11, SIGNAL=12, INPUT=13, OUTPUT=14, DEVICE=15, DEFINEKW=16, 
		IF=17, WHILE=18, INITFUNCKW=19, VOID=20, WHEN=21, EVERY=22, MS=23, SECONDS=24, 
		MINUTES=25, HOURS=26, DAYS=27, WEEKS=28, MONTHS=29, WAIT=30, STRINGKW=31, 
		INTEGERKW=32, FLOATKW=33, SET=34, GET=35, EXCEEDS=36, DECEEDS=37, NOW=38, 
		ELSE=39, RETURN=40, BREAK=41, STARTING=42, PRINT=43, PARANBEG=44, PARANEND=45, 
		BLCKBEG=46, BLCKEND=47, EQUALS=48, PLUS=49, MINUS=50, DIV=51, MULT=52, 
		RANGESEP=53, SEMCOL=54, LISTSEP=55, QUOT=56, COL=57, AMP=58, DATE=59, 
		DAY=60, DATEnoYEAR=61, FLOAT=62, TIME=63, INTEGER=64, STRING=65, ID=66, 
		SIGN=67;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_define = 2, RULE_signal = 3, RULE_enumerations = 4, 
		RULE_enumeration = 5, RULE_range = 6, RULE_lowerBound = 7, RULE_upperBound = 8, 
		RULE_device = 9, RULE_inputs = 10, RULE_outputs = 11, RULE_declDevice = 12, 
		RULE_init = 13, RULE_funcDecl = 14, RULE_fParams = 15, RULE_param = 16, 
		RULE_event = 17, RULE_atomEvent = 18, RULE_repeatEvent = 19, RULE_timeAndDate = 20, 
		RULE_timeFrame = 21, RULE_block = 22, RULE_stmts = 23, RULE_printStmt = 24, 
		RULE_waitStmt = 25, RULE_assignment = 26, RULE_ifstmt = 27, RULE_whilestmt = 28, 
		RULE_funcCall = 29, RULE_arguments = 30, RULE_declVar = 31, RULE_brk = 32, 
		RULE_rtn = 33, RULE_litVal = 34, RULE_expr = 35, RULE_logical_expr = 36, 
		RULE_comparison_expr = 37, RULE_comparison_operand = 38, RULE_comp_operator = 39, 
		RULE_atom = 40, RULE_varType = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "define", "signal", "enumerations", "enumeration", 
			"range", "lowerBound", "upperBound", "device", "inputs", "outputs", "declDevice", 
			"init", "funcDecl", "fParams", "param", "event", "atomEvent", "repeatEvent", 
			"timeAndDate", "timeFrame", "block", "stmts", "printStmt", "waitStmt", 
			"assignment", "ifstmt", "whilestmt", "funcCall", "arguments", "declVar", 
			"brk", "rtn", "litVal", "expr", "logical_expr", "comparison_expr", "comparison_operand", 
			"comp_operator", "atom", "varType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'&&'", "'||'", "'>'", "'>='", "'<'", "'<='", 
			"'=='", "'!='", "'Signal'", "'input'", "'output'", "'Device'", "'define'", 
			"'if'", "'while'", "'init'", "'void'", "'when'", "'every'", "'ms'", "'seconds'", 
			"'minutes'", "'hours'", "'days'", "'weeks'", "'months'", "'wait'", "'string'", 
			"'int'", "'float'", "'set'", "'get'", "'exceeds'", "'deceeds'", "'now'", 
			"'else'", "'return'", "'break'", "'starting'", "'print'", "'('", "')'", 
			"'{'", "'}'", "'='", "'+'", "'-'", "'/'", "'*'", "'..'", "';'", "','", 
			"'\"'", "':'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WhiteSpace", "NewLine", "LINE_COMMENT", "AND", "OR", "GT", "GE", 
			"ST", "SE", "EQ", "NE", "SIGNAL", "INPUT", "OUTPUT", "DEVICE", "DEFINEKW", 
			"IF", "WHILE", "INITFUNCKW", "VOID", "WHEN", "EVERY", "MS", "SECONDS", 
			"MINUTES", "HOURS", "DAYS", "WEEKS", "MONTHS", "WAIT", "STRINGKW", "INTEGERKW", 
			"FLOATKW", "SET", "GET", "EXCEEDS", "DECEEDS", "NOW", "ELSE", "RETURN", 
			"BREAK", "STARTING", "PRINT", "PARANBEG", "PARANEND", "BLCKBEG", "BLCKEND", 
			"EQUALS", "PLUS", "MINUS", "DIV", "MULT", "RANGESEP", "SEMCOL", "LISTSEP", 
			"QUOT", "COL", "AMP", "DATE", "DAY", "DATEnoYEAR", "FLOAT", "TIME", "INTEGER", 
			"STRING", "ID", "SIGN"
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
			setState(84);
			decls();
			setState(85);
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
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINEKW) {
				{
				{
				setState(87);
				((DeclsContext)_localctx).defs = define();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(95);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRINGKW:
					case INTEGERKW:
					case FLOATKW:
						{
						setState(93);
						((DeclsContext)_localctx).vars = declVar();
						}
						break;
					case ID:
						{
						setState(94);
						((DeclsContext)_localctx).devVars = declDevice();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITFUNCKW) {
				{
				setState(100);
				((DeclsContext)_localctx).inFunc = init();
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << WHEN) | (1L << EVERY) | (1L << STRINGKW) | (1L << INTEGERKW) | (1L << FLOATKW))) != 0)) {
				{
				setState(105);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VOID:
				case STRINGKW:
				case INTEGERKW:
				case FLOATKW:
					{
					setState(103);
					funcDecl();
					}
					break;
				case WHEN:
				case EVERY:
					{
					setState(104);
					event();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(109);
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
			setState(110);
			match(DEFINEKW);
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIGNAL:
				{
				setState(111);
				signal();
				}
				break;
			case DEVICE:
				{
				setState(112);
				device();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(115);
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
			setState(117);
			match(SIGNAL);
			setState(118);
			match(ID);
			setState(119);
			match(COL);
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INTEGER:
				{
				setState(120);
				range();
				}
				break;
			case ID:
				{
				setState(121);
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
			setState(124);
			enumeration();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(125);
				match(LISTSEP);
				setState(126);
				enumeration();
				}
				}
				setState(131);
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
			setState(132);
			match(ID);
			setState(133);
			match(EQUALS);
			setState(134);
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
			setState(136);
			lowerBound();
			setState(137);
			match(RANGESEP);
			setState(138);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntlwRange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatlwRangeContext extends LowerBoundContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatlwRangeContext(LowerBoundContext ctx) { copyFrom(ctx); }
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
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntlwRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatlwRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntupRange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatupRangeContext extends UpperBoundContext {
		public TerminalNode FLOAT() { return getToken(PivotParser.FLOAT, 0); }
		public FloatupRangeContext(UpperBoundContext ctx) { copyFrom(ctx); }
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
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntupRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatupRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
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
		public OutputsContext outputs() {
			return getRuleContext(OutputsContext.class,0);
		}
		public DeviceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_device; }
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
			setState(148);
			match(DEVICE);
			setState(149);
			match(ID);
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INPUT) {
					{
					setState(150);
					inputs();
					}
				}

				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTPUT) {
					{
					setState(153);
					outputs();
					}
				}

				}
				break;
			case 2:
				{
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTPUT) {
					{
					setState(156);
					outputs();
					}
				}

				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INPUT) {
					{
					setState(159);
					inputs();
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
		public AtomEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomEvent; }
	 
		public AtomEventContext() { }
		public void copyFrom(AtomEventContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InputWhenEventContext extends AtomEventContext {
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
		public InputWhenEventContext(AtomEventContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitInputWhenEvent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimeWhenEventContext extends AtomEventContext {
		public TerminalNode WHEN() { return getToken(PivotParser.WHEN, 0); }
		public TimeAndDateContext timeAndDate() {
			return getRuleContext(TimeAndDateContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TimeWhenEventContext(AtomEventContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTimeWhenEvent(this);
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
				_localctx = new InputWhenEventContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(WHEN);
				setState(223);
				((InputWhenEventContext)_localctx).deviceID = match(ID);
				setState(224);
				((InputWhenEventContext)_localctx).signalID = match(ID);
				setState(225);
				match(COL);
				setState(231);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(226);
					((InputWhenEventContext)_localctx).enumID = match(ID);
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
				_localctx = new TimeWhenEventContext(_localctx);
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
		public TerminalNode INTEGER() { return getToken(PivotParser.INTEGER, 0); }
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
				match(INTEGER);
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
				match(INTEGER);
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
		public TerminalNode DAY() { return getToken(PivotParser.DAY, 0); }
		public TerminalNode DATEnoYEAR() { return getToken(PivotParser.DATEnoYEAR, 0); }
		public TerminalNode DATE() { return getToken(PivotParser.DATE, 0); }
		public TimeAndDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeAndDate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitTimeAndDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeAndDateContext timeAndDate() throws RecognitionException {
		TimeAndDateContext _localctx = new TimeAndDateContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_timeAndDate);
		int _la;
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
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATE) | (1L << DAY) | (1L << DATEnoYEAR))) != 0)) ) {
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
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATE) | (1L << DAY) | (1L << DATEnoYEAR))) != 0)) ) {
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
		public List<PrintStmtContext> printStmt() {
			return getRuleContexts(PrintStmtContext.class);
		}
		public PrintStmtContext printStmt(int i) {
			return getRuleContext(PrintStmtContext.class,i);
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
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (IF - 17)) | (1L << (WHILE - 17)) | (1L << (WAIT - 17)) | (1L << (STRINGKW - 17)) | (1L << (INTEGERKW - 17)) | (1L << (FLOATKW - 17)) | (1L << (SET - 17)) | (1L << (GET - 17)) | (1L << (RETURN - 17)) | (1L << (BREAK - 17)) | (1L << (PRINT - 17)) | (1L << (ID - 17)))) != 0)) {
				{
				setState(277);
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
					printStmt();
					}
					break;
				case 7:
					{
					setState(274);
					declVar();
					}
					break;
				case 8:
					{
					setState(275);
					brk();
					}
					break;
				case 9:
					{
					setState(276);
					rtn();
					}
					break;
				}
				}
				setState(281);
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

	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(PivotParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(PivotParser.SEMCOL, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitPrintStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(PRINT);
			setState(283);
			expr(0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitWaitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitStmtContext waitStmt() throws RecognitionException {
		WaitStmtContext _localctx = new WaitStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_waitStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(WAIT);
			setState(287);
			expr(0);
			setState(288);
			timeFrame();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			((AssignmentContext)_localctx).varID = match(ID);
			setState(292);
			match(EQUALS);
			setState(293);
			expr(0);
			setState(294);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(IF);
			setState(297);
			match(PARANBEG);
			setState(298);
			logical_expr(0);
			setState(299);
			match(PARANEND);
			setState(300);
			((IfstmtContext)_localctx).blck = block();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(301);
				match(ELSE);
				setState(302);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(WHILE);
			setState(306);
			match(PARANBEG);
			setState(307);
			logical_expr(0);
			setState(308);
			match(PARANEND);
			setState(309);
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
		public TerminalNode INPUT() { return getToken(PivotParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(PivotParser.OUTPUT, 0); }
		public GetFunContext(FuncCallContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFunCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetFunContext extends FuncCallContext {
		public Token deviceID;
		public Token signalID;
		public ExprContext exprVal;
		public TerminalNode SET() { return getToken(PivotParser.SET, 0); }
		public TerminalNode COL() { return getToken(PivotParser.COL, 0); }
		public List<TerminalNode> ID() { return getTokens(PivotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PivotParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SetFunContext(FuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitSetFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_funcCall);
		int _la;
		try {
			setState(327);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new FunCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				((FunCallContext)_localctx).id = match(ID);
				setState(312);
				match(PARANBEG);
				setState(313);
				arguments();
				setState(314);
				match(PARANEND);
				}
				break;
			case SET:
				_localctx = new SetFunContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				match(SET);
				setState(317);
				((SetFunContext)_localctx).deviceID = match(ID);
				setState(318);
				((SetFunContext)_localctx).signalID = match(ID);
				setState(319);
				match(COL);
				setState(320);
				((SetFunContext)_localctx).exprVal = expr(0);
				}
				break;
			case GET:
				_localctx = new GetFunContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				match(GET);
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INPUT || _la==OUTPUT) {
					{
					setState(322);
					_la = _input.LA(1);
					if ( !(_la==INPUT || _la==OUTPUT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(325);
				((GetFunContext)_localctx).deviceID = match(ID);
				setState(326);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (SET - 34)) | (1L << (GET - 34)) | (1L << (NOW - 34)) | (1L << (PARANBEG - 34)) | (1L << (FLOAT - 34)) | (1L << (INTEGER - 34)) | (1L << (STRING - 34)) | (1L << (ID - 34)))) != 0)) {
				{
				setState(329);
				expr(0);
				}
			}

			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LISTSEP) {
				{
				{
				setState(332);
				match(LISTSEP);
				setState(333);
				expr(0);
				}
				}
				setState(338);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitDeclVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclVarContext declVar() throws RecognitionException {
		DeclVarContext _localctx = new DeclVarContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_declVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			varType();
			setState(340);
			match(ID);
			setState(341);
			match(EQUALS);
			setState(342);
			expr(0);
			setState(343);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitBrk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BrkContext brk() throws RecognitionException {
		BrkContext _localctx = new BrkContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_brk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(BREAK);
			setState(346);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitRtn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RtnContext rtn() throws RecognitionException {
		RtnContext _localctx = new RtnContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_rtn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(348);
			match(RETURN);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (SET - 34)) | (1L << (GET - 34)) | (1L << (NOW - 34)) | (1L << (PARANBEG - 34)) | (1L << (FLOAT - 34)) | (1L << (INTEGER - 34)) | (1L << (STRING - 34)) | (1L << (ID - 34)))) != 0)) {
				{
				setState(349);
				expr(0);
				}
			}

			setState(352);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValContext extends LitValContext {
		public TerminalNode STRING() { return getToken(PivotParser.STRING, 0); }
		public StringValContext(LitValContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitFloatVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitValContext litVal() throws RecognitionException {
		LitValContext _localctx = new LitValContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_litVal);
		try {
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(356);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				_localctx = new ParanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(360);
				match(PARANBEG);
				setState(361);
				expr(0);
				setState(362);
				match(PARANEND);
				}
				break;
			case 2:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364);
				atom();
				}
				break;
			case 3:
				{
				_localctx = new FunCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(365);
				funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(374);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new MultiExprContext(new ExprContext(_parentctx, _parentState));
						((MultiExprContext)_localctx).leftChild = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(368);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(369);
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
						setState(370);
						((MultiExprContext)_localctx).rightChild = expr(6);
						}
						break;
					case 2:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						((PlusExprContext)_localctx).leftChild = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(371);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(372);
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
						setState(373);
						((PlusExprContext)_localctx).rightChild = expr(5);
						}
						break;
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComparisonExpression(this);
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
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_logical_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(380);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(381);
				match(PARANBEG);
				setState(382);
				logical_expr(0);
				setState(383);
				match(PARANEND);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(395);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(393);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						((LogicalExpressionAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(387);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(388);
						match(AND);
						setState(389);
						((LogicalExpressionAndContext)_localctx).right = logical_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						((LogicalExpressionOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(390);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(391);
						match(OR);
						setState(392);
						((LogicalExpressionOrContext)_localctx).right = logical_expr(4);
						}
						break;
					}
					} 
				}
				setState(397);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComparisonExpressionParens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_exprContext comparison_expr() throws RecognitionException {
		Comparison_exprContext _localctx = new Comparison_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_comparison_expr);
		try {
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new ComparisonExpressionWithOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				((ComparisonExpressionWithOperatorContext)_localctx).left = comparison_operand();
				setState(399);
				((ComparisonExpressionWithOperatorContext)_localctx).op = comp_operator();
				setState(400);
				((ComparisonExpressionWithOperatorContext)_localctx).right = comparison_operand();
				}
				break;
			case 2:
				_localctx = new ComparisonExpressionParensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				match(PARANBEG);
				setState(403);
				comparison_expr();
				setState(404);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitComOperandExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompOperandTimeContext extends Comparison_operandContext {
		public TerminalNode TIME() { return getToken(PivotParser.TIME, 0); }
		public CompOperandTimeContext(Comparison_operandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitCompOperandTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_operandContext comparison_operand() throws RecognitionException {
		Comparison_operandContext _localctx = new Comparison_operandContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_comparison_operand);
		int _la;
		try {
			setState(411);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME:
				_localctx = new CompOperandTimeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(TIME);
				}
				break;
			case DATE:
			case DATEnoYEAR:
				_localctx = new ComOperandDateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
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
				setState(410);
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
			setState(413);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_atom);
		try {
			setState(418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INTEGER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(415);
				litVal();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(416);
				((AtomContext)_localctx).varID = match(ID);
				}
				break;
			case NOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(417);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PivotVisitor ) return ((PivotVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
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
		case 35:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 36:
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
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u01a9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\3\7\3[\n\3\f\3\16\3^\13\3\3\3\3\3\7\3b\n\3\f\3\16\3e\13\3"+
		"\3\3\5\3h\n\3\3\3\3\3\7\3l\n\3\f\3\16\3o\13\3\3\4\3\4\3\4\5\4t\n\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\5\5}\n\5\3\6\3\6\3\6\7\6\u0082\n\6\f\6\16\6\u0085"+
		"\13\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\5\t\u0091\n\t\3\n\3\n\5"+
		"\n\u0095\n\n\3\13\3\13\3\13\5\13\u009a\n\13\3\13\5\13\u009d\n\13\3\13"+
		"\5\13\u00a0\n\13\3\13\5\13\u00a3\n\13\5\13\u00a5\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\7\f\u00ac\n\f\f\f\16\f\u00af\13\f\3\r\3\r\3\r\3\r\3\r\7\r\u00b6\n"+
		"\r\f\r\16\r\u00b9\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\5\20\u00c8\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\7\21\u00d3\n\21\f\21\16\21\u00d6\13\21\5\21\u00d8\n\21\3\22"+
		"\3\22\3\22\3\23\3\23\5\23\u00df\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00ea\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f1\n\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00ff"+
		"\n\25\3\26\3\26\3\26\3\26\5\26\u0105\n\26\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0118\n\31"+
		"\f\31\16\31\u011b\13\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0132"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0146\n\37\3\37\3\37\5\37\u014a\n\37\3"+
		" \5 \u014d\n \3 \3 \7 \u0151\n \f \16 \u0154\13 \3!\3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3#\3#\5#\u0161\n#\3#\3#\3$\3$\3$\5$\u0168\n$\3%\3%\3%\3%\3%\3"+
		"%\3%\5%\u0171\n%\3%\3%\3%\3%\3%\3%\7%\u0179\n%\f%\16%\u017c\13%\3&\3&"+
		"\3&\3&\3&\3&\5&\u0184\n&\3&\3&\3&\3&\3&\3&\7&\u018c\n&\f&\16&\u018f\13"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0199\n\'\3(\3(\3(\5(\u019e\n(\3"+
		")\3)\3*\3*\3*\5*\u01a5\n*\3+\3+\3+\2\4HJ,\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\n\3\2=?\3\2\31\37\3\2"+
		"\17\20\3\2\65\66\3\2\63\64\4\2==??\3\2\b\r\3\2!#\2\u01b8\2V\3\2\2\2\4"+
		"\\\3\2\2\2\6p\3\2\2\2\bw\3\2\2\2\n~\3\2\2\2\f\u0086\3\2\2\2\16\u008a\3"+
		"\2\2\2\20\u0090\3\2\2\2\22\u0094\3\2\2\2\24\u0096\3\2\2\2\26\u00a6\3\2"+
		"\2\2\30\u00b0\3\2\2\2\32\u00ba\3\2\2\2\34\u00c0\3\2\2\2\36\u00c7\3\2\2"+
		"\2 \u00d7\3\2\2\2\"\u00d9\3\2\2\2$\u00de\3\2\2\2&\u00f0\3\2\2\2(\u00fe"+
		"\3\2\2\2*\u0104\3\2\2\2,\u0106\3\2\2\2.\u0108\3\2\2\2\60\u0119\3\2\2\2"+
		"\62\u011c\3\2\2\2\64\u0120\3\2\2\2\66\u0125\3\2\2\28\u012a\3\2\2\2:\u0133"+
		"\3\2\2\2<\u0149\3\2\2\2>\u014c\3\2\2\2@\u0155\3\2\2\2B\u015b\3\2\2\2D"+
		"\u015e\3\2\2\2F\u0167\3\2\2\2H\u0170\3\2\2\2J\u0183\3\2\2\2L\u0198\3\2"+
		"\2\2N\u019d\3\2\2\2P\u019f\3\2\2\2R\u01a4\3\2\2\2T\u01a6\3\2\2\2VW\5\4"+
		"\3\2WX\7\2\2\3X\3\3\2\2\2Y[\5\6\4\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]"+
		"\3\2\2\2]c\3\2\2\2^\\\3\2\2\2_b\5@!\2`b\5\32\16\2a_\3\2\2\2a`\3\2\2\2"+
		"be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2fh\5\34\17\2gf\3\2\2"+
		"\2gh\3\2\2\2hm\3\2\2\2il\5\36\20\2jl\5$\23\2ki\3\2\2\2kj\3\2\2\2lo\3\2"+
		"\2\2mk\3\2\2\2mn\3\2\2\2n\5\3\2\2\2om\3\2\2\2ps\7\22\2\2qt\5\b\5\2rt\5"+
		"\24\13\2sq\3\2\2\2sr\3\2\2\2tu\3\2\2\2uv\78\2\2v\7\3\2\2\2wx\7\16\2\2"+
		"xy\7D\2\2y|\7;\2\2z}\5\16\b\2{}\5\n\6\2|z\3\2\2\2|{\3\2\2\2}\t\3\2\2\2"+
		"~\u0083\5\f\7\2\177\u0080\79\2\2\u0080\u0082\5\f\7\2\u0081\177\3\2\2\2"+
		"\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\13"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7D\2\2\u0087\u0088\7\62\2\2\u0088"+
		"\u0089\5F$\2\u0089\r\3\2\2\2\u008a\u008b\5\20\t\2\u008b\u008c\7\67\2\2"+
		"\u008c\u008d\5\22\n\2\u008d\17\3\2\2\2\u008e\u0091\7B\2\2\u008f\u0091"+
		"\7@\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\21\3\2\2\2\u0092"+
		"\u0095\7B\2\2\u0093\u0095\7@\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2"+
		"\2\u0095\23\3\2\2\2\u0096\u0097\7\21\2\2\u0097\u00a4\7D\2\2\u0098\u009a"+
		"\5\26\f\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2"+
		"\u009b\u009d\5\30\r\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a5"+
		"\3\2\2\2\u009e\u00a0\5\30\r\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2"+
		"\u00a0\u00a2\3\2\2\2\u00a1\u00a3\5\26\f\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u0099\3\2\2\2\u00a4\u009f\3\2\2\2\u00a5"+
		"\25\3\2\2\2\u00a6\u00a7\7\17\2\2\u00a7\u00a8\7;\2\2\u00a8\u00ad\7D\2\2"+
		"\u00a9\u00aa\79\2\2\u00aa\u00ac\7D\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00af"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\27\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b1\7\20\2\2\u00b1\u00b2\7;\2\2\u00b2\u00b7\7D"+
		"\2\2\u00b3\u00b4\79\2\2\u00b4\u00b6\7D\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\31\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\7D\2\2\u00bb\u00bc\7D\2\2\u00bc\u00bd\7\62"+
		"\2\2\u00bd\u00be\7C\2\2\u00be\u00bf\78\2\2\u00bf\33\3\2\2\2\u00c0\u00c1"+
		"\7\25\2\2\u00c1\u00c2\7.\2\2\u00c2\u00c3\7/\2\2\u00c3\u00c4\5.\30\2\u00c4"+
		"\35\3\2\2\2\u00c5\u00c8\5T+\2\u00c6\u00c8\7\26\2\2\u00c7\u00c5\3\2\2\2"+
		"\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7D\2\2\u00ca\u00cb"+
		"\7.\2\2\u00cb\u00cc\5 \21\2\u00cc\u00cd\7/\2\2\u00cd\u00ce\5.\30\2\u00ce"+
		"\37\3\2\2\2\u00cf\u00d4\5\"\22\2\u00d0\u00d1\79\2\2\u00d1\u00d3\5\"\22"+
		"\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8!\3\2\2\2\u00d9\u00da\5T+\2\u00da\u00db\7D\2\2\u00db"+
		"#\3\2\2\2\u00dc\u00df\5&\24\2\u00dd\u00df\5(\25\2\u00de\u00dc\3\2\2\2"+
		"\u00de\u00dd\3\2\2\2\u00df%\3\2\2\2\u00e0\u00e1\7\27\2\2\u00e1\u00e2\7"+
		"D\2\2\u00e2\u00e3\7D\2\2\u00e3\u00e9\7;\2\2\u00e4\u00ea\7D\2\2\u00e5\u00e6"+
		"\7&\2\2\u00e6\u00ea\5H%\2\u00e7\u00e8\7\'\2\2\u00e8\u00ea\5H%\2\u00e9"+
		"\u00e4\3\2\2\2\u00e9\u00e5\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00f1\5.\30\2\u00ec\u00ed\7\27\2\2\u00ed\u00ee\5*\26\2\u00ee"+
		"\u00ef\5.\30\2\u00ef\u00f1\3\2\2\2\u00f0\u00e0\3\2\2\2\u00f0\u00ec\3\2"+
		"\2\2\u00f1\'\3\2\2\2\u00f2\u00f3\7\30\2\2\u00f3\u00f4\7B\2\2\u00f4\u00f5"+
		"\5,\27\2\u00f5\u00f6\5.\30\2\u00f6\u00ff\3\2\2\2\u00f7\u00f8\7\30\2\2"+
		"\u00f8\u00f9\7B\2\2\u00f9\u00fa\5,\27\2\u00fa\u00fb\7,\2\2\u00fb\u00fc"+
		"\5*\26\2\u00fc\u00fd\5.\30\2\u00fd\u00ff\3\2\2\2\u00fe\u00f2\3\2\2\2\u00fe"+
		"\u00f7\3\2\2\2\u00ff)\3\2\2\2\u0100\u0101\7A\2\2\u0101\u0105\t\2\2\2\u0102"+
		"\u0105\7A\2\2\u0103\u0105\t\2\2\2\u0104\u0100\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0104\u0103\3\2\2\2\u0105+\3\2\2\2\u0106\u0107\t\3\2\2\u0107-\3\2"+
		"\2\2\u0108\u0109\7\60\2\2\u0109\u010a\5\60\31\2\u010a\u010b\7\61\2\2\u010b"+
		"/\3\2\2\2\u010c\u0118\5\64\33\2\u010d\u0118\5\66\34\2\u010e\u0118\58\35"+
		"\2\u010f\u0118\5:\36\2\u0110\u0111\5<\37\2\u0111\u0112\78\2\2\u0112\u0118"+
		"\3\2\2\2\u0113\u0118\5\62\32\2\u0114\u0118\5@!\2\u0115\u0118\5B\"\2\u0116"+
		"\u0118\5D#\2\u0117\u010c\3\2\2\2\u0117\u010d\3\2\2\2\u0117\u010e\3\2\2"+
		"\2\u0117\u010f\3\2\2\2\u0117\u0110\3\2\2\2\u0117\u0113\3\2\2\2\u0117\u0114"+
		"\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\61\3\2\2\2\u011b\u0119\3\2\2"+
		"\2\u011c\u011d\7-\2\2\u011d\u011e\5H%\2\u011e\u011f\78\2\2\u011f\63\3"+
		"\2\2\2\u0120\u0121\7 \2\2\u0121\u0122\5H%\2\u0122\u0123\5,\27\2\u0123"+
		"\u0124\78\2\2\u0124\65\3\2\2\2\u0125\u0126\7D\2\2\u0126\u0127\7\62\2\2"+
		"\u0127\u0128\5H%\2\u0128\u0129\78\2\2\u0129\67\3\2\2\2\u012a\u012b\7\23"+
		"\2\2\u012b\u012c\7.\2\2\u012c\u012d\5J&\2\u012d\u012e\7/\2\2\u012e\u0131"+
		"\5.\30\2\u012f\u0130\7)\2\2\u0130\u0132\5.\30\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u01329\3\2\2\2\u0133\u0134\7\24\2\2\u0134\u0135\7.\2\2"+
		"\u0135\u0136\5J&\2\u0136\u0137\7/\2\2\u0137\u0138\5.\30\2\u0138;\3\2\2"+
		"\2\u0139\u013a\7D\2\2\u013a\u013b\7.\2\2\u013b\u013c\5> \2\u013c\u013d"+
		"\7/\2\2\u013d\u014a\3\2\2\2\u013e\u013f\7$\2\2\u013f\u0140\7D\2\2\u0140"+
		"\u0141\7D\2\2\u0141\u0142\7;\2\2\u0142\u014a\5H%\2\u0143\u0145\7%\2\2"+
		"\u0144\u0146\t\4\2\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0147\u0148\7D\2\2\u0148\u014a\7D\2\2\u0149\u0139\3\2\2\2\u0149"+
		"\u013e\3\2\2\2\u0149\u0143\3\2\2\2\u014a=\3\2\2\2\u014b\u014d\5H%\2\u014c"+
		"\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0152\3\2\2\2\u014e\u014f\79"+
		"\2\2\u014f\u0151\5H%\2\u0150\u014e\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153?\3\2\2\2\u0154\u0152\3\2\2\2\u0155"+
		"\u0156\5T+\2\u0156\u0157\7D\2\2\u0157\u0158\7\62\2\2\u0158\u0159\5H%\2"+
		"\u0159\u015a\78\2\2\u015aA\3\2\2\2\u015b\u015c\7+\2\2\u015c\u015d\78\2"+
		"\2\u015dC\3\2\2\2\u015e\u0160\7*\2\2\u015f\u0161\5H%\2\u0160\u015f\3\2"+
		"\2\2\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\78\2\2\u0163"+
		"E\3\2\2\2\u0164\u0168\7B\2\2\u0165\u0168\7@\2\2\u0166\u0168\7C\2\2\u0167"+
		"\u0164\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168G\3\2\2\2"+
		"\u0169\u016a\b%\1\2\u016a\u016b\7.\2\2\u016b\u016c\5H%\2\u016c\u016d\7"+
		"/\2\2\u016d\u0171\3\2\2\2\u016e\u0171\5R*\2\u016f\u0171\5<\37\2\u0170"+
		"\u0169\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171\u017a\3\2"+
		"\2\2\u0172\u0173\f\7\2\2\u0173\u0174\t\5\2\2\u0174\u0179\5H%\b\u0175\u0176"+
		"\f\6\2\2\u0176\u0177\t\6\2\2\u0177\u0179\5H%\7\u0178\u0172\3\2\2\2\u0178"+
		"\u0175\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2"+
		"\2\2\u017bI\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\b&\1\2\u017e\u0184"+
		"\5L\'\2\u017f\u0180\7.\2\2\u0180\u0181\5J&\2\u0181\u0182\7/\2\2\u0182"+
		"\u0184\3\2\2\2\u0183\u017d\3\2\2\2\u0183\u017f\3\2\2\2\u0184\u018d\3\2"+
		"\2\2\u0185\u0186\f\6\2\2\u0186\u0187\7\6\2\2\u0187\u018c\5J&\7\u0188\u0189"+
		"\f\5\2\2\u0189\u018a\7\7\2\2\u018a\u018c\5J&\6\u018b\u0185\3\2\2\2\u018b"+
		"\u0188\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2"+
		"\2\2\u018eK\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191\5N(\2\u0191\u0192"+
		"\5P)\2\u0192\u0193\5N(\2\u0193\u0199\3\2\2\2\u0194\u0195\7.\2\2\u0195"+
		"\u0196\5L\'\2\u0196\u0197\7/\2\2\u0197\u0199\3\2\2\2\u0198\u0190\3\2\2"+
		"\2\u0198\u0194\3\2\2\2\u0199M\3\2\2\2\u019a\u019e\7A\2\2\u019b\u019e\t"+
		"\7\2\2\u019c\u019e\5H%\2\u019d\u019a\3\2\2\2\u019d\u019b\3\2\2\2\u019d"+
		"\u019c\3\2\2\2\u019eO\3\2\2\2\u019f\u01a0\t\b\2\2\u01a0Q\3\2\2\2\u01a1"+
		"\u01a5\5F$\2\u01a2\u01a5\7D\2\2\u01a3\u01a5\7(\2\2\u01a4\u01a1\3\2\2\2"+
		"\u01a4\u01a2\3\2\2\2\u01a4\u01a3\3\2\2\2\u01a5S\3\2\2\2\u01a6\u01a7\t"+
		"\t\2\2\u01a7U\3\2\2\2.\\acgkms|\u0083\u0090\u0094\u0099\u009c\u009f\u00a2"+
		"\u00a4\u00ad\u00b7\u00c7\u00d4\u00d7\u00de\u00e9\u00f0\u00fe\u0104\u0117"+
		"\u0119\u0131\u0145\u0149\u014c\u0152\u0160\u0167\u0170\u0178\u017a\u0183"+
		"\u018b\u018d\u0198\u019d\u01a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
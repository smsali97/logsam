// Generated from C:/Users/smsal/IdeaProjects/logsam/src\Logsam.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogsamLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, WS=3, Fwd=4, Bwd=5, Right=6, Left=7, Clean=8, Clear=9, 
		Int=10, Shape=11, Loop=12, Relops=13, Logops=14, Con_if=15, Con_elseif=16, 
		Con_else=17, Round_brack=18, Curly_brack=19, Variable=20, MUL=21, DIV=22, 
		ADD=23, SUB=24, Assig=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "WS", "Fwd", "Bwd", "Right", "Left", "Clean", "Clear", 
			"Int", "Shape", "Loop", "Relops", "Logops", "Con_if", "Con_elseif", "Con_else", 
			"Round_brack", "Curly_brack", "Variable", "MUL", "DIV", "ADD", "SUB", 
			"Assig"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, null, null, null, "'Clean'", null, null, 
			null, "'while'", null, null, "'if'", "'elsif'", "'else'", null, null, 
			null, "'*'", "'/'", "'+'", "'-'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "WS", "Fwd", "Bwd", "Right", "Left", "Clean", "Clear", 
			"Int", "Shape", "Loop", "Relops", "Logops", "Con_if", "Con_elseif", "Con_else", 
			"Round_brack", "Curly_brack", "Variable", "MUL", "DIV", "ADD", "SUB", 
			"Assig"
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


	public LogsamLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Logsam.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00d8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\6\4;\n\4\r\4\16\4<\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bc\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\nx\n\n\3\13\6\13{\n\13\r\13\16\13|\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0095"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00a6\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b0"+
		"\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\6\25\u00c5\n\25\r\25\16\25\u00c6\3\25\7"+
		"\25\u00ca\n\25\f\25\16\25\u00cd\13\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\3\2\7\5\2\13\f\17\17\"\"\3\2\62;\4\2>>@@\4\2}}\177\177\5\2C\\a"+
		"ac|\2\u00e8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\7:\3\2"+
		"\2\2\tI\3\2\2\2\13Q\3\2\2\2\rZ\3\2\2\2\17b\3\2\2\2\21d\3\2\2\2\23w\3\2"+
		"\2\2\25z\3\2\2\2\27\u0094\3\2\2\2\31\u0096\3\2\2\2\33\u00a5\3\2\2\2\35"+
		"\u00af\3\2\2\2\37\u00b1\3\2\2\2!\u00b4\3\2\2\2#\u00ba\3\2\2\2%\u00bf\3"+
		"\2\2\2\'\u00c1\3\2\2\2)\u00c4\3\2\2\2+\u00ce\3\2\2\2-\u00d0\3\2\2\2/\u00d2"+
		"\3\2\2\2\61\u00d4\3\2\2\2\63\u00d6\3\2\2\2\65\66\7*\2\2\66\4\3\2\2\2\67"+
		"8\7+\2\28\6\3\2\2\29;\t\2\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2"+
		"=>\3\2\2\2>?\b\4\2\2?\b\3\2\2\2@A\7h\2\2AJ\7f\2\2BC\7H\2\2CD\7Q\2\2DE"+
		"\7T\2\2EF\7Y\2\2FG\7C\2\2GH\7T\2\2HJ\7F\2\2I@\3\2\2\2IB\3\2\2\2J\n\3\2"+
		"\2\2KL\7d\2\2LR\7m\2\2MN\7D\2\2NO\7C\2\2OP\7E\2\2PR\7M\2\2QK\3\2\2\2Q"+
		"M\3\2\2\2R\f\3\2\2\2ST\7t\2\2T[\7v\2\2UV\7T\2\2VW\7K\2\2WX\7I\2\2XY\7"+
		"J\2\2Y[\7V\2\2ZS\3\2\2\2ZU\3\2\2\2[\16\3\2\2\2\\]\7n\2\2]c\7v\2\2^_\7"+
		"N\2\2_`\7G\2\2`a\7H\2\2ac\7V\2\2b\\\3\2\2\2b^\3\2\2\2c\20\3\2\2\2de\7"+
		"E\2\2ef\7n\2\2fg\7g\2\2gh\7c\2\2hi\7p\2\2i\22\3\2\2\2jk\7e\2\2kx\7u\2"+
		"\2lm\7E\2\2mn\7N\2\2no\7G\2\2op\7C\2\2pq\7T\2\2qr\7U\2\2rs\7E\2\2st\7"+
		"T\2\2tu\7G\2\2uv\7G\2\2vx\7P\2\2wj\3\2\2\2wl\3\2\2\2x\24\3\2\2\2y{\t\3"+
		"\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\26\3\2\2\2~\177\7e\2\2\177"+
		"\u0080\7k\2\2\u0080\u0081\7t\2\2\u0081\u0082\7e\2\2\u0082\u0083\7n\2\2"+
		"\u0083\u0095\7g\2\2\u0084\u0085\7u\2\2\u0085\u0086\7s\2\2\u0086\u0087"+
		"\7w\2\2\u0087\u0088\7c\2\2\u0088\u0089\7t\2\2\u0089\u0095\7g\2\2\u008a"+
		"\u008b\7g\2\2\u008b\u008c\7s\2\2\u008c\u008d\7v\2\2\u008d\u008e\7t\2\2"+
		"\u008e\u008f\7k\2\2\u008f\u0090\7c\2\2\u0090\u0091\7p\2\2\u0091\u0092"+
		"\7i\2\2\u0092\u0093\7n\2\2\u0093\u0095\7g\2\2\u0094~\3\2\2\2\u0094\u0084"+
		"\3\2\2\2\u0094\u008a\3\2\2\2\u0095\30\3\2\2\2\u0096\u0097\7y\2\2\u0097"+
		"\u0098\7j\2\2\u0098\u0099\7k\2\2\u0099\u009a\7n\2\2\u009a\u009b\7g\2\2"+
		"\u009b\32\3\2\2\2\u009c\u00a6\t\4\2\2\u009d\u009e\7>\2\2\u009e\u00a6\7"+
		"?\2\2\u009f\u00a0\7@\2\2\u00a0\u00a6\7?\2\2\u00a1\u00a2\7?\2\2\u00a2\u00a6"+
		"\7?\2\2\u00a3\u00a4\7#\2\2\u00a4\u00a6\7?\2\2\u00a5\u009c\3\2\2\2\u00a5"+
		"\u009d\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\7C\2\2\u00a8\u00a9\7P\2\2\u00a9\u00b0"+
		"\7F\2\2\u00aa\u00ab\7Q\2\2\u00ab\u00b0\7T\2\2\u00ac\u00ad\7P\2\2\u00ad"+
		"\u00ae\7Q\2\2\u00ae\u00b0\7V\2\2\u00af\u00a7\3\2\2\2\u00af\u00aa\3\2\2"+
		"\2\u00af\u00ac\3\2\2\2\u00b0\36\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3"+
		"\7h\2\2\u00b3 \3\2\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7"+
		"\7u\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7h\2\2\u00b9\"\3\2\2\2\u00ba\u00bb"+
		"\7g\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7u\2\2\u00bd\u00be\7g\2\2\u00be"+
		"$\3\2\2\2\u00bf\u00c0\4*+\2\u00c0&\3\2\2\2\u00c1\u00c2\t\5\2\2\u00c2("+
		"\3\2\2\2\u00c3\u00c5\t\6\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00cb\3\2\2\2\u00c8\u00ca\t\3"+
		"\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc*\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7,\2\2\u00cf"+
		",\3\2\2\2\u00d0\u00d1\7\61\2\2\u00d1.\3\2\2\2\u00d2\u00d3\7-\2\2\u00d3"+
		"\60\3\2\2\2\u00d4\u00d5\7/\2\2\u00d5\62\3\2\2\2\u00d6\u00d7\7?\2\2\u00d7"+
		"\64\3\2\2\2\17\2<IQZbw|\u0094\u00a5\u00af\u00c6\u00cb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
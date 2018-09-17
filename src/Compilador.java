/* Generated By:JavaCC: Do not edit this line. Compilador.java */
import java.io.*;
public class Compilador implements CompiladorConstants {
   public static void main(String args[])  throws ParseException
   {
      Compilador compilador = null;
      try
      {
         compilador = new Compilador(new FileInputStream("exemplo03.spc"));
         Compilador.inicio();
         System.out.println("Compilado com sucesso!");
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Erro: arquivo nao encontrado");
      }
      catch(TokenMgrError e)
      {
         System.out.println("Erro lexico\u005cn" + e.getMessage());
      }
   }

  static final public void inicio() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EXIBE:
      case LEITURA:
      case SE:
      case ENQUANTO:
      case PALAVRA:
      case VAR:
      case NUM:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      comando();
    }
    jj_consume_token(0);
  }

  static final public void expressao() throws ParseException {
    termo();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OU:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      jj_consume_token(OU);
      termo();
    }
  }

  static final public void termo() throws ParseException {
    termo1();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IGUAL:
      jj_consume_token(IGUAL);
      termo1();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
  }

  static final public void termo1() throws ParseException {
    termo2();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONCAT:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      jj_consume_token(CONCAT);
      termo2();
    }
  }

  static final public void termo2() throws ParseException {
    termo3();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SOMA:
      case SUB:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SOMA:
        jj_consume_token(SOMA);
        break;
      case SUB:
        jj_consume_token(SUB);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      termo3();
    }
  }

  static final public void termo3() throws ParseException {
    termo4();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
      case DIV:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
        jj_consume_token(MUL);
        break;
      case DIV:
        jj_consume_token(DIV);
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      termo4();
    }
  }

  static final public void termo4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AP:
      jj_consume_token(AP);
      expressao();
      jj_consume_token(FP);
      break;
    case NUM:
      jj_consume_token(NUM);
      break;
    case SOMA:
      jj_consume_token(SOMA);
      jj_consume_token(NUM);
      break;
    case SUB:
      jj_consume_token(SUB);
      jj_consume_token(NUM);
      break;
    case VAR:
      jj_consume_token(VAR);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void comando() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      atribuicao();
      break;
    case PALAVRA:
    case NUM:
      declaracao();
      break;
    case SE:
      se();
      break;
    case ENQUANTO:
      enquanto();
      break;
    case LEITURA:
      le();
      break;
    case EXIBE:
      exibe();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void atribuicao() throws ParseException {
    jj_consume_token(VAR);
    jj_consume_token(ATRIB);
    expressao();
    jj_consume_token(PV);
  }

  static final public void declaracao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      jj_consume_token(NUM);
      break;
    case PALAVRA:
      jj_consume_token(PALAVRA);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(VAR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIB:
      jj_consume_token(ATRIB);
      expressao();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_6;
      }
      jj_consume_token(VIRGULA);
      jj_consume_token(VAR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATRIB:
        jj_consume_token(ATRIB);
        expressao();
        break;
      default:
        jj_la1[13] = jj_gen;
        ;
      }
    }
    jj_consume_token(PV);
  }

  static final public void se() throws ParseException {
    jj_consume_token(SE);
    jj_consume_token(AP);
    expressao();
    jj_consume_token(FP);
    inicio();
    jj_consume_token(FIMSE);
  }

  static final public void enquanto() throws ParseException {
    jj_consume_token(ENQUANTO);
    jj_consume_token(AP);
    expressao();
    jj_consume_token(FP);
    inicio();
    jj_consume_token(FIMENQUANTO);
  }

  static final public void le() throws ParseException {
    jj_consume_token(LEITURA);
    jj_consume_token(VAR);
    expressao();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_7;
      }
      jj_consume_token(VIRGULA);
      jj_consume_token(VAR);
    }
    jj_consume_token(PV);
  }

  static final public void exibe() throws ParseException {
    jj_consume_token(EXIBE);
    expressao();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_8;
      }
      jj_consume_token(VIRGULA);
      expressao();
    }
    jj_consume_token(PV);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CompiladorTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2812e0,0x4000000,0x10000000,0x20000000,0xc00000,0xc00000,0x3000000,0x3000000,0xec4000,0x2812e0,0x201000,0x8000000,0x20000,0x8000000,0x20000,0x20000,};
   }

  /** Constructor with InputStream. */
  public Compilador(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Compilador(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CompiladorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Compilador(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CompiladorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Compilador(CompiladorTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CompiladorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[30];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 16; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 30; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}

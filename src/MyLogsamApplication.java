

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class MyLogsamApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Hi");
        InputStream is = args.length > 0 ? new FileInputStream(args[0]) : System.in;
        ANTLRInputStream input = new ANTLRInputStream(is);
        LogsamLexer lexer = new LogsamLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LogsamParser parser = new LogsamParser(tokens);
        ParseTree tree = parser.r();

        MyLogsamVisitor visitor = new MyLogsamVisitor();
        visitor.visit(tree);

        visitor.instructions.forEach(e -> System.out.println(Arrays.asList(e) + " "));
    }
}

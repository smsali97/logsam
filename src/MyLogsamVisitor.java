import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLogsamVisitor extends LogsamBaseVisitor<Integer> {

    static Map<String, Integer> symbolTable = new HashMap<>();
    public List<String[]> instructions = new ArrayList<>();
    public static int loopCount = 0;

    private int posX = 0;
    private int posY = 0;
    private int theta = 0;


    /**
     * ID '=' expr NEWLINE
     */

    public Integer visitLet(LogsamParser.LetContext ctx) {
        String id = ctx.Variable().getText(); // id is left-hand side of '='
        int value = visit(ctx.expr()); // compute value of expression on right
        symbolTable.put(id ,value);


        return 0;
    }

    @Override
    public Integer visitForloop(LogsamParser.ForloopContext ctx) {
        int c = ctx.getChildCount();
        String loopVar = "L" + ++loopCount;
        instructions.add(new String[]{"LOOP", loopVar});

        int start = Integer.parseInt(ctx.Int(0).getText());
        int finish = Integer.parseInt(ctx.Int(1).getText());
        symbolTable.put(loopVar, start);
        //        for (int i = start; i < finish - start + 1; i++) {
//            ctx.statement().forEach( s -> visit(s));
//        }

        ctx.statement().forEach( s -> visit(s));
        instructions.add(new String[]{"CJ", "LT " + finish, "goto " + loopVar});


        return 0;
    }

    @Override
    public Integer visitSwitchcolor(LogsamParser.SwitchcolorContext ctx) {
        instructions.add(new String[]{"SWITCH", ctx.color.getText()});
        return -1;
    }


    @Override
    public Integer visitClear(LogsamParser.ClearContext ctx) {
        instructions.add(new String[]{"CLEAR"});
        return -1;
    }

    @Override
    public Integer visitBool_expr(LogsamParser.Bool_exprContext ctx) {
        boolean left = visit(ctx.bool_compare(0)) == 1;
        boolean right = visit(ctx.bool_compare(1)) == 1;


        boolean b = false;
        switch ( ctx.logop.getText()) {
            case "AND":
                break;
            case "OR":
                b = left || right;
                break;
            default:
                break;
        }
        return b ? 1 : 0;

    }

    @Override
    public Integer visitBool_compare(LogsamParser.Bool_compareContext ctx) {
        int left = visit(ctx.bool_compare(0)); // get value of left subexpression
        int right = visit(ctx.bool_compare(1)); // get value of right subexpression
        boolean b = false;
        switch ( ctx.relop.getText() ) {
            case ">":
                b =  left > right;
                break;
            case ">=":
                b =  left >= right;
                break;
            case "<=":
                b =  left <= right;
                break;
            case "<":
                b =  left < right;
                break;
            case "==":
                b =  left == right;
                break;
            case "!=":
                b =  left != right;
                break;
            default:
                break;
        }
        return b ? 1 : 0;
    }

    public Integer visitInt(LogsamParser.IntContext ctx) {
        return Integer.valueOf(ctx.Int().getText());
    }

    /**
     * ID
     */
    public Integer visitVar(LogsamParser.VarContext ctx) {
        String id = ctx.Variable().getText();
        if (symbolTable.containsKey(id)) return symbolTable.get(id);
        System.err.println("Variable not found in Symbol Table.");
        System.exit(1);
        return 0;
    }



    /**
     * expr op=('*'|'/') expr
     */
    public Integer visitMulDiv(LogsamParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getText().equals("*")) return left * right;
        if (right == 0) System.err.println("Division by zero");
        return left / right; // must be DIV
    }

    /**
     * expr op=('+'|'-') expr
     */


    public Integer visitAddSub(LogsamParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getText().equals("+")) return left + right;
        return left - right; // must be DIV
    }


    public Integer visitMvmt(LogsamParser.MvmtContext ctx) {

        Integer value = visit(ctx.children.get(1));

        double cosTheta = 1, sinTheta = 1;
//        cosTheta = Math.cos(Math.toRadians(theta));
//        sinTheta = Math.sin(Math.toRadians(theta));


        if (ctx.start.getType() == LogsamParser.Fwd) {


            instructions.add(new String[]{"ADD", "POSY", String.valueOf(value * cosTheta)});
            instructions.add(new String[]{"ADD", "POSX", String.valueOf(value * sinTheta)});

        } else if (ctx.start.getType() == LogsamParser.Bwd) {
            instructions.add(new String[]{"SUB", "POSY", String.valueOf(value * cosTheta)});
            instructions.add(new String[]{"ADD", "POSX", String.valueOf(value * sinTheta)});
        } else if (ctx.start.getType() == LogsamParser.Right) {
            value = value % 360;
            theta += value;
            instructions.add(new String[]{"ADD", "THETA", String.valueOf(value)});
        } else if (ctx.start.getType() == LogsamParser.Left) {
            value = value % 360;
            theta += value;
            instructions.add(new String[]{"SUB", "THETA", String.valueOf(value)});
        }


        return value;
    }


    @Override
    public Integer visitIfstmt(LogsamParser.IfstmtContext ctx) {
        int result = visit(ctx.bool_expr());
        if (result == 1) {
            ctx.statement().forEach( e -> visit(e));
        }

        return 0;
    }
}



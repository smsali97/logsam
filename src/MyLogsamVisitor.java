import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLogsamVisitor extends LogsamBaseVisitor<Integer> {

    Map<String, Integer> symbolTable = new HashMap<>();
    public List<String[]> instructions = new ArrayList<>();

    private int posX = 0;
    private int posY = 0;
    private int theta = 0;


    /**
     * ID '=' expr NEWLINE
     */

    public Integer visitLet(LogsamParser.LetContext ctx) {
        String id = ctx.Variable().getText(); // id is left-hand side of '='
        int value = visit(ctx.expr()); // compute value of expression on right
        symbolTable.put(id, value); // store it in our memory
        return value;
    }

    @Override
    public Integer visitForloop(LogsamParser.ForloopContext ctx) {

        return super.visitForloop(ctx);
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
        return 0;
    }
    /**
     * expr op=('*'|'/') expr
     */
    public Integer visitMulDiv(LogsamParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getText().equals("*")) return left * right;
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


        if (ctx.start.getType() == LogsamParser.Fwd) {

            instructions.add(new String[]{"ADD", "POSY", String.valueOf(value * Math.cos(Math.toRadians(theta)))});
            instructions.add(new String[]{"ADD", "POSX", String.valueOf(value * Math.sin(Math.toRadians(theta)))});

        } else if (ctx.start.getType() == LogsamParser.Bwd) {
            instructions.add(new String[]{"SUB", "POSY", String.valueOf(value * Math.cos(Math.toRadians(theta)))});
            instructions.add(new String[]{"ADD", "POSX", String.valueOf(value * Math.sin(Math.toRadians(theta)))});
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


}



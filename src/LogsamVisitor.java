// Generated from C:/Users/smsal/IdeaProjects/logsam/src\Logsam.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LogsamParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LogsamVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LogsamParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(LogsamParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LogsamParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(LogsamParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(LogsamParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#whileloop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileloop(LogsamParser.WhileloopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#forloop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForloop(LogsamParser.ForloopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#bool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_expr(LogsamParser.Bool_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#bool_compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_compare(LogsamParser.Bool_compareContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#mvmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMvmt(LogsamParser.MvmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#clear}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClear(LogsamParser.ClearContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogsamParser#switchcolor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchcolor(LogsamParser.SwitchcolorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LogsamParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(LogsamParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LogsamParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(LogsamParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link LogsamParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(LogsamParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paran}
	 * labeled alternative in {@link LogsamParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParan(LogsamParser.ParanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LogsamParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LogsamParser.IntContext ctx);
}
package visitor;

import node.*;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.Statements.*;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.Expression.MultiExprNode;
import node.Statements.LogicalExpression.ComparisonExprNode;
import node.Statements.LogicalExpression.LogicalAndExprNode;
import node.Statements.LogicalExpression.LogicalLiteralNode;
import node.Statements.LogicalExpression.LogicalOrExprNode;
import node.Statements.Wait.WaitNode;
import node.TimeNodes.DateNode;
import node.TimeNodes.NowNode;
import node.TimeNodes.TimeNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Device.InputNode;
import node.define_nodes.Device.OutputNode;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Signal.EnumNode;
import node.define_nodes.Signal.RangeNode;

public class DeclarationVisitor extends ASTBaseVisitor<Void> {
    @Override
    public Void visit(Node node) {
        return super.visit(node);
    }

    @Override
    public Void visit(ProgramNode node) {
        return super.visit(node);
    }

    @Override
    public Void visitChildren(Node node) {
        return super.visitChildren(node);
    }

    @Override
    public Void visit(DefDeviceNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(InputNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(OutputNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(DefSignalNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EnumNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(RangeNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EventInputNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EventRangeInputNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EventEveryNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(FunctionNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(InputParamNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(FuncCallNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(GetFuncNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(SetFuncNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(FloatNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(IntegerNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(StringNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(AddExprNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(IDNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(MultiExprNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(ComparisonExprNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(LogicalAndExprNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(LogicalLiteralNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(LogicalOrExprNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(WaitNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(AssignmentNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(BreakNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(IfStmtNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(ReturnNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(WhileNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(DateNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(NowNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(TimeNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(BlockNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(DeclsNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(DevDeclNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(InitNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(VarDeclNode node) {
        return super.visit(node);
    }
}

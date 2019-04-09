package visitor;

import antlr.PivotParser;
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
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Device.InputNode;
import node.define_nodes.Device.OutputNode;
import node.define_nodes.Signal.EnumNode;
import node.define_nodes.Signal.RangeNode;

public abstract class ASTBaseVisitor<T>{
    // Must just call node.accept(this) in all implementations
    public T visit(Node node){
        return node.accept(this);
    }

    public T visit(ProgramNode node){
        return visitChildren(node);
    }

    public T visitChildren(Node node){
        for (Node n: node.getChildren()) {
            n.accept(this);
        }

        return null;
    }

    // Device nodes
    public T visit(DefDeviceNode node){
        return visitChildren(node);
    }
    public T visit(InputNode node){
        return visitChildren(node);
    }
    public T visit(OutputNode node){
        return visitChildren(node);
    }

    // Signal nodes
    public T visit(DefSignalNode node){
        return visitChildren(node);
    }
    public T visit(EnumNode node){
        return visitChildren(node);
    }
    public T visit(RangeNode node){
        return visitChildren(node);
    }

    // Events
    public T visit(EventInputNode node){
        return visitChildren(node);
    }
    public T visit(EventRangeInputNode node){
        return visitChildren(node);
    }
    public T visit(EventWhenTimeNode node){
        return visitChildren(node);
    }
    public T visit(EventEveryNode node){
        return visitChildren(node);
    }

    // Function
    public T visit(FunctionNode node){
        return visitChildren(node);
    }
    public T visit(InputParamNode node){
        return visitChildren(node);
    }

    /**
     * Statements
     */
    //Expression nodes
        // Function call nodes
        public T visit(FuncCallNode node){
            return visitChildren(node);
        }
        public T visit(GetFuncNode node){
            return visitChildren(node);
        }
        public T visit(SetFuncNode node){
            return visitChildren(node);
        }

        // Literal values node
        public T visit(FloatNode node){
            return visitChildren(node);
        }
        public T visit(IntegerNode node){
            return visitChildren(node);
        }
        public T visit(StringNode node){
            return visitChildren(node);
        }

    public T visit(AddExprNode node){
        return visitChildren(node);
    }
    public T visit(IDNode node){
        return visitChildren(node);
    }
    public T visit(MultiExprNode node){
        return visitChildren(node);
    }

    // Logical expression nodes
    public T visit(ComparisonExprNode node){
        return visitChildren(node);
    }
    public T visit(LogicalAndExprNode node){
        return visitChildren(node);
    }
    public T visit(LogicalLiteralNode node){
        return visitChildren(node);
    }
    public T visit(LogicalOrExprNode node){
        return visitChildren(node);
    }

    // Wait
    public T visit(WaitNode node){
        return visitChildren(node);
    }

    public T visit(AssignmentNode node){
        return visitChildren(node);
    }
    public T visit(BreakNode node){
        return visitChildren(node);
    }
    public T visit(IfStmtNode node){
        return visitChildren(node);
    }
    public T visit(ReturnNode node){
        return visitChildren(node);
    }
    public T visit(WhileNode node){
        return visitChildren(node);
    }

    // Time nodes
    public T visit(DateNode node){
        return visitChildren(node);
    }
    public T visit(NowNode node){
        return visitChildren(node);
    }
    public T visit(TimeNode node){
        return visitChildren(node);
    }

    // Declaration nodes
    public T visit(DeclsNode node){
        return visitChildren(node);
    }
    public T visit(DevDeclNode node){
        return visitChildren(node);
    }
    public T visit(VarDeclNode node){
        return visitChildren(node);
    }

    // Block and init
    public T visit(BlockNode node){
        return visitChildren(node);
    }
    public T visit(InitNode node){
        return visitChildren(node);
    }

}


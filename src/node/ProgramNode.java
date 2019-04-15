package node;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import visitor.ASTBaseVisitor;

public class ProgramNode extends UnaryNode {
    SymbolTable st;

    public ProgramNode(ParserRuleContext ctx, Node child) {
        super(ctx, child);
    }

    public ProgramNode(ParserRuleContext ctx, Node child, SymbolTable st) {
        super(ctx, child);
        this.st = st;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }

    public SymbolTable getSt() {
        return st;
    }
}

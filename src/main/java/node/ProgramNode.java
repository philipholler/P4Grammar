package node;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.codegen.model.decl.Decl;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import visitor.ASTBaseVisitor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProgramNode extends UnaryNode {
    SymbolTable st;

    public ProgramNode(ParserRuleContext ctx, Node child, SymbolTable st) {
        super(ctx, child);
        this.st = st;
    }

    public DeclsNode getDeclsNode(){
        return (DeclsNode) this.getChild();
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }

    public SymbolTable getSt() {
        return st;
    }
}

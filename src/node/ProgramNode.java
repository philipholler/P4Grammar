package node;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.AbstractVisitor;

public class ProgramNode extends UnaryNode {

    public ProgramNode(ParserRuleContext ctx, Node child) {
        super(ctx, child);
    }

}

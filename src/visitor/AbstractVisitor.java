package visitor;

import node.*;
import node.define_nodes.DefNode;
import node.define_nodes.InputNode;
import node.define_nodes.OutputNode;

public abstract class AbstractVisitor {

    public abstract Object visit(ProgramNode node);
    public abstract Object visit(EnumValuesNode node);
    public abstract Object visit(DeclsNode node);
    public abstract Object visit(DefNode node);
    public abstract Object visit(VarDeclNode node);
    public abstract Object visit(DevDeclNode node);
    public abstract Object visit(RangeNode node);
    public abstract Object visit(OutputNode node);
    public abstract Object visit(InputNode node);
}

package visitor;

import node.*;
import node.define_nodes.DefNode;
import node.define_nodes.InputNode;
import node.define_nodes.OutputNode;

/**
 * Philip 31.03.2019
 * This abstract class is only used to manage a list of all visitable nodes using this abstract visitor.
 * The ASTBaseVisitor uses this abstract visitor to
 */

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

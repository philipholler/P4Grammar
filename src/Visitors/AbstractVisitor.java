package Visitors;

import Nodes.*;
import Nodes.DefineNodes.DefNode;
import Nodes.DefineNodes.InputNode;
import Nodes.DefineNodes.OutputNode;

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

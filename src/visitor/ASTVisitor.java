package visitor;

import node.DeclsNode;
import node.DevDeclNode;
import node.EnumValuesNode;
import node.ProgramNode;
import node.base.Node;
import node.define_nodes.DefDeviceNode;
import node.define_nodes.DefSignalNode;
import node.define_nodes.InputNode;
import node.define_nodes.OutputNode;

public interface ASTVisitor <T> {

    T visit(Node n);

    T visit(DefDeviceNode n);
    T visit(DefSignalNode n);
    T visit(InputNode n);
    T visit(OutputNode n);
    T visit(DeclsNode n);
    T visit(DevDeclNode n);
    T visit(EnumValuesNode n);





}

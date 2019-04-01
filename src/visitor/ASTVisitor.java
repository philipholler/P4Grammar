package visitor;

import node.DeclsNode;
import node.DevDeclNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Device.InputNode;
import node.define_nodes.Device.OutputNode;


/**
 * Philip, 31.03.2019
 * todo: What is this class for? who created it? It is not used anywhere. Maybe delete?
 */
public interface ASTVisitor <T> {

    T visit(Node n);
    T visit(DefDeviceNode n);
    T visit(DefSignalNode n);
    T visit(InputNode n);
    T visit(OutputNode n);
    T visit(DeclsNode n);
    T visit(DevDeclNode n);
}

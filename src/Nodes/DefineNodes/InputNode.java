package Nodes.DefineNodes;

import Nodes.Base.LeafNode;
import Visitors.AbstractVisitor;

public class InputNode extends LeafNode {

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}

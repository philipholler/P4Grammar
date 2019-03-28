package Visitors;

import Nodes.programNode;

public abstract class AbstractVisitor {

    public abstract Object visit(programNode node);
}

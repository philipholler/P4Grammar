package node.base;

import visitor.ASTBaseVisitor;

public interface Visitable {
    <T>T accept(ASTBaseVisitor<? extends T> astBaseVisitor);
}

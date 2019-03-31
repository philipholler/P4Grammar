package node.base;

import visitor.AbstractVisitor;

/**
 * Philip 31.03.2019
 * All nodes, that can be visited by the visitor extended by the AbstractVistor must implement this interface to work
 * with the given visitors.
 */
public interface Visitable {
    Object accept(AbstractVisitor visitor);
}

package visitor;

public interface Visitable {
    Object accept(AbstractVisitor visitor);
}

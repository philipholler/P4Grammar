package visitor.codegen;

import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import visitor.ASTBaseVisitor;

public class MethodSignatureVisitor extends ASTBaseVisitor<String> {

    private static final String EVENT_SIGNATURE_PREFIX = "on";

    @Override
    public String visit(EventInputNode node) {
        return node.getDeviceID() + node.getSignalID() + node.getEnumID();
    }

    @Override
    public String visit(EventRangeInputNode node) {
        return super.visit(node);
    }

    @Override
    public String visit(EventWhenTimeNode node) {
        return super.visit(node);
    }

    @Override
    public String visit(EventEveryNode node) {
        return super.visit(node);
    }
}

package visitor.codegen;

import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.TimeNodes.DateNode;
import node.TimeNodes.TimeNode;
import visitor.ASTBaseVisitor;

import java.time.LocalTime;

public class MethodSignatureVisitor extends ASTBaseVisitor<String> {

    private static final String EVENT_SIGNATURE_PREFIX = "on";
    private static final String EVERY_SIGNATURE_PREFIX = "every";
    private static final String WHEN_SIGNATURE_PREFIX = "when";

    @Override
    public String visit(EventInputNode node) {
        return EVENT_SIGNATURE_PREFIX + node.getDeviceID() + node.getSignalID() + node.getEnumID();
    }

    @Override
    public String visit(EventRangeInputNode node) {
        return EVENT_SIGNATURE_PREFIX + node.getDeviceID() + node.getSignalID()
                + node.getExceedsAndDeceedsEnum().name() + "line" + node.getLineNumber();
    }

    @Override
    public String visit(EventWhenTimeNode node) {
        return WHEN_SIGNATURE_PREFIX + visit(node.getDateNode()) + visit(node.getTimeNode());
    }

    @Override
    public String visit(EventEveryNode node) {
        return EVERY_SIGNATURE_PREFIX + visit(node.getDateNode()) + visit(node.getTimeNode());
    }

    @Override
    public String visit(DateNode node) {
        if(node == null) return  "";
        String s = "";

        if (node.getDate() != null)
            s += node.getDate().toString().replaceAll("-", "_");
        if(node.getMonthDay() != null)
            s += "day_" + node.getMonthDay().toString().replaceAll("-", "_");

        return s;
    }

    @Override
    public String visit(TimeNode node) {
        if(node == null) return "";
        LocalTime t = node.getTime();
        return t.getHour() + "h" + t.getMinute() + "m" + t.getSecond() + "s";
    }
}

package node.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import utils.TimeUtils;
import visitor.ASTBaseVisitor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;

public class DateNode extends LogicalExprNode {
    LocalDate date;
    MonthDay monthDay;

    public DateNode(ParserRuleContext ctx, int day, int month, int year) {
        super(ctx);
        this.date = TimeUtils.getDate(day, month, year);
    }

    public DateNode(ParserRuleContext ctx, int day, int month) {
        super(ctx);
        this.monthDay = TimeUtils.getMonthDay(day, month);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        if(date == null){
            return "DateNode(" +
                    "monthDay=" + monthDay +
                    ')';
        } else {
            return "DateNode(" +
                    "date=" + date +
                    ')';
        }

    }

    public LocalDate getDate() {
        return date;
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}

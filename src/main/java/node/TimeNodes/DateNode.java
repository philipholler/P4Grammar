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
    private int day = -1;

    public DateNode(ParserRuleContext ctx, int day, int month, int year) {
        super(ctx);
        this.date = TimeUtils.getDate(day, month, year);
    }

    public DateNode(ParserRuleContext ctx, int day, int month) {
        super(ctx);
        this.monthDay = TimeUtils.getMonthDay(day, month);
    }

    public DateNode(ParserRuleContext ctx, int day) {
        super(ctx);
        this.day = day;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        if(date != null){
            return "DateNode(" +
                    "date=" + date +
                    ')';
        } else if (monthDay != null){
            return "DateNode(" +
                    "monthday=" + monthDay +
                    ')';
        } else {
            return "DateNode(" +
                    "day=" + day +
                    ')';
        }

    }

    public boolean hasDate(){
        return date != null;
    }

    public boolean hasMonthDay(){
        return date != null;
    }

    public boolean hasday(){
        return day != 1;
    }

    public LocalDate getDate() {
        return date;
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }

    public int getDay(){
        return day;
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}

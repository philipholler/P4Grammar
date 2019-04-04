package node.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import utils.StringUtils;
import utils.TimeUtils;

import java.time.LocalDate;
import java.time.MonthDay;

public class DateNode extends LogicalExprNode {
    // todo: find proper date library and implement - Philip
    LocalDate date;
    MonthDay monthDay;

    public DateNode(int day, int month, int year) {
        this.date = TimeUtils.getDate(day, month, year);
    }

    public DateNode(int day, int month) {
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
}

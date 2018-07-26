package com.qxb.student.type;

public enum OrderType {

    TO_PAY(1, "待支付"),
    PERFECT_INFO(2, "完善资料"),
    TO_HANDLE(3, "待处理"),
    HANDLE(4, "处理中"),
    TO_EVALUATE(5, "待评价"),
    CLOSE(6, "订单关闭"),
    COMPLETE(7, "订单完成");

    private int type;
    private String tag;

    private OrderType(int type, String tag) {
        this.type = type;
        this.tag = tag;
    }

    public static String getByStatus(int status) {
        for (OrderType type : OrderType.values()) {
            if (type.getType() == status) {
                return type.getTag();
            }
        }
        return "";
    }

    public int getType() {
        return type;
    }

    public String getTag() {
        return tag;
    }
}

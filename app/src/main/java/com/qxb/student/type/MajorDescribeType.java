package com.qxb.student.type;

/**
 * Created by hs019 on 2017/3/13.
 */
public enum MajorDescribeType {

    One(0, "专业一"), Two(1, "专业二"), Three(2, "专业三"), Four(3, "专业四"), Five(4, "专业五"),
    Sex(5, "专业六"), Seven(6, "专业七"), Eight(7, "专业八"), Nine(8, "专业九"), Ten(9, "专业十");

    private int position;
    private String str;

    private MajorDescribeType(int position, String str) {
        this.position = position;
        this.str = str;
    }

    public static String getMajorDescribeByPosition(int position) {
        for (MajorDescribeType type : MajorDescribeType.values()) {
            if (type.position == position) {
                return type.str;
            }
        }
        return "";
    }
}

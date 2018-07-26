package com.qxb.student.type;

public enum LetterDictionaryType {
    /**
     * 下标对应字母
     */
    A(1, "A"), B(2, "B"), C(3, "C"), D(4, "D"), E(5, "E"), F(6, "F"), G(7, "G"), H(8, "H"), I(9, "I"), J(10, "J"), K(11, "K"), L(12, "L"), M(13, "M"), N(14, "N"), O(15, "O"), P(16, "P"), Q(17, "Q"), R(18, "R"), S(19, "S"), T(20, "T"), U(21, "U"), V(22, "V"), W(23, "W"), X(24, "X"), Y(25, "Y"), Z(26, "Z");


    private int position;
    private String tag;

    private LetterDictionaryType(int position, String tag) {
        this.position = position;
        this.tag = tag;
    }

    public static int getPosition(String tag) {
        for (LetterDictionaryType type : LetterDictionaryType.values()) {
            if (type.tag.equals(tag)) {
                return type.position;
            }
        }
        return -1;
    }

    public static String getTag(int position) {
        for (LetterDictionaryType type : LetterDictionaryType.values()) {
            if (type.position == position) {
                return type.tag;
            }
        }
        return "";
    }
}

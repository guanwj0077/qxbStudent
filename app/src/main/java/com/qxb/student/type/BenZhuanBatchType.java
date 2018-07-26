package com.qxb.student.type;

public enum BenZhuanBatchType {

    /**
     * 批次
     */
    BenKe1(1, 1, 1, "本科第一批"),
    BenKe2(1, 2, 2, "本科第二批"),
    BenKe3(1, 3, 3, "本科第三批"),
    ZhuanKe1(2, 1, 4, "专科第一批"),
    ZhuanKe2(2, 2, 5, "专科第二批");

    private int major_type;
    private int batch;
    private int bat;
    private String name;

    /**
     * majortype 1 ：本科 2：专科
     * batch 批次，1：第一批 2：第二批
     * bat 1：本科一 2：本科二 3：本科三 4：专科一 5：专科二
     */
    private BenZhuanBatchType(int majorType, int batch, int bat, String name) {
        this.major_type = majorType;
        this.batch = batch;
        this.bat = bat;
        this.name = name;
    }

    /**
     * 根据bat获取批次昵称
     * @param majorType
     * @param batch
     * @return
     */
    public static String getNameByMajorAndBatch(int majorType, int batch) {
        for (BenZhuanBatchType batchType : BenZhuanBatchType.values()) {
            if (batchType.getMajor_type() == majorType && batchType.getBatch() == batch) {
                return batchType.getName();
            }
        }
        return "";
    }

    /**
     * 根据bat获取批次昵称
     * @param bat
     * @return
     */
    public static String getNameByBat(int bat) {
        for (BenZhuanBatchType batchType : BenZhuanBatchType.values()) {
            if (batchType.getBat() == bat) {
                return batchType.getName();
            }
        }
        return "";
    }

    public static int getBatByMajorAndBatch(int majorType, int batch) {
        for (BenZhuanBatchType batchType : BenZhuanBatchType.values()) {
            if (batchType.getMajor_type() == majorType && batchType.getBatch() == batch) {
                return batchType.getBat();
            }
        }
        return 0;
    }

    public int getMajor_type() {
        return major_type;
    }

    public void setMajor_type(int major_type) {
        this.major_type = major_type;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getBat() {
        return bat;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

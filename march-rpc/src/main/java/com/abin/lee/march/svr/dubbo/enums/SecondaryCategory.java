package com.abin.lee.march.svr.dubbo.enums;

public enum SecondaryCategory {
    DEFAULT(0, "默认"),
    SYSTEM(10, "系统"),
    MANNUAL(20, "人工");

    private int typeId;
    private String typeName;

    SecondaryCategory(int typeId, String typeName) {
        this.typeName = typeName;
        this.typeId = typeId;
    }

    public static SecondaryCategory getSmallType(int typeId) {
        for (SecondaryCategory sourceType : SecondaryCategory.values()) {
            if (sourceType.getTypeId() == typeId) {
                return sourceType;
            }
        }
        return null;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getTypeId() {
        return typeId;
    }


}

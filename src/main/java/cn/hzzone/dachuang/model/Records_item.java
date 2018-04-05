package cn.hzzone.dachuang.model;

public class Records_item {
    private String itemInfo;

    private String itemType;

    private String recordsId;

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo == null ? null : itemInfo.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(String recordsId) {
        this.recordsId = recordsId == null ? null : recordsId.trim();
    }
}
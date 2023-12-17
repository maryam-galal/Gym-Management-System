package com.example.mainpage;

public abstract class Equipments {
    protected String EquipmentName;
    protected String EquipmentCode;
    protected int EquipmentQuantity;
    protected String EquipmentType;

    public Equipments(){

    }


    public Equipments(String EquimentName, String EquipmentId, int EquipmentQuantity){
        this.EquipmentName=EquimentName;
        this.EquipmentCode =EquipmentId;
        this.EquipmentQuantity=EquipmentQuantity;
    }


    public String getEquipmentName() {
        return EquipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        EquipmentName = equipmentName;
    }

    public String getEquipmentCode() {
        return EquipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        EquipmentCode = equipmentCode;
    }

    public int getEquipmentQuantity() {
        return EquipmentQuantity;
    }

    public void setEquipmentQuantity(int equipmentQuantity) {
        EquipmentQuantity = equipmentQuantity;
    }

    public String toCsvLine() {
        return String.format("%s,%d,%d", EquipmentName, EquipmentCode, EquipmentQuantity);
    }

    public String getEquipmentType() {
        return EquipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        EquipmentType = equipmentType;
    }

    public void maintenance(String entryDate){}
}

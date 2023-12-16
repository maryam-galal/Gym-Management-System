package com.example.mainpage;

public class CardioEquipment extends Equipments{
private String entryDate;
public CardioEquipment(String EquimentName, String EquipmentCode, int EquipmentQuantity){
    super(EquimentName,EquipmentCode,EquipmentQuantity);
    this.EquipmentType="cardio";

  }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}

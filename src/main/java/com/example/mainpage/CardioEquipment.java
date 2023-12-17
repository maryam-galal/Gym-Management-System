package com.example.mainpage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
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
    @Override
    public void maintenance(String entryDate) {
        if (entryDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(entryDate, formatter);
            LocalDate today = LocalDate.now();
            long daysDifference = ChronoUnit.DAYS.between(parsedDate, today);
            if (daysDifference > 45) {
                MainApplication.showAlert("This Equipment needs to be maintained");
            }
        }
    }

}

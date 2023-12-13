package com.example.mainpage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InBody {

 protected String Date_of_InBody;
 protected double height;
 protected double total_weight;
 protected  double body_fat;
 protected double mass;
 protected  double minerals_var;
 protected  double water_weight;
 protected double protein_var;





 public String getDate_of_InBody() {
  return Date_of_InBody;
 }

 public void setDate_of_InBody(String date_of_InBody) {
  Date_of_InBody = date_of_InBody;
 }

 public double getHeight() {
  return height;
 }

 public void setHeight(double height) {
  this.height = height;
 }

 public double getTotal_weight() {
  return total_weight;
 }

 public void setTotal_weight(double total_weight) {
  this.total_weight = total_weight;
 }

 public double getBody_fat() {
  return body_fat;
 }

 public void setBody_fat(double body_fat) {
  this.body_fat = body_fat;
 }

 public double getMass() {
  return mass;
 }

 public void setMass(double mass) {
  this.mass = mass;
 }

 public double getMinerals_var() {
  return minerals_var;
 }

 public void setMinerals_var(double minerals_var) {
  this.minerals_var = minerals_var;
 }

 public double getWater_weight() {
  return water_weight;
 }

 public void setWater_weight(double water_weight) {
  this.water_weight = water_weight;
 }

 public double getProtein_var() {
  return protein_var;
 }

 public void setProtein_var(double protein_var) {
  this.protein_var = protein_var;
 }

 public static double calculateIdealWeight(double heightInMeters) {
  // Assuming normal BMI is between 18.5 and 24.9
  double idealBMI = 21.7; // Average of the normal BMI range
  // Formula: weight = BMI * (height in meters)^2
  double idealWeight = idealBMI * Math.pow(heightInMeters, 2);
  return idealWeight;
 }

}


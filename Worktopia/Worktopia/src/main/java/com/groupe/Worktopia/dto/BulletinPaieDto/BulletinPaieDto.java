package com.groupe.Worktopia.dto.BulletinPaieDto;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletinPaieDto {
   private Long bulletinId;

    private double salaireBrut;

    private double salaireNet;

    private LocalDateTime dateGeneration;

    private LocalDateTime dateModification;

    private EmployeDto employe;

 public Long getBulletinId() {
  return bulletinId;
 }

 public void setBulletinId(Long bulletinId) {
  this.bulletinId = bulletinId;
 }

 public EmployeDto getEmploye() {
  return employe;
 }

 public void setEmploye(EmployeDto employe) {
  this.employe = employe;
 }

 public LocalDateTime getDateModification() {
  return dateModification;
 }

 public void setDateModification(LocalDateTime dateModification) {
  this.dateModification = dateModification;
 }

 public LocalDateTime getDateGeneration() {
  return dateGeneration;
 }

 public void setDateGeneration(LocalDateTime dateGeneration) {
  this.dateGeneration = dateGeneration;
 }

 public double getSalaireNet() {
  return salaireNet;
 }

 public void setSalaireNet(double salaireNet) {
  this.salaireNet = salaireNet;
 }

 public double getSalaireBrut() {
  return salaireBrut;
 }

 public void setSalaireBrut(double salaireBrut) {
  this.salaireBrut = salaireBrut;
 }

 public BulletinPaieDto(Long bulletinId, EmployeDto employe, LocalDateTime dateModification, double salaireNet, LocalDateTime dateGeneration, double salaireBrut) {
  this.bulletinId = bulletinId;
  this.employe = employe;
  this.dateModification = dateModification;
  this.salaireNet = salaireNet;
  this.dateGeneration = dateGeneration;
  this.salaireBrut = salaireBrut;
 }
}

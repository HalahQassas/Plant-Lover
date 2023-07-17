/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vip
 */
@Entity
@Table(name = "PLANT")
public class plant implements java.io.Serializable{

    @Id
    @Column(name = "plantName")
    private String plantName;
    @Column(name = "irrigation")
    private String irrigation;
    @Column(name = "fertilization")
    private String fertilization;

    public plant() {
    }

    public plant(String plantName, String irrigation, String fertilization) {

        this.plantName = plantName;
        this.irrigation = irrigation;
        this.fertilization = fertilization;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setIrrigation(String irrigation) {
        this.irrigation = irrigation;
    }

    public void setFertilization(String fertilization) {
        this.fertilization = fertilization;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getIrrigation() {
        return irrigation;
    }

    public String getFertilization() {
        return fertilization;
    }
    

}

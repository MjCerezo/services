
package com.loansdb.data;



/**
 *  LOANSDB.Tbvehicle
 *  10/13/2020 10:21:35
 * 
 */
public class Tbvehicle {

    private Integer automakeid;
    private String make;
    private String model;
    private String vehiclecategory;
    private String modeldetails;

    public Integer getAutomakeid() {
        return automakeid;
    }

    public void setAutomakeid(Integer automakeid) {
        this.automakeid = automakeid;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehiclecategory() {
        return vehiclecategory;
    }

    public void setVehiclecategory(String vehiclecategory) {
        this.vehiclecategory = vehiclecategory;
    }

    public String getModeldetails() {
        return modeldetails;
    }

    public void setModeldetails(String modeldetails) {
        this.modeldetails = modeldetails;
    }

}

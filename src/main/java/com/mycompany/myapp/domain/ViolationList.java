package com.mycompany.myapp.domain;

public class ViolationList {
    private Long vehicleGroupCode;

    private String vehicleGroupName;

    private String nomisStr;

    private String identifiedNumber;

    public String getIdentifiedNumber() {
        return identifiedNumber;
    }

    public void setIdentifiedNumber(String identifiedNumber) {
        this.identifiedNumber = identifiedNumber;
    }

    public String getNomisStr() {
        return nomisStr;
    }

    public void setNomisStr(String nomisStr) {
        this.nomisStr = nomisStr;
    }

    public String getVehicleGroupName() {
        return vehicleGroupName;
    }

    public void setVehicleGroupName(String vehicleGroupName) {
        this.vehicleGroupName = vehicleGroupName;
    }

    public Long getVehicleGroupCode() {
        return vehicleGroupCode;
    }

    public void setVehicleGroupCode(Long vehicleGroupCode) {
        this.vehicleGroupCode = vehicleGroupCode;
    }


}

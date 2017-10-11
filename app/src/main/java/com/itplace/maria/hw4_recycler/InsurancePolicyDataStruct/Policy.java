package com.itplace.maria.hw4_recycler.InsurancePolicyDataStruct;

import java.util.Date;

public class Policy {

    String number;
    PolicyType type;
    String insurancedObject;  // Объект страхования - Марка автомобиля или адрес квартиры или ФИО человека
    Date beginDate;
    Integer workPeriod; // Количество дней

    public Policy(String number, PolicyType type, String insurancedObject, Date beginDate, Integer workPeriod) {
        this.number = number;
        this.type = type;
        this.insurancedObject = insurancedObject;
        this.beginDate = beginDate;
        this.workPeriod = workPeriod;
    }

    public String getNumber() { return number; }
    public PolicyType getType() { return type; }
    public String getInsurancedObject() { return insurancedObject; }
    public Date getBeginDate() { return beginDate; }
    public Integer getWorkPeriod() { return workPeriod; }

}

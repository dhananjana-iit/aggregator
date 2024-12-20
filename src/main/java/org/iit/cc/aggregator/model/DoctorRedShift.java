package org.iit.cc.aggregator.model;

public class DoctorRedShift {
    private int doctor_id;
    private String name;
    private String specialization;

    public DoctorRedShift(int doctor_id, String name, String specialization) {
        this.doctor_id = doctor_id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

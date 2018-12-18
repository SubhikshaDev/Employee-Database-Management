package com.example.subhidev.venzo;

public class SaveData {
   String employeeid,employeename,education,university,passing,employer1,duration;

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPassing() {
        return passing;
    }

    public void setPassing(String passing) {
        this.passing = passing;
    }

    public String getEmployer1() {
        return employer1;
    }

    public void setEmployer1(String employer1) {
        this.employer1 = employer1;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public SaveData(String employeeid, String employeename, String education, String university, String passing, String employer1, String duration) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.education = education;
        this.university = university;
        this.passing = passing;
        this.employer1 = employer1;
        this.duration = duration;
    }

    public SaveData() {
    }
}

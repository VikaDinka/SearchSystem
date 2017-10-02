package model;

import java.util.Date;


public class Pojo {
    public Pojo() {
        super();
    }
    
    private int EmployeeId;
    
    private String FirstName;
    
    private String LastName;
    
    private String Email;
    
    private String PhoneNumber;
    
    private Date HireDate;
    
    private String JobId;
    
    private String Salary;
    
    private String CommissionPct;
    
    private int ManagerId;
    
    private int DepartmentId;

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setHireDate(Date HireDate) {
        this.HireDate = HireDate;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setJobId(String JobId) {
        this.JobId = JobId;
    }

    public String getJobId() {
        return JobId;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public String getSalary() {
        return Salary;
    }

    public void setCommissionPct(String CommissionPct) {
        this.CommissionPct = CommissionPct;
    }

    public String getCommissionPct() {
        return CommissionPct;
    }

    public void setManagerId(int ManagerId) {
        this.ManagerId = ManagerId;
    }

    public int getManagerId() {
        return ManagerId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }
}

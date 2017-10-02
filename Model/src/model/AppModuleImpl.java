package model;

import oracle.jbo.ViewCriteria;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

//import model.common.EmployeesViewRow;
import model.EmployeesViewImpl;

import javax.lang.model.element.Name;

import oracle.jbo.NameValuePairs;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 27 11:08:30 EEST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }

    /**
     * Container's getter for DepartmentsView1.
     * @return DepartmentsView1
     */
    public ViewObjectImpl getDepartmentsView1() {
        return (ViewObjectImpl) findViewObject("DepartmentsView1");
    }

    /**
     * Container's getter for EmployeesView1.
     * @return EmployeesView1
     */
    public EmployeesViewImpl getEmployeesView1() {
        return (EmployeesViewImpl) findViewObject("EmployeesView1");
    }
    
    public String storeDataInTable(Pojo myData) {
        ViewObjectImpl myVO = this.getEmployeesView1();
        ViewCriteria vc = myVO.getViewCriteria("EmployeesViewCriteria");
        myVO.setNamedWhereClauseParam("FirstName", myData.getFirstName());
        myVO.applyViewCriteria((oracle.jbo.ViewCriteria) vc);
        myVO.executeQuery();
        while (myVO.hasNext()) {
            EmployeesViewRowImpl row = (EmployeesViewRowImpl) myVO.next();
            row.setFirstName(myData.getFirstName());
        }
        this.getDBTransaction().commit();
        return "";
    }
    
    public boolean addNewRecord(Pojo myData) {
        //Get ViewObject Instance
        try {
            
            EmployeesViewImpl demoVo = (EmployeesViewImpl)this.getEmployeesView3();


            // Creates a row in ViewObject
            Row r = demoVo.createRow();
            // You can set attribute values in this new row
            //r.setEmployeeId(300);
            r.setAttribute("FirstName", myData.getFirstName());
            
            //Insert that row in ViewObject
            demoVo.insertRow(r);

            //Commit the changes, If you need
            this.getDBTransaction().commit();
            demoVo.executeQuery();
            return true;
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Container's getter for EmployeesView2.
     * @return EmployeesView2
     */
    public EmployeesViewImpl getEmployeesView2() {
        return (EmployeesViewImpl) findViewObject("EmployeesView2");
    }

    /**
     * Container's getter for DepartmentsView2.
     * @return DepartmentsView2
     */
    public ViewObjectImpl getDepartmentsView2() {
        return (ViewObjectImpl) findViewObject("DepartmentsView2");
    }

    /**
     * Container's getter for EmployeesView3.
     * @return EmployeesView3
     */
    public EmployeesViewImpl getEmployeesView3() {
        return (EmployeesViewImpl) findViewObject("EmployeesView3");
    }

    /**
     * Container's getter for EmpManagerFkLink1.
     * @return EmpManagerFkLink1
     */
    public ViewLinkImpl getEmpManagerFkLink1() {
        return (ViewLinkImpl) findViewLink("EmpManagerFkLink1");
    }

    /**
     * Container's getter for DeptMgrFkLink1.
     * @return DeptMgrFkLink1
     */
    public ViewLinkImpl getDeptMgrFkLink1() {
        return (ViewLinkImpl) findViewLink("DeptMgrFkLink1");
    }

    /**
     * Container's getter for EmpDeptFkLink1.
     * @return EmpDeptFkLink1
     */
    public ViewLinkImpl getEmpDeptFkLink1() {
        return (ViewLinkImpl) findViewLink("EmpDeptFkLink1");
    }
}

package view;

import model.AppModuleImpl;
import model.Pojo;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class ButtBean {
    
    private Pojo Pojo = new Pojo();
//    private RichPopup createPopup;
    private RichPopup deletePopup;
    private RichPopup updatePopup;
    private RichPopup addPopup;

    public void setAddPopup(RichPopup addPopup) {
        this.addPopup = addPopup;
    }

    public RichPopup getAddPopup() {
        return addPopup;
    }


    public void setPojo(Pojo Pojo) {
        this.Pojo = Pojo;
    }

    public Pojo getPojo() {
        return Pojo;
    }

    public ButtBean() {
    }

    public String create_action() {
        // Add event code here...
        return null;
    }
    
    public String addNewEmployees() {
        try {
            DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding iter = bc.findIteratorBinding("EmployeesView1Iterator");
            ViewObject obj = iter.getViewObject();

            //Object result ;

            Row r;
            r = obj.createRow();
            r.setAttribute("CommissionPct",Pojo.getCommissionPct());
            r.setAttribute("FirstName", Pojo.getFirstName());
            r.setAttribute("LastName", Pojo.getLastName());
            r.setAttribute("Email", Pojo.getEmail());
            r.setAttribute("PhoneNumber", Pojo.getPhoneNumber());
            r.setAttribute("DepartmentId", Pojo.getDepartmentId());
            r.setAttribute("JobId",Pojo.getJobId());
            r.setAttribute("HireDate", Pojo.getHireDate());
            r.setAttribute("ManagerId", Pojo.getManagerId());
            r.setAttribute("Salary", Pojo.getSalary());
            
            obj.insertRow(r);

            OperationBinding operationBinding;
            operationBinding = bc.getOperationBinding("Commit");
            operationBinding.execute();
            RichPopup popup = getAddPopup();
            popup.hide();
            
            //result = operationBinding.execute();

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        Pojo = new Pojo();
        return "";
    }

    public String update_action() {
        // Add event code here...
        return null;
    }

    public String delate_action() {
        // Add event code here...
        return null;
    }

    public String updateEmployee() {
        try{
            DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding iter = bc.findIteratorBinding("EmployeesView1Iterator");
            ViewObject obj = iter.getViewObject();
            
            OperationBinding operationBinding;
            operationBinding = bc.getOperationBinding("Commit");
            operationBinding.execute();
            
            RichPopup popup = getUpdatePopup();
            popup.cancel();
            
        }catch (Exception e){   
            // TODO: Add catch code
            e.printStackTrace();
        }
        return "";
    }
    
    public String delateEmployees() {
        try {
            DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding iter = bc.findIteratorBinding("EmployeesView1Iterator");
            ViewObject obj = iter.getViewObject();

            //Object result ;

            Row r;
            r = obj.getCurrentRow();
            
            r.remove();

            OperationBinding operationBinding;
            operationBinding = bc.getOperationBinding("Commit");
            operationBinding.execute();
            RichPopup popup = getDeletePopup();
            popup.hide();
            
            //result = operationBinding.execute();

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return "";
    }

    public void setDeletePopup(RichPopup deletePopup) {
        this.deletePopup = deletePopup;
    }

    public RichPopup getDeletePopup() {
        return deletePopup;
    }

    public void setUpdatePopup(RichPopup updatePopup) {
        this.updatePopup = updatePopup;
    }

    public RichPopup getUpdatePopup() {
        return updatePopup;
    }

    public String cancelDelate_action() {
        deletePopup.cancel();
        return "";
    }
    
    public String cancelUpdate_action() {
        updatePopup.cancel();
        return "";
    }

    public String cancelAdd_action() {
        RichPopup addPop = getAddPopup();
        addPop.cancel();
        return "";
    }
}

package common;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Employee表のエンティティクラス。
 * @author kohei
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "EMPLOYEETYPECODE")
    private Integer employeeTypeCode;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "SALARYCODE")
    private Integer salaryCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the employeeTypeCode
     */
    public Integer getEmployeeTypeCode() {
        return employeeTypeCode;
    }

    /**
     * @param employeeTypeCode the employeeTypeCode to set
     */
    public void setEmployeeTypeCode(Integer employeeTypeCode) {
        this.employeeTypeCode = employeeTypeCode;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the salaryCode
     */
    public Integer getSalaryCode() {
        return salaryCode;
    }

    /**
     * @param salaryCode the salaryCode to set
     */
    public void setSalaryCode(Integer salaryCode) {
        this.salaryCode = salaryCode;
    }
    
}

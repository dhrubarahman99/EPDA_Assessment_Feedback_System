/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dhruba
 */
@Entity
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ModuleID;
    private String module_name;
    private String SchemeID;

    public Module(Long ModuleID, String module_name, String SchemeID) {
        this.ModuleID = ModuleID;
        this.module_name = module_name;
        this.SchemeID = SchemeID;
    }

    public Module() {
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getSchemeID() {
        return SchemeID;
    }

    public void setSchemeID(String SchemeID) {
        this.SchemeID = SchemeID;
    }

    
    
    public Long getModuleID() {
        return ModuleID;
    }

    public void setModuleID(Long ModuleID) {
        this.ModuleID = ModuleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ModuleID != null ? ModuleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.ModuleID == null && other.ModuleID != null) || (this.ModuleID != null && !this.ModuleID.equals(other.ModuleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Module[ id=" + ModuleID + " ]";
    }
    
}

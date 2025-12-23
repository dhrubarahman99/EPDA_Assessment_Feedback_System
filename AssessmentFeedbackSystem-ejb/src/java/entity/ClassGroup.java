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
public class ClassGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ClassID;
    private String lecture_ID;
    private String students_ID;
    private String ModuleID;

    public ClassGroup(Long ClassID, String lecture_ID, String students_ID, String ModuleID) {
        this.ClassID = ClassID;
        this.lecture_ID = lecture_ID;
        this.students_ID = students_ID;
        this.ModuleID = ModuleID;
    }

    public ClassGroup() {
    }

    public String getLecture_ID() {
        return lecture_ID;
    }

    public void setLecture_ID(String lecture_ID) {
        this.lecture_ID = lecture_ID;
    }

    public String getStudents_ID() {
        return students_ID;
    }

    public void setStudents_ID(String students_ID) {
        this.students_ID = students_ID;
    }

    public String getModuleID() {
        return ModuleID;
    }

    public void setModuleID(String ModuleID) {
        this.ModuleID = ModuleID;
    }
    
    

    public Long getClassID() {
        return ClassID;
    }

    public void setClassID(Long ClassID) {
        this.ClassID = ClassID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ClassID != null ? ClassID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassGroup)) {
            return false;
        }
        ClassGroup other = (ClassGroup) object;
        if ((this.ClassID == null && other.ClassID != null) || (this.ClassID != null && !this.ClassID.equals(other.ClassID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClassGroup[ id=" + ClassID + " ]";
    }
    
}

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
public class Assessment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AssessmentID;
    private String assessment_name;
    private String ModuleID;
    
    public Assessment(Long AssessmentID, String assessment_name, String ModuleID) {
        this.AssessmentID = AssessmentID;
        this.assessment_name = assessment_name;
        this.ModuleID = ModuleID;
    }

    public Assessment() {
    }

    public void setAssessment_name(String assessment_name) {
        this.assessment_name = assessment_name;
    }

    public void setModuleID(String ModuleID) {
        this.ModuleID = ModuleID;
    }
    
    
    public String getAssessment_name() {
        return assessment_name;
    }

    public String getModuleID() {
        return ModuleID;
    }
    

    public Long getAssessmentID() {
        return AssessmentID;
    }

    public void setAssessmentID(Long AssessmentID) {
        this.AssessmentID = AssessmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (AssessmentID != null ? AssessmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assessment)) {
            return false;
        }
        Assessment other = (Assessment) object;
        if ((this.AssessmentID == null && other.AssessmentID != null) || (this.AssessmentID != null && !this.AssessmentID.equals(other.AssessmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Assessment[ id=" + AssessmentID + " ]";
    }
    
}

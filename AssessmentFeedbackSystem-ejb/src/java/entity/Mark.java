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
public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String AssessmentID_UserID;
    private Long Marks;

    public Mark(String AssessmentID_UserID, Long Marks) {
        this.AssessmentID_UserID = AssessmentID_UserID;
        this.Marks = Marks;
    }



    public Mark() {
    }



    public Long getMarks() {
        return Marks;
    }

    public void setMarks(Long Marks) {
        this.Marks = Marks;
    }

    
   
    public String getAssessmentID_UserID() {
        return AssessmentID_UserID;
    }

    public void setAssessmentID_UserID(String AssessmentID_UserID) {
        this.AssessmentID_UserID = AssessmentID_UserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (AssessmentID_UserID != null ? AssessmentID_UserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.AssessmentID_UserID == null && other.AssessmentID_UserID != null) || (this.AssessmentID_UserID != null && !this.AssessmentID_UserID.equals(other.AssessmentID_UserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mark[ id=" + AssessmentID_UserID + " ]";
    }
    
}

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
public class GradeScheme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String SchemeID_Grade;
    private Long lower_bound;
    private Long upper_bound;

    public GradeScheme(String SchemeID_Grade, Long lower_bound, Long upper_bound) {
        this.SchemeID_Grade = SchemeID_Grade;
        this.lower_bound = lower_bound;
        this.upper_bound = upper_bound;
    }

    public String getSchemeID_Grade() {
        return SchemeID_Grade;
    }

    public void setSchemeID_Grade(String SchemeID_Grade) {
        this.SchemeID_Grade = SchemeID_Grade;
    }

    

    public GradeScheme() {
    }



    public Long getLower_bound() {
        return lower_bound;
    }

    public void setLower_bound(Long lower_bound) {
        this.lower_bound = lower_bound;
    }

    public Long getUpper_bound() {
        return upper_bound;
    }

    public void setUpper_bound(Long upper_bound) {
        this.upper_bound = upper_bound;
    }

    
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (SchemeID_Grade != null ? SchemeID_Grade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradeScheme)) {
            return false;
        }
        GradeScheme other = (GradeScheme) object;
        if ((this.SchemeID_Grade == null && other.SchemeID_Grade != null) || (this.SchemeID_Grade != null && !this.SchemeID_Grade.equals(other.SchemeID_Grade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GradeScheme[ id=" + SchemeID_Grade + " ]";
    }
    
}

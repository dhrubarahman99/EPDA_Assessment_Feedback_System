/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Dhruba
 */
@Entity
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String UserID_ClassID;

    public Enrollment() {
    }

    public Enrollment(String UserID_ClassID) {
        this.UserID_ClassID = UserID_ClassID;
    }

    public String getUserID_ClassID() {
        return UserID_ClassID;
    }

    public void setUserID_ClassID(String UserID_ClassID) {
        this.UserID_ClassID = UserID_ClassID;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (UserID_ClassID != null ? UserID_ClassID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enrollment)) {
            return false;
        }
        Enrollment other = (Enrollment) object;
        if ((this.UserID_ClassID == null && other.UserID_ClassID != null) || (this.UserID_ClassID != null && !this.UserID_ClassID.equals(other.UserID_ClassID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Enrollment[ id=" + UserID_ClassID + " ]";
    }
    
}

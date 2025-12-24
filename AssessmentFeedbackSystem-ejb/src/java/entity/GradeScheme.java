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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // ATTRIBUTES
    private String schemeName;
    private int aMin;
    private int bMin;
    private int cMin;
    private int dMin;

    // CONSTRUCTORS
    public GradeScheme() {
    }

    public GradeScheme(String schemeName, int aMin, int bMin, int cMin, int dMin) {
        this.schemeName = schemeName;
        this.aMin = aMin;
        this.bMin = bMin;
        this.cMin = cMin;
        this.dMin = dMin;
    }

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public int getAMin() {
        return aMin;
    }

    public void setAMin(int aMin) {
        this.aMin = aMin;
    }

    public int getBMin() {
        return bMin;
    }

    public void setBMin(int bMin) {
        this.bMin = bMin;
    }

    public int getCMin() {
        return cMin;
    }

    public void setCMin(int cMin) {
        this.cMin = cMin;
    }

    public int getDMin() {
        return dMin;
    }

    public void setDMin(int dMin) {
        this.dMin = dMin;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradeScheme)) {
            return false;
        }
        GradeScheme other = (GradeScheme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GradeScheme[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Dhruba
 */
@Entity
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // ATTRIBUTES
    private String moduleCode;
    private String moduleName;

    // RELATIONSHIPS AND FOREIGN KEYS

    @ManyToOne
    @JoinColumn(name = "grade_scheme_id")
    private GradeScheme gradeScheme;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private User lecturer;

    // CONSTRUCTORS
    public Module() {
    }

    public Module(String moduleCode, String moduleName, GradeScheme gradeScheme, User lecturer) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.gradeScheme = gradeScheme;
        this.lecturer = lecturer;
    }

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public GradeScheme getGradeScheme() {
        return gradeScheme;
    }

    public void setGradeScheme(GradeScheme gradeScheme) {
        this.gradeScheme = gradeScheme;
    }

    public User getLecturer() {
        return lecturer;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Module[ id=" + id + " ]";
    }
    
}

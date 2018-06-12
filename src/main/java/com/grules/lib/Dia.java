
package com.grules.lib;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@TableGenerator(name = "dia_id", initialValue = 1, allocationSize = 1)
public class Dia  implements Serializable {
    
    @Id()
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dia_id")
    @Column(name = "dia_id")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    
    @ManyToOne
    @JoinTable(name = "alunos_dia",
            joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "dia_id", referencedColumnName = "dia_id"))
    private List<Aluno> alunos;

    public Dia() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dia other = (Dia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
}

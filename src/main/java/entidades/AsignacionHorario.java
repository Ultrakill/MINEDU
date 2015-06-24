package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="asignacion_horario")
public class AsignacionHorario implements Serializable {

    @Column(unique=false,updatable=true,insertable=true,nullable=false,length=255,scale=0,precision=0)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false,targetEntity = Horario.class)
    @JoinColumn(name="horario_codigo",referencedColumnName="codigo",insertable=true,nullable=false,unique=false,updatable=true)
    private Horario horario;
    @Column(name="empleado_nro_documento",unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Basic
    private String empleado;
    //Campos para control de asignacionHorario, fecha inicio y fecha fin////////
    @Column(name="fecha_inicio",unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaInicio;
    @Column(name="fecha_fin",unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaFin;
    ////////////////////////////////////////////////////////////////////////////
    @ManyToOne(optional=true,targetEntity = GrupoHorario.class)
    @JoinColumn(name="grupo_horario_codigo",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
    private GrupoHorario grupoHorario;
    @Column(name="por_grupo",unique=false,updatable=true,insertable=true,nullable=false,length=255,scale=0,precision=0)
    @Basic
    private boolean porGrupo;

    public AsignacionHorario() {

    }
   
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
   
    public String getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
   
    public GrupoHorario getGrupoHorario() {
        return this.grupoHorario;
    }

    public void setGrupoHorario(GrupoHorario grupoHorario) {
        this.grupoHorario = grupoHorario;
    }
    
    public boolean isPorGrupo() {
        return this.porGrupo;
    }

    public void setPorGrupo(boolean porGrupo) {
        this.porGrupo = porGrupo;
    }
    
    //Get and set de fechas

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}

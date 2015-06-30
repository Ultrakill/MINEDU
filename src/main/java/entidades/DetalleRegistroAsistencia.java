package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="detalle_registro_asistencia")
public class DetalleRegistroAsistencia implements Serializable {

    @Column(unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Basic
    private int orden;
    @Column(unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="minutos_extra",unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Basic
    private BigDecimal minExtra;
    @Column(name="minutos_tardanza",unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Basic
    private BigDecimal minTardanza;
    @ManyToOne(optional=true,targetEntity = Permiso.class)
    @JoinColumn(name="permiso_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Permiso permiso;
    @Column(name="hora_inicio",unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Temporal(TemporalType.TIME)
    @Basic
    private Date horaInicio;
    @Column(name="hora_fin",unique=false,updatable=true,insertable=true,nullable=true,length=255,scale=0,precision=0)
    @Temporal(TemporalType.TIME)
    @Basic
    private Date horaFin;
    @Column(name="tipo_registro",unique=false,updatable=true,insertable=true,nullable=false,length=255,scale=0,precision=0)
    @Basic
    private char tipoRegistro;
    @Column(unique=false,updatable=true,insertable=true,nullable=false,length=255,scale=0,precision=0)
    @Basic
    private char resultado;
    @ManyToOne(optional=false,targetEntity = RegistroAsistencia.class)
    @JoinColumn(name="registro_asistencia_id",referencedColumnName="id",insertable=true,nullable=false,unique=false,updatable=true)
    private RegistroAsistencia registroAsistencia;

    public DetalleRegistroAsistencia() {

    }
   
    public int getOrden() {
        return this.orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
   
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public BigDecimal getMinExtra() {
        return this.minExtra;
    }

    public void setMinExtra(BigDecimal minExtra) {
        this.minExtra = minExtra;
    }
   
    public BigDecimal getMinTardanza() {
        return this.minTardanza;
    }

    public void setMinTardanza(BigDecimal minTardanza) {
        this.minTardanza = minTardanza;
    }
   
    public Permiso getPermiso() {
        return this.permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
   
    public Date getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }
   
    public Date getHoraFin() {
        return this.horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
   
    public char getTipoRegistro() {
        return this.tipoRegistro;
    }

    public void setTipoRegistro(char tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
   
    public char getResultado() {
        return this.resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }
   
    public RegistroAsistencia getRegistroAsistencia() {
        return this.registroAsistencia;
    }

    public void setRegistroAsistencia(RegistroAsistencia registroAsistencia) {
        this.registroAsistencia = registroAsistencia;
    }
}

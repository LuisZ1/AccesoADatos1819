package ejemplocriaturitas;
// Generated 01-feb-2019 14:20:51 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Regalos generated by hbm2java
 */
@Entity
@Table(name="Regalos"
    ,schema="dbo"
    ,catalog="Ejemplos"
)
public class Regalos  implements java.io.Serializable {


     private byte id;
     private Criaturitas criaturitas;
     private Serializable denominacion;
     private Byte ancho;
     private Byte largo;
     private Byte alto;
     private Character tipo;
     private byte edadMinima;
     private BigDecimal precio;
     private Short superficie;

    public Regalos() {
    }

	
    public Regalos(byte id, Serializable denominacion, byte edadMinima, BigDecimal precio) {
        this.id = id;
        this.denominacion = denominacion;
        this.edadMinima = edadMinima;
        this.precio = precio;
    }
    public Regalos(byte id, Criaturitas criaturitas, Serializable denominacion, Byte ancho, Byte largo, Byte alto, Character tipo, byte edadMinima, BigDecimal precio, Short superficie) {
       this.id = id;
       this.criaturitas = criaturitas;
       this.denominacion = denominacion;
       this.ancho = ancho;
       this.largo = largo;
       this.alto = alto;
       this.tipo = tipo;
       this.edadMinima = edadMinima;
       this.precio = precio;
       this.superficie = superficie;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false)
    public byte getId() {
        return this.id;
    }
    
    public void setId(byte id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GoesTo")
    public Criaturitas getCriaturitas() {
        return this.criaturitas;
    }
    
    public void setCriaturitas(Criaturitas criaturitas) {
        this.criaturitas = criaturitas;
    }

    
    @Column(name="Denominacion", nullable=false)
    public Serializable getDenominacion() {
        return this.denominacion;
    }
    
    public void setDenominacion(Serializable denominacion) {
        this.denominacion = denominacion;
    }

    
    @Column(name="Ancho")
    public Byte getAncho() {
        return this.ancho;
    }
    
    public void setAncho(Byte ancho) {
        this.ancho = ancho;
    }

    
    @Column(name="Largo")
    public Byte getLargo() {
        return this.largo;
    }
    
    public void setLargo(Byte largo) {
        this.largo = largo;
    }

    
    @Column(name="Alto")
    public Byte getAlto() {
        return this.alto;
    }
    
    public void setAlto(Byte alto) {
        this.alto = alto;
    }

    
    @Column(name="Tipo", length=1)
    public Character getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="EdadMinima", nullable=false)
    public byte getEdadMinima() {
        return this.edadMinima;
    }
    
    public void setEdadMinima(byte edadMinima) {
        this.edadMinima = edadMinima;
    }

    
    @Column(name="Precio", nullable=false, precision=10, scale=4)
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
    @Column(name="Superficie")
    public Short getSuperficie() {
        return this.superficie;
    }
    
    public void setSuperficie(Short superficie) {
        this.superficie = superficie;
    }




}


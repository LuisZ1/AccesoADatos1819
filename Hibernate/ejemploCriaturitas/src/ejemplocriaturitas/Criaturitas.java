package ejemplocriaturitas;
// Generated 01-feb-2019 14:20:51 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Criaturitas generated by hbm2java
 */
@Entity
@Table(name = "Criaturitas",
         schema = "dbo",
         catalog = "Ejemplos"
)
public class Criaturitas implements java.io.Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private byte id;

    @Column(name = "Nombre")
    private Serializable nombre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "regalos")
    private Set regaloses = new HashSet(0);

    public Criaturitas() {
    }

    public Criaturitas(byte id) {
        this.id = id;
    }

    public Criaturitas(byte id, Serializable nombre, Set regaloses) {
        this.id = id;
        this.nombre = nombre;
        this.regaloses = regaloses;
    }

    public byte getId() {
        return this.id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public Serializable getNombre() {
        return this.nombre;
    }

    public void setNombre(Serializable nombre) {
        this.nombre = nombre;
    }

    public Set getRegaloses() {
        return this.regaloses;
    }

    public void setRegaloses(Set regaloses) {
        this.regaloses = regaloses;
    }

}

package entity;
// Generated 26/04/2017 03:04:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pedido generated by hbm2java
 */
@Entity
@Table(name="pedido"
    ,schema="public"
)
public class Pedido  implements java.io.Serializable {


     private String idPedido;
     private Personal personal;
     private String idMesa;
     private String idTipo;
     private Date horaInicio;
     private Date horaEntrega;
     private Set<PedidoItem> pedidoItems = new HashSet<PedidoItem>(0);

    public Pedido() {
    }

	
    public Pedido(String idPedido) {
        this.idPedido = idPedido;
    }
    public Pedido(String idPedido, Personal personal, String idMesa, String idTipo, Date horaInicio, Date horaEntrega, Set<PedidoItem> pedidoItems) {
       this.idPedido = idPedido;
       this.personal = personal;
       this.idMesa = idMesa;
       this.idTipo = idTipo;
       this.horaInicio = horaInicio;
       this.horaEntrega = horaEntrega;
       this.pedidoItems = pedidoItems;
    }
   
     @Id 

    
    @Column(name="id_pedido", nullable=false, length=10)
    public String getIdPedido() {
        return this.idPedido;
    }
    
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_mesero")
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    
    @Column(name="id_mesa", length=10)
    public String getIdMesa() {
        return this.idMesa;
    }
    
    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    
    @Column(name="id_tipo", length=10)
    public String getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="hora_inicio", length=29)
    public Date getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="hora_entrega", length=29)
    public Date getHoraEntrega() {
        return this.horaEntrega;
    }
    
    public void setHoraEntrega(Date horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pedido")
    public Set<PedidoItem> getPedidoItems() {
        return this.pedidoItems;
    }
    
    public void setPedidoItems(Set<PedidoItem> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }




}


package tarjetas;

import Users.Cliente;
import java.time.LocalDateTime;

public class SolicitudTarjeta {
    private Cliente cliente;
    private TipoTarjeta tipoTarjeta;
    private LocalDateTime fechaSolicitud;
    private EstadoSolicitud estado;

    public SolicitudTarjeta(Cliente cliente, TipoTarjeta tipoTarjeta, LocalDateTime fechaSolicitud, EstadoSolicitud estado) {
        this.cliente = cliente;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }
    public SolicitudTarjeta(Cliente cliente, TipoTarjeta tipoTarjeta) {
        this.cliente = cliente;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = EstadoSolicitud.EN_PROCESO;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }
}

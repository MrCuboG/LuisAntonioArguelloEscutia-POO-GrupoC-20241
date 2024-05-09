//import java.time.LocalDate;
//import Users.Cliente;
//
//public class SolicitudTarjeta {
//    private Cliente cliente;
//    private LocalDate fechaSolicitud;
//    private  TipoTarjeta tipoTarjeta;
//    private EstadoSolicitud estado;
//
//    public SolicitudTarjeta(Cliente cliente, TipoTarjeta tipoTarjeta) {
//        this.cliente = cliente;
//        this.fechaSolicitud = LocalDate.now();
//        this.tipoTarjeta = tipoTarjeta;
//        this.estado = EstadoSolicitud.EN_PROCESO;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public LocalDate getFechaSolicitud() {
//        return fechaSolicitud;
//    }
//
//    public void setFechaSolicitud(LocalDate fechaSolicitud) {
//        this.fechaSolicitud = fechaSolicitud;
//    }
//
//    public TipoTarjeta getTipoTarjeta() {
//        return tipoTarjeta;
//    }
//
//    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
//        this.tipoTarjeta = tipoTarjeta;
//    }
//
//    public EstadoSolicitud getEstado() {
//        return estado;
//    }
//
//    public void setEstado(EstadoSolicitud estado) {
//        this.estado = estado;
//    }
//
//    public static SolicitudTarjeta solicitarSimplicity (){
//        return new SolicitudTarjeta(cliente, TipoTarjeta.SIMPLICITY);
//    }
//    public static SolicitudTarjeta solicitarPlatino(){
//        return new SolicitudTarjeta(cliente, TipoTarjeta.Platino);
//    }
//}
//

package beans;

public class beanProducto {

    private int id_Producto;
    private String nombre_producto;
    private String descripcion;
    private String image_ref;
    private int cantidad;
    private beanTipoProducto tipoProducto;
    private int precio;

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public beanTipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(beanTipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public beanProducto() {
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImage_ref() {
        return image_ref;
    }

    public void setImage_ref(String image_ref) {
        this.image_ref = image_ref;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}


package beans;


public class beanProducto 
{
    int id_Producto;
    String nombre_producto;
    String descripcion;
    String tipo_producto;
    String image_ref;
    private int cantidad;

    public beanProducto(int id_Producto, String nombre_producto, String descripcion, String tipo_producto, String image_ref) {
        this.id_Producto = id_Producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.tipo_producto = tipo_producto;
        this.image_ref = image_ref;
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

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
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

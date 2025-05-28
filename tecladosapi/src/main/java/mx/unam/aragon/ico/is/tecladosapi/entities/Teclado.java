package mx.unam.aragon.ico.is.tecladosapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "teclados")
public class Teclado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long clave;

    @Column(name = "marca_teclado", nullable = false, length = 30)
    @NotBlank(message = "no se aceptan datos vacios")
    @NotNull(message = "no se aceptan nulos")
    private String marca;

    @Column(name = "modelo_teclado", nullable = false, length = 50)
    @NotBlank(message = "no se aceptan datos vacios")
    @NotNull(message = "no se aceptan nulos")
    private String modelo;

    @Column(name = "idioma_iso", length = 10)
    private String idioma;

    @Column(name = "tipo_teclado", nullable = false, length = 15)
    private String tipo;

    @Column(name = "precio_pesos",  nullable = false)
    @NotNull(message = "no se aceptan nulos")
    private Float precio;

    @Column(name = "url_imagen",insertable = false, columnDefinition = "VARCHAR(250) DEFAULT 'https://extensions.typo3.org/typo3temp/assets/tx_terfe2/images/placeholder_images_1.1.0.png'")
    private String imagen;

    public Teclado() {
    }

    public Teclado(Long clave, String marca, String modelo, String idioma, String tipo, Float precio, String imagen) {
        this.clave = clave;
        this.marca = marca;
        this.modelo = modelo;
        this.idioma = idioma;
        this.tipo = tipo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teclado teclado = (Teclado) o;
        return Objects.equals(clave, teclado.clave) && Objects.equals(marca, teclado.marca) && Objects.equals(modelo, teclado.modelo) && Objects.equals(idioma, teclado.idioma) && Objects.equals(tipo, teclado.tipo) && Objects.equals(precio, teclado.precio) && Objects.equals(imagen, teclado.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, marca, modelo, idioma, tipo, precio, imagen);
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "clave=" + clave +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}

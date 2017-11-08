/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nuria
 */
public class Coche {

    String nombre;
    String telefono;
    String model;
    String color;
    String opciones;

    public Coche() {

    }

    public Integer PrecioModelosCoche(String modelo) {
        String[] modeloscoches = {"Altea 1.4 TSI 125CV (92 kw) Arena, Altea 1.9 TDI 105CV (77 kw) Arena", "Altea 1.9 TDI 105CV (77 kw) DPF DSG Arena", "Altea 2.0 TDI 140CV (103 kw) 6 Vel. Arena", "Altea 2.0 TDI 16V 140CV (103 kw) 6 Vel. DSG Arena"};
        Integer[] modeloscochesprecio = {21452, 22299, 24137, 24274, 25741};
        int i = 0;
        for (i = 0; i < modeloscoches.length; i++) {
            if (modeloscoches[i].equals(modelo)) {
                System.out.println("El precio del modelo: " + modelo + " es: " + modeloscochesprecio[i]);
                break;
            }
        }
        return modeloscochesprecio[i];
    }

    public Integer precioCheck(String colores) {
        String[] checkcoches = {"Instalación teléfono Bluettoth + MP3 + antena antirrobo", "Conexión USB en apoyabrazos", "Conexión iPod en apoyabrazos", "Portaobjetos interior en techo con pantalla TFT 7 y conectores RCA" , "Portaobjetos interior en techo"
         , "Asientos calefactados + eyectores calefactados + lavafaros + montante A calefectado" , "Sistema navegación blanco y negro + MP3 + antena antirrobo" , "SEAT Mediasystem: Sistema de navegación dinámica con pantalla táctil a color de 6,5, lector DVD, disco duro de 30GB, conectividad Bluetooth y mandos en el volante", 
         "Airbags laterales posteriores" , "Faros Bixenon + AFS"};
        Integer[] checkcochesprecio = {276, 100, 100, 369, 98, 581, 1070, 1465, 253, 835};
        int i = 0;
        for (i = 0; i < checkcoches.length; i++) {
            if (checkcoches[i].equals(colores)) {
                
                break;
            }
        }
        return checkcochesprecio[i];
    }
    
      public Integer precioColores(String check) {
        String[] colorescoches = {"Blanco Candy", "Rojo emocion", "Gris zenith", "Negro magico", "Rojo rubi", "Verde natura"};
        Integer[] colorescochesprecio = {0, 152, 400, 400, 400, 400};
        int i = 0;
        for (i = 0; i < colorescoches.length; i++) {
            if (colorescoches[i].equals(check)) {
                
                break;
            }
        }
        return colorescochesprecio[i];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return telefono;
    }

    public void setApellido(String telefono) {
        this.telefono = telefono;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

}

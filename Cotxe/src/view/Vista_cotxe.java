/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.Coche;

/**
 *
 * @author nuria
 */
public class Vista_cotxe extends javax.swing.JFrame {

    private Coche mycoche = new Coche();

    /**
     * Creates new form Vista_cotxe
     */
    public Vista_cotxe() {
        initComponents();

    }

    public void validacion() {

        if (this.jt_nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre ha de estar informado");

        } else if (this.jt_telefono.getText().isEmpty() || (this.jt_telefono.getText().length() != 9)) {
            JOptionPane.showMessageDialog(null, "El teléfono ha de estar informado,debe ser entero o tener 9 digitos ");
            try {
                Integer i = Integer.parseInt(this.jt_telefono.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Inserte un numero no decimal");
                this.jt_telefono.setText("");
            }

        } else if (!this.jr_blanco.isSelected() && !this.jr_gris.isSelected() && !this.jr_negro.isSelected() && !this.jr_rojor.isSelected() && !this.jr_verde.isSelected() && !this.jr_rojo.isSelected()) {
            JOptionPane.showMessageDialog(null, "Debe estar uno seleccionado");

        } else if (!this.jr_blanco.isSelected() && !this.jc_check1.isSelected() && !this.jc_check2.isSelected() && !this.jc_check3.isSelected() && !this.jc_check4.isSelected() && !this.jc_check5.isSelected() && !this.jc_check5.isSelected()
                && !this.jc_check6.isSelected() && !this.jc_check7.isSelected() && !this.jc_check8.isSelected() && !this.jc_check9.isSelected() && !this.jc_check10.isSelected()) {
            JOptionPane.showMessageDialog(null, "Debe estar uno seleccionado");

        } else {

            this.jt_detalles.setText("El nombre es: " + this.jt_nombre.getText() + "\n" + "El teléfono es: " + this.jt_telefono.getText() + "\n");
            this.jt_detalles.append("El modelo es: " + (String) this.jc_modelo.getSelectedItem() + " El precio es: " + mycoche.PrecioModelosCoche((String) this.jc_modelo.getSelectedItem()) + "\n");
            this.jt_detalles.append("El precio total es: " + (mycoche.PrecioModelosCoche((String) this.jc_modelo.getSelectedItem()) + this.ColoresCoche(jPanel7) + this.CheckboxCoche(jPanel8)));

        }

    }

    public Integer ColoresCoche(javax.swing.JPanel p) {

        Component[] componentes = p.getComponents();
        Integer precio = 0;
        for (Component a : componentes) //for(int i=0; i<componentes.length;i++) 
        {
//if(componentes[i] instanceof JCheckBox) 
            if (a instanceof JRadioButton) {
                //JCheckBox ok=(JCheckBox)componentes[i];
                boolean ok1 = ((JRadioButton) a).isSelected();
                JRadioButton ok = (JRadioButton) a;
                System.out.println(ok.getText());
                if (ok.isSelected()) {

                    precio = mycoche.precioColores(ok.getText());
                    this.jt_detalles.append("El color es " + ok.getText() + " El precio es : " + mycoche.precioColores(ok.getText()) + "\n");
                }

            }
        }
        return precio;
    }

    public Integer CheckboxCoche(javax.swing.JPanel p) {

        Component[] componentes = p.getComponents();
        Integer precioC = 0;
        for (Component a : componentes) //for(int i=0; i<componentes.length;i++) 
        {
//if(componentes[i] instanceof JCheckBox) 
            if (a instanceof JCheckBox) {
                //JCheckBox ok=(JCheckBox)componentes[i];
                boolean ok1 = ((JCheckBox) a).isSelected();
                JCheckBox ok = (JCheckBox) a;
                if (ok.isSelected()) {
                    precioC = mycoche.precioCheck(ok.getText());
                    this.jt_detalles.append("Has seleccionado " + ok.getText() + " El precio es : " + mycoche.precioCheck(ok.getText()) + "\n");
                }

            }
        }
        return precioC;
    }

    public void guardar() {
        String comando = "cmd /c  break > c:\\carpetajava\\file.txt";
        Process pr;
        try {
            pr = Runtime.getRuntime().exec(comando);
            //System.out.println(comando);
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error al ejecutar el comando. Error: " + ex);
        }

        try {
            //codejavu ejemplo de filechoser
            //
            this.jt_detalles.write(new FileWriter("c:\\carpetajava\\file.txt"));
        } catch (Exception ex) {
            System.out.println("Error");
        }

    }

    public void escribir2() {

        try {
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(guarda + ".txt");
                // BufferedWriter bw = new BufferedWriter(save); 
                String p = jt_detalles.getText();

                System.out.println(p);
                String[] lineas = p.split("\n");
                System.out.println("Texto original:\n" + p);
                System.out.println("Texto modificado:\n");
                for (int i = 0; i < lineas.length; i++) {

                    save.write(lineas[i]);
                    save.write(System.getProperty("line.separator"));
                }
                save.write(jt_detalles.getText());
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bg_colors = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jt_nombre = new javax.swing.JTextField();
        jt_telefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jb_generar = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jc_modelo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jb_nuevo = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jr_blanco = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jr_rojo = new javax.swing.JRadioButton();
        jr_gris = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jr_verde = new javax.swing.JRadioButton();
        jr_rojor = new javax.swing.JRadioButton();
        jr_negro = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jc_check1 = new javax.swing.JCheckBox();
        jc_check2 = new javax.swing.JCheckBox();
        jc_check3 = new javax.swing.JCheckBox();
        jc_check4 = new javax.swing.JCheckBox();
        jc_check5 = new javax.swing.JCheckBox();
        jc_check6 = new javax.swing.JCheckBox();
        jc_check7 = new javax.swing.JCheckBox();
        jc_check8 = new javax.swing.JCheckBox();
        jc_check9 = new javax.swing.JCheckBox();
        jc_check10 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_detalles = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_fichero = new javax.swing.JMenu();
        jm_generar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jm_guardar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jb_guardarcomo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jm_nuevo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jm_salir = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem4.setText("jMenuItem4");

        jMenu4.setText("jMenu4");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jt_nombre.setToolTipText("Aquí debes ingresar tu nombre");
        jt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_nombreActionPerformed(evt);
            }
        });

        jt_telefono.setToolTipText("Aquí debes ingresar el teléfono ");
        jt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_telefonoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre :");

        jLabel2.setText("Telèfon :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Configuración modelo de coche");

        jb_generar.setText("Generar");
        jb_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_generarActionPerformed(evt);
            }
        });

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jc_modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Altea 1.4 TSI 125CV (92 kw) Arena", "Altea 1.9 TDI 105CV (77 kw) Arena", "Altea 1.9 TDI 105CV (77 kw) DPF DSG Arena", "Altea 2.0 TDI 140CV (103 kw) 6 Vel. Arena", "Altea 2.0 TDI 16V 140CV (103 kw) 6 Vel. DSG Arena" }));
        jc_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_modeloActionPerformed(evt);
            }
        });

        jLabel4.setText("Modelo");

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        Bg_colors.add(jr_blanco);
        jr_blanco.setText("Blanco Candy");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        Bg_colors.add(jr_rojo);
        jr_rojo.setText("Rojo emocion");
        jr_rojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_rojoActionPerformed(evt);
            }
        });

        Bg_colors.add(jr_gris);
        jr_gris.setText("Gris zenith");
        jr_gris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_grisActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        Bg_colors.add(jr_verde);
        jr_verde.setText("Verde natura");

        Bg_colors.add(jr_rojor);
        jr_rojor.setText("Rojo rubi");
        jr_rojor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_rojorActionPerformed(evt);
            }
        });

        Bg_colors.add(jr_negro);
        jr_negro.setText("Negro magico");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jr_blanco)
                            .addComponent(jr_rojo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jr_gris))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jr_negro)
                    .addComponent(jr_rojor)
                    .addComponent(jr_verde))
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jr_blanco)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jr_rojo))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jr_gris))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jr_negro)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jr_rojor)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jr_verde))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jc_check1.setText("Instalación teléfono Bluettoth + MP3 + antena antirrobo");
        jc_check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_check1ActionPerformed(evt);
            }
        });

        jc_check2.setText("Conexión USB en apoyabrazos");

        jc_check3.setText("Conexión iPod en apoyabrazos");

        jc_check4.setText("Portaobjetos interior en techo con pantalla TFT 7 y conectores RCA");
        jc_check4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_check4ActionPerformed(evt);
            }
        });

        jc_check5.setText("Portaobjetos interior en techo");

        jc_check6.setText("Asientos calefactados + eyectores calefactados + lavafaros + montante A calefectado");
        jc_check6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_check6ActionPerformed(evt);
            }
        });

        jc_check7.setText("Sistema navegación blanco y negro + MP3 + antena antirrobo");

        jc_check8.setText("SEAT Mediasystem: Sistema de navegación dinámica con pantalla táctil a color de 6,5, lector DVD, disco duro de 30GB, conectividad Bluetooth y mandos en el volante");

        jc_check9.setText("Airbags laterales posteriores");

        jc_check10.setText("Faros Bixenon + AFS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jc_check4)
                    .addComponent(jc_check3))
                .addContainerGap(576, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jc_check8)
                        .addComponent(jc_check7)
                        .addComponent(jc_check5)
                        .addComponent(jc_check10)
                        .addComponent(jc_check9)
                        .addComponent(jc_check2)
                        .addComponent(jc_check1)
                        .addComponent(jc_check6))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jc_check3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jc_check4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jc_check1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jc_check2)
                    .addGap(55, 55, 55)
                    .addComponent(jc_check5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jc_check6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jc_check7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jc_check8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jc_check9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jc_check10)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jt_detalles.setColumns(20);
        jt_detalles.setRows(5);
        jScrollPane1.setViewportView(jt_detalles);

        jm_fichero.setText("Fichero");

        jm_generar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jm_generar.setText("Generar");
        jm_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_generarActionPerformed(evt);
            }
        });
        jm_fichero.add(jm_generar);
        jm_fichero.add(jSeparator1);

        jm_guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jm_guardar.setText("Guardar");
        jm_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_guardarActionPerformed(evt);
            }
        });
        jm_fichero.add(jm_guardar);
        jm_fichero.add(jSeparator2);

        jb_guardarcomo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jb_guardarcomo.setText("Guardar como");
        jb_guardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarcomoActionPerformed(evt);
            }
        });
        jm_fichero.add(jb_guardarcomo);
        jm_fichero.add(jSeparator6);

        jm_nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jm_nuevo.setText("Nuevo");
        jm_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_nuevoActionPerformed(evt);
            }
        });
        jm_fichero.add(jm_nuevo);
        jm_fichero.add(jSeparator3);

        jm_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jm_salir.setText("Salir");
        jm_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_salirActionPerformed(evt);
            }
        });
        jm_fichero.add(jm_salir);
        jm_fichero.add(jSeparator5);

        jMenuBar1.add(jm_fichero);

        jMenu3.setText("Ayuda");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jb_generar)
                        .addGap(61, 61, 61)
                        .addComponent(jb_guardar)
                        .addGap(113, 113, 113)
                        .addComponent(jb_nuevo)
                        .addGap(68, 68, 68)
                        .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jc_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jt_telefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                            .addComponent(jt_nombre, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(46, 46, 46)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))))
                                .addGap(78, 78, 78)
                                .addComponent(jLabel4)))
                        .addGap(23, 23, 23)
                        .addComponent(jc_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_generar)
                    .addComponent(jb_guardar)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_nombreActionPerformed

    private void jt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_telefonoActionPerformed

    private void jc_check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_check1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_check1ActionPerformed

    private void jr_rojorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_rojorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jr_rojorActionPerformed

    private void jb_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_generarActionPerformed
        // TODO add your handling code here:

        try {
            validacion();

        } catch (Exception e) {
        }


    }//GEN-LAST:event_jb_generarActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        // TODO add your handling code here:

        validacion();
        guardar();


    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jr_rojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_rojoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jr_rojoActionPerformed

    private void jc_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_modeloActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        // TODO add your handling code here:
        this.jt_detalles.setText("");
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jr_grisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_grisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jr_grisActionPerformed

    private void jc_check6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_check6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_check6ActionPerformed

    private void jc_check4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_check4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_check4ActionPerformed

    private void jm_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_generarActionPerformed
        // TODO add your handling code here:
        validacion();

    }//GEN-LAST:event_jm_generarActionPerformed

    private void jm_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_guardarActionPerformed
        // TODO add your handling code here:
        validacion();
        guardar();
    }//GEN-LAST:event_jm_guardarActionPerformed

    private void jm_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_nuevoActionPerformed
        // TODO add your handling code here:
        this.jt_detalles.setText("");

    }//GEN-LAST:event_jm_nuevoActionPerformed

    private void jm_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jm_salirActionPerformed

    private void jb_guardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarcomoActionPerformed
        // TODO add your handling code here:
        validacion();
        escribir2();
    }//GEN-LAST:event_jb_guardarcomoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_cotxe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_cotxe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_cotxe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_cotxe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_cotxe().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Bg_colors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JButton jb_generar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JMenuItem jb_guardarcomo;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_salir;
    private javax.swing.JCheckBox jc_check1;
    private javax.swing.JCheckBox jc_check10;
    private javax.swing.JCheckBox jc_check2;
    private javax.swing.JCheckBox jc_check3;
    private javax.swing.JCheckBox jc_check4;
    private javax.swing.JCheckBox jc_check5;
    private javax.swing.JCheckBox jc_check6;
    private javax.swing.JCheckBox jc_check7;
    private javax.swing.JCheckBox jc_check8;
    private javax.swing.JCheckBox jc_check9;
    private javax.swing.JComboBox<String> jc_modelo;
    private javax.swing.JMenu jm_fichero;
    private javax.swing.JMenuItem jm_generar;
    private javax.swing.JMenuItem jm_guardar;
    private javax.swing.JMenuItem jm_nuevo;
    private javax.swing.JMenuItem jm_salir;
    private javax.swing.JRadioButton jr_blanco;
    private javax.swing.JRadioButton jr_gris;
    private javax.swing.JRadioButton jr_negro;
    private javax.swing.JRadioButton jr_rojo;
    private javax.swing.JRadioButton jr_rojor;
    private javax.swing.JRadioButton jr_verde;
    private javax.swing.JTextArea jt_detalles;
    private javax.swing.JTextField jt_nombre;
    private javax.swing.JTextField jt_telefono;
    // End of variables declaration//GEN-END:variables
}

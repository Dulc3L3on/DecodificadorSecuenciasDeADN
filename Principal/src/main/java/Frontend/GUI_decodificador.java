/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.ListaEnlazada;
import Backend.Nodo;
import Backend.Procesador;

/**
 *
 * @author phily
 */
public class GUI_decodificador extends javax.swing.JFrame {
    Procesador procesador;
    ListaEnlazada<String> coincidencias;
    Informativo menuInformativo= new Informativo(new javax.swing.JFrame(), true);
    
    /**
     * Creates new form GUI_decodificador
     */
    public GUI_decodificador() {
        initComponents();
        procesador= new Procesador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtF_secuencia1 = new javax.swing.JTextField();
        txtF_secuencia2 = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_pantalla = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(612, 462));
        setMinimumSize(new java.awt.Dimension(612, 462));
        setPreferredSize(new java.awt.Dimension(612, 462));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(157, 171, 179));
        jPanel1.setMaximumSize(new java.awt.Dimension(612, 432));
        jPanel1.setPreferredSize(new java.awt.Dimension(612, 462));

        jLabel1.setBackground(new java.awt.Color(62, 106, 130));
        jLabel1.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 194, 194));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<<DECODIFICADOR DE ADN>>");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Waree", 0, 15)); // NOI18N
        jLabel2.setText("Primer Secuencia:");

        jLabel3.setFont(new java.awt.Font("Waree", 0, 15)); // NOI18N
        jLabel3.setText("Segunda Secuencia:");

        txtF_secuencia1.setFont(new java.awt.Font("Sawasdee", 0, 13)); // NOI18N
        txtF_secuencia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtF_secuencia1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF_secuencia1KeyReleased(evt);
            }
        });

        txtF_secuencia2.setFont(new java.awt.Font("Sawasdee", 0, 13)); // NOI18N
        txtF_secuencia2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        txtA_pantalla.setEditable(false);
        txtA_pantalla.setColumns(20);
        txtA_pantalla.setFont(new java.awt.Font("Sawasdee", 0, 17)); // NOI18N
        txtA_pantalla.setRows(5);
        jScrollPane1.setViewportView(txtA_pantalla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtF_secuencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_secuencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtF_secuencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtF_secuencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Informacion de Uso");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtF_secuencia1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF_secuencia1KeyPressed

    }//GEN-LAST:event_txtF_secuencia1KeyPressed

    private void txtF_secuencia1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF_secuencia1KeyReleased

    }//GEN-LAST:event_txtF_secuencia1KeyReleased

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String cadenas[]= new String[2];
        cadenas[0]=txtF_secuencia1.getText();
        cadenas[1]=txtF_secuencia2.getText();

        coincidencias=procesador.decodificarADN(cadenas);
        mostrarResultados(coincidencias);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        menuInformativo.setLocationRelativeTo(null);
        menuInformativo.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

     public void mostrarResultados(ListaEnlazada<String> coincidecias){
        String mensaje;
        txtA_pantalla.removeAll();
        
        
         if(coincidecias.estaVacia()){
             mensaje="\nLos seres estudiados son COMPLETAMENTE DIFERENTES en su anatomía";
             txtA_pantalla.setText(mensaje);
        }else{
            if(coincidecias.darTamanio()==1){
                mensaje="El conjunto: "+coincidecias.obtnerPrimerNodo().contenido+ " ha sido encontrado en ambos seres";                
                txtA_pantalla.setText(mensaje);
                
            }else{//es decir es mayor... pues arriba se contempla cuando es 0
                Nodo<String> auxiliar= coincidecias.obtnerPrimerNodo();
                
                mensaje=" El primer conjunto de coincidencias hallado fue: "+ auxiliar.contenido+"\n";
                mensaje+="\n-> Demás coincidencias";                
                auxiliar=auxiliar.nodoSiguiente;
                
                do{
                   mensaje+="  \n "+ auxiliar.contenido;
                    auxiliar=auxiliar.nodoSiguiente;
                }while(auxiliar!=null);
                
                txtA_pantalla.setText(mensaje);
            }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtA_pantalla;
    private javax.swing.JTextField txtF_secuencia1;
    private javax.swing.JTextField txtF_secuencia2;
    // End of variables declaration//GEN-END:variables
}

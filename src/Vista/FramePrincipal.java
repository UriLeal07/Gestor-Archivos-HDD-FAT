package Vista;

import Modelo.Archivo;
import Modelo.Sistema;
import java.awt.Font;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal extends javax.swing.JFrame
{
    private Sistema system;
    private FrameAcerca frmAcerca;
    private final JFileChooser selectorDeArchivo;
    private String nombreArchivoActual;
    private boolean click, actualizarArchivo, archivoGuardado;
    private final Object[] columnasArch = {"Nombre de Archivo", "Bloques en Uso"};
    private final Object[] columnasFAT = {"FAT", "Bloque #"};
    private final Object[] columnasHDD = {"Disco Duro", "Bloque #"};
    
    public FramePrincipal()
    {
        initComponents();
        
        URL iconURL = getClass().getResource("/Icons/appIcon.png");
        
        if(iconURL != null)
        {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        }
        setTitle("Sistema Gestor de Archivos");
        system = new Sistema();
        selectorDeArchivo = new JFileChooser();
        selectorDeArchivo.setFileFilter(new FileNameExtensionFilter("Archivos de Texto", "txt"));
        selectorDeArchivo.setMultiSelectionEnabled(false);
        selectorDeArchivo.setDialogTitle("Seleccione el Archivo");
        selectorDeArchivo.setDialogType(JFileChooser.OPEN_DIALOG);
        visorTxt.setEditable(false);
        nombreArchivoActual = null;
        frmAcerca = null;
        click = actualizarArchivo = archivoGuardado = false;
        limpiarDirectorio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneHDD = new javax.swing.JScrollPane();
        tablaHDD = new javax.swing.JTable();
        scrollPaneFAT = new javax.swing.JScrollPane();
        tablaFAT = new javax.swing.JTable();
        scrollPaneDir = new javax.swing.JScrollPane();
        tablaDir = new javax.swing.JTable();
        scrollPaneVisorTxt = new javax.swing.JScrollPane();
        visorTxt = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lbNotificaciones = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cleanButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemCrearArch = new javax.swing.JMenuItem();
        menuItemLeerArch = new javax.swing.JMenuItem();
        menuItemModifArch = new javax.swing.JMenuItem();
        menuItemDeleteArch = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemClean = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaHDD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaHDD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Disco Duro", "Bloque #"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHDD.setGridColor(new java.awt.Color(0, 0, 0));
        tablaHDD.setInheritsPopupMenu(true);
        scrollPaneHDD.setViewportView(tablaHDD);

        tablaFAT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaFAT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "FAT", "Bloque #"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFAT.setGridColor(new java.awt.Color(0, 0, 0));
        scrollPaneFAT.setViewportView(tablaFAT);

        tablaDir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaDir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {"", null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre de Archivo", "Bloques en uso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDir.setGridColor(new java.awt.Color(0, 0, 0));
        scrollPaneDir.setViewportView(tablaDir);

        scrollPaneVisorTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        visorTxt.setColumns(20);
        visorTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        visorTxt.setRows(5);
        visorTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                visorTxtMousePressed(evt);
            }
        });
        scrollPaneVisorTxt.setViewportView(visorTxt);

        lbNotificaciones.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N
        saveButton.setText("Guardar Archivo");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cleanButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cleanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clear.png"))); // NOI18N
        cleanButton.setText("Borrar Contenido");
        cleanButton.setEnabled(false);
        cleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        deleteButton.setText("Eliminar Archivo");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cleanButton, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cleanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setText("Menú");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menuItemCrearArch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItemCrearArch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemCrearArch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        menuItemCrearArch.setText("Crear Archivo");
        menuItemCrearArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearArchActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCrearArch);

        menuItemLeerArch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemLeerArch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemLeerArch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/file.png"))); // NOI18N
        menuItemLeerArch.setText("Leer Archivo");
        menuItemLeerArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLeerArchActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLeerArch);

        menuItemModifArch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemModifArch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemModifArch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/autorenew.png"))); // NOI18N
        menuItemModifArch.setText("Modificar Archivo");
        menuItemModifArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemModifArchActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemModifArch);

        menuItemDeleteArch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuItemDeleteArch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemDeleteArch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/remove.png"))); // NOI18N
        menuItemDeleteArch.setText("Eliminar Archivo");
        menuItemDeleteArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeleteArchActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemDeleteArch);

        menuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save_small.png"))); // NOI18N
        menuItemSave.setText("Guardar Archivo");
        menuItemSave.setEnabled(false);
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSave);

        menuItemClean.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuItemClean.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clear_small.png"))); // NOI18N
        menuItemClean.setText("Borrar Contenido");
        menuItemClean.setEnabled(false);
        menuItemClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCleanActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemClean);

        menuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit.png"))); // NOI18N
        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menuItemAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuItemAcercaDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/help.png"))); // NOI18N
        menuItemAcercaDe.setText("Acerca de");
        menuItemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAcercaDeActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAcercaDe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneVisorTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPaneHDD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(scrollPaneFAT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(scrollPaneDir, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneDir, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneHDD, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneFAT, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addComponent(scrollPaneVisorTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCrearArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearArchActionPerformed
        
        click = false;
        actualizarArchivo = false;
        scrollPaneVisorTxt.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "\"Sin Nombre.txt\""));
        visorTxt.setText("Escribe aqui.");
        visorTxt.setEditable(true);
        cleanButton.setEnabled(true);
        deleteButton.setEnabled(false);
        saveButton.setEnabled(true);
        menuItemSave.setEnabled(true);
        menuItemClean.setEnabled(true);
        lbNotificaciones.setText("Operacion completa.");
        
    }//GEN-LAST:event_menuItemCrearArchActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        limpiarDirectorio();
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemLeerArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLeerArchActionPerformed
        
        selectorDeArchivo.setCurrentDirectory(system.getDirectorioRaiz());
        int res = selectorDeArchivo.showOpenDialog(null);
        
        if(res == JFileChooser.APPROVE_OPTION)
        {
            File archivo = selectorDeArchivo.getSelectedFile().getAbsoluteFile();
            
            if(archivo.getName().endsWith("txt"))
            {
                if(system.existeArchivo(archivo.getName()))
                {
                    visorTxt.setEditable(false);
                    cleanButton.setEnabled(false);
                    deleteButton.setEnabled(true);
                    saveButton.setEnabled(false);
                    menuItemSave.setEnabled(false);
                    menuItemClean.setEnabled(false);
                    nombreArchivoActual = archivo.getName();
                    visorTxt.setText(system.leerFile(archivo));
                    scrollPaneVisorTxt.setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "\""+nombreArchivoActual+"\""));
                    lbNotificaciones.setText(archivo.length()+" bytes leidos de \""+nombreArchivoActual+"\"");
                }
                
                else
                    JOptionPane.showMessageDialog(null,
                                          "El archivo seleccionado no existe en el disco duro.",
                                          "Archivo Inexistente", JOptionPane.ERROR_MESSAGE);
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,
                                          "Solo se admiten archivos .txt",
                                          "Error de compatibilidad", JOptionPane.ERROR_MESSAGE);
                
                lbNotificaciones.setText("Error de lectura.");
            }
        }
        
        else if(res == JFileChooser.ERROR_OPTION)
            JOptionPane.showMessageDialog(null,
                                          "Ocurrio un problema al seleccionar archivo",
                                          "Error de JFileChooser", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_menuItemLeerArchActionPerformed

    private void menuItemModifArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemModifArchActionPerformed
         
        selectorDeArchivo.setCurrentDirectory(system.getDirectorioRaiz());
        int res = selectorDeArchivo.showOpenDialog(null);
        
        if(res == JFileChooser.APPROVE_OPTION)
        {
            File archivo = selectorDeArchivo.getSelectedFile().getAbsoluteFile();
            
            if(archivo.getName().endsWith("txt"))
            {
                actualizarArchivo = true;
                visorTxt.setEditable(true);
                cleanButton.setEnabled(true);
                deleteButton.setEnabled(true);
                saveButton.setEnabled(true);
                menuItemSave.setEnabled(true);
                menuItemClean.setEnabled(true);
                
                nombreArchivoActual = archivo.getName();
                visorTxt.setText(system.leerFile(archivo));
                scrollPaneVisorTxt.setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "\""+nombreArchivoActual+"\""));
                lbNotificaciones.setText(archivo.length()+" bytes leidos de \""+nombreArchivoActual+"\"");
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,
                                          "Solo se admiten archivos .txt",
                                          "Error de compatibilidad", JOptionPane.ERROR_MESSAGE);
                
                lbNotificaciones.setText("Error de lectura.");
            }
        }
        
        else if(res == JFileChooser.ERROR_OPTION)
            JOptionPane.showMessageDialog(null,
                                          "Ocurrio un problema al seleccionar archivo",
                                          "Error de JFileChooser", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_menuItemModifArchActionPerformed

    private void menuItemDeleteArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeleteArchActionPerformed
        
        cleanButton.setEnabled(false);
        deleteButton.setEnabled(false);
        saveButton.setEnabled(false);
        menuItemSave.setEnabled(false);
        menuItemClean.setEnabled(false);
        
        selectorDeArchivo.setCurrentDirectory(system.getDirectorioRaiz());
        int res = selectorDeArchivo.showOpenDialog(null);
        
        if(res == JFileChooser.APPROVE_OPTION)
        {
            File archivo = selectorDeArchivo.getSelectedFile().getAbsoluteFile();
            
            if(archivo.getName().endsWith("txt"))
            {
                if(system.eliminarFile(archivo))
                {
                    JOptionPane.showMessageDialog(null,
                                                  "Archivo eliminado exitosamente.",
                                                  "Operación Completa", JOptionPane.INFORMATION_MESSAGE);
                    actualizarTablas();
                }
            
                else
                    JOptionPane.showMessageDialog(null,
                                                  "Archivo no encontrado.",
                                                  "Operación Completa", JOptionPane.WARNING_MESSAGE);
            }
            
            else
                JOptionPane.showMessageDialog(null,
                                              "Solo se admiten archivos .txt",
                                              "Error de compatibilidad", JOptionPane.ERROR_MESSAGE);
        }
        
        else if(res == JFileChooser.ERROR_OPTION)
            JOptionPane.showMessageDialog(null,
                                          "Ocurrio un problema al seleccionar archivo",
                                          "Error de Seleccion", JOptionPane.ERROR_MESSAGE);
        
        lbNotificaciones.setText("Operacion completada.");
    }//GEN-LAST:event_menuItemDeleteArchActionPerformed

    private void visorTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visorTxtMousePressed
        
        if(!click)
        {
            visorTxt.setText("");
            click = true;
        }
    }//GEN-LAST:event_visorTxtMousePressed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        if(nombreArchivoActual != null)
        {
            if(system.eliminarFile(system.getFile(nombreArchivoActual)))
            {
                actualizarTablas();
                limpiarArea();
                lbNotificaciones.setText("Archivo eliminado.");
                JOptionPane.showMessageDialog(null,
                    "Archivo eliminado exitosamente.",
                    "Operación Completa", JOptionPane.INFORMATION_MESSAGE);
            }

            else
            {
                JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado.",
                    "Operación Completa", JOptionPane.WARNING_MESSAGE);
                lbNotificaciones.setText("Archivo no eliminado.");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanButtonActionPerformed
        limpiarArea();
    }//GEN-LAST:event_cleanButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void menuItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAcercaDeActionPerformed
        frmAcerca = new FrameAcerca();
        frmAcerca.setVisible(true);
    }//GEN-LAST:event_menuItemAcercaDeActionPerformed

    private void menuItemCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCleanActionPerformed
        limpiarArea();
    }//GEN-LAST:event_menuItemCleanActionPerformed

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        save();
    }//GEN-LAST:event_menuItemSaveActionPerformed

    private void limpiarDirectorio()
    {
        File[] files = system.getDirectorioRaiz().listFiles();
        
        for(int i = 0; i < files.length; i++)
            if(files[i] != null)
                files[i].delete();
    }
    
    private void limpiarArea()
    {
        visorTxt.setText("");
        lbNotificaciones.setText("");
        scrollPaneVisorTxt.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), " "));
    }
    
    private void save()
    {
        // Si se va a crear un archivo nuevo.
        if(!actualizarArchivo)
        {
            nombreArchivoActual = JOptionPane.showInputDialog(this, "Introduce el nombre del archivo:", "Nuevo Archivo", JOptionPane.QUESTION_MESSAGE);
            
            if(nombreArchivoActual != null)
            {
                if(nombreArchivoActual.equals(""))
                JOptionPane.showMessageDialog(null,
                    "Ingrese un nombre valido al archivo.",
                    "Nombre de archivo vacio", JOptionPane.WARNING_MESSAGE);
                else
                {
                    // Nos aseguramos que sea archivo de texto plano (.txt)
                    if(!nombreArchivoActual.endsWith(".txt"))
                    nombreArchivoActual += ".txt";

                    if(system.agregarArchivo(new Archivo(new File(system.getDirectorioRaiz()+"/"+nombreArchivoActual), visorTxt.getText())))
                    {
                        deleteButton.setEnabled(false);
                        actualizarTablas();
                        scrollPaneVisorTxt.setBorder(BorderFactory.createTitledBorder(
                            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "\""+nombreArchivoActual+"\""));
                        lbNotificaciones.setText("Archivo "+nombreArchivoActual+" creado.");
                    }
                    
                    else
                        lbNotificaciones.setText("Archivo no creado.");
                }
            }
        }

        // Si se va a modificar un archivo existente.
        else
        {
            if(nombreArchivoActual != null)
            {
                File archivo = system.getFile(nombreArchivoActual);
                
                if(system.modificarArchivo(new Archivo(archivo, visorTxt.getText())))
                    lbNotificaciones.setText("Archivo no actualizado.");
                
                else
                    lbNotificaciones.setText("Archivo no actualizado.");
                
                actualizarTablas();
            }
        }
    }
    
    private void actualizarTablas()
    {
        int i = 0;
        
        Object[][] modeloDir = new Object[system.getNumArchivosEnDisco()][tablaDir.getColumnCount()];
        tablaDir.setModel(new DefaultTableModel(modeloDir, columnasArch));
        tablaDir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tablaDir.setRowHeight(20);
        ArrayList <Archivo> archivos = system.getArchivos();
        
        for(Archivo actual : archivos)
        {
            tablaDir.setValueAt(actual.getNombre(), i, 0);
            tablaDir.setValueAt(Arrays.toString(actual.getBloques()), i, 1);
            i++;
        }
        
        Object[][] modeloFAT = new Object[system.getTamMax()][tablaFAT.getColumnCount()];
        tablaFAT.setModel(new DefaultTableModel(modeloFAT, columnasFAT));
        tablaFAT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tablaFAT.setRowHeight(20);
        ArrayList <Object> bloquesFAT = system.getFAT().getBloques();
        i = 0;
        
        for(Object bloqueFAT : bloquesFAT)
        {
            tablaFAT.setValueAt(bloqueFAT.toString(), i, 0);
            tablaFAT.setValueAt(i, i, 1);
            i++;
        }
        
        Object[][] modeloHDD = new Object[system.getTamMax()][tablaHDD.getColumnCount()];
        tablaHDD.setModel(new DefaultTableModel(modeloHDD, columnasHDD));
        tablaHDD.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tablaHDD.setRowHeight(20);
        ArrayList <Object> bloquesHDD = system.getHDD().getBloques();
        i = 0;
        
        for(Object bloqueHDD : bloquesHDD)
        {
            tablaHDD.setValueAt(bloqueHDD.toString(), i, 0);
            tablaHDD.setValueAt(""+i, i, 1);
            i++;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cleanButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbNotificaciones;
    private javax.swing.JMenuItem menuItemAcercaDe;
    private javax.swing.JMenuItem menuItemClean;
    private javax.swing.JMenuItem menuItemCrearArch;
    private javax.swing.JMenuItem menuItemDeleteArch;
    private javax.swing.JMenuItem menuItemLeerArch;
    private javax.swing.JMenuItem menuItemModifArch;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane scrollPaneDir;
    private javax.swing.JScrollPane scrollPaneFAT;
    private javax.swing.JScrollPane scrollPaneHDD;
    private javax.swing.JScrollPane scrollPaneVisorTxt;
    private javax.swing.JTable tablaDir;
    private javax.swing.JTable tablaFAT;
    private javax.swing.JTable tablaHDD;
    private javax.swing.JTextArea visorTxt;
    // End of variables declaration//GEN-END:variables
}
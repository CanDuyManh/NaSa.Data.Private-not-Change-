/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.abstractDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import DAO.userDAO;
import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import mapper.userMapper;
import model.TaiKhoan;
import untility.shareHelper;
/**
 *
 * @author Admin
 */

public class qlTaiKhoan extends javax.swing.JInternalFrame {
    
    userDAO tkdao = new userDAO();
    int index = 0;
    String TenTK = "";
    JFileChooser fileChooser = new JFileChooser();
    /**
     * Creates new form qlbaihat
     */
    public qlTaiKhoan() {
        initComponents();
        tabs.setSelectedIndex(1);   
        fileChooser.setDialogTitle("Chọn Logo cho chuyên đề"); 
        System.out.println("NOPE");
    }
    void FillToTable(){
        DefaultTableModel model = (DefaultTableModel) tbtk.getModel();
        model.setRowCount(0);
        try {
             List<TaiKhoan> list = tkdao.findAll("select * from USERS");
             for(TaiKhoan x : list){
                 Object[] row = {
                  x.getTaiKhoan(),
                  x.getTenND(),
                  x.getGioiTinh(),
                  x.getVaiTro(),
                  x.getEmail()
                 };
                 model.addRow(row);
             } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void clean(){
        txttennd.setBackground(Color.white);
        txtvaitro.setBackground(Color.white);
        txttentaikhoan.setBackground(Color.white);
        txtgioitinh.setBackground(Color.white);
        txtemail.setBackground(Color.white);
    }
    void editTable(){
        clean();
        try {
            TenTK = (String) tbtk.getValueAt(this.index, 0);
            TaiKhoan model = tkdao.findOne("select * from USERS where TaiKhoan = ?",TenTK);
            txttennd.setText(model.getTenND());
            txttentaikhoan.setText(model.getTaiKhoan());
            txtvaitro.setText(model.getVaiTro());
            txtgioitinh.setText(model.getGioiTinh());
            txtemail.setText(model.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    void updateND(){
        try {
            abstractDAO.update("update USERS set TaiKhoan = ? , ten = ? , giotinh = ? ,vaitro = ?,email = ? where TaiKhoan = ? "
            ,txttentaikhoan.getText(),txttennd.getText(),txtgioitinh.getText(),txtvaitro.getText(),txtemail.getText(),TenTK);
            this.FillToTable();
            JOptionPane.showMessageDialog(this,"sửa thành công");
            tabs.setSelectedIndex(0);   
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    void deleteND(){
            String TenND = txttennd.getText();
            try {
            int mndx =  DAO.abstractDAO.query("select * from USERS where MaND = ?",new userMapper(),txttennd.getText()).get(0).getMaND();
            abstractDAO.update("delete USERS where MaND = ?",mndx);
                this.FillToTable();
                this.clean();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }
    void setModel(TaiKhoan model){
        txttennd.setText(model.getTenND());
        txtgioitinh.setText(model.getGioiTinh());
        txttentaikhoan.setText(model.getTaiKhoan());
        txtvaitro.setText(model.getVaiTro());
        txtemail.setText(model.getEmail());
        if (model.getAnh()!= null) {
            lblanh.setIcon(shareHelper.readLogo(model.getAnh()));
        }else{
            lblanh.setIcon(shareHelper.readLogo("noImage.png"));
        }
    }
    void selectImage() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            File file = fileChooser.getSelectedFile();    
            if (shareHelper.saveLogo(file)) {  
                lblanh.setIcon(shareHelper.readLogo(file.getName()));
                lblanh.setToolTipText(file.getName());
            }
        }
    }
    TaiKhoan getModel(){
        TaiKhoan tk = new TaiKhoan();
        boolean gt,vt;
        
        tk.setTaiKhoan(txttentaikhoan.getText());
        tk.setTenND(txttennd.getText());
        if(txtgioitinh.getText().equalsIgnoreCase("Nam")){
            gt = true;
        }else{
            gt = false;
        }
        if(txtvaitro.getText().equalsIgnoreCase("admin")){
            vt = true;
        }else{
            vt = false;
        }
        tk.setGioiTinh(gt);
        tk.setVaiTro(vt);
        tk.setAnh(lblanh.getToolTipText());
        return tk;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtk = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txttentaikhoan = new javax.swing.JTextField();
        txttennd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtvaitro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtgioitinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblanh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setEnabled(false);
        setVisible(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tabs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbtk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TÊN TÀI KHOẢN", "TÊN NGƯỜI DÙNG", "GIỚI TÍNH", "VAI TRÒ", "EMAIL", "ẢNH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbtk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtk);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );

        tabs.addTab("Danh Sách", new javax.swing.ImageIcon(getClass().getResource("/data/icons8_search_property_35px.png")), jPanel1); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tên Người Dùng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên Tài Khoản");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Vai Trò");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons8_update_30px.png"))); // NOI18N
        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons8_trash_can_30px.png"))); // NOI18N
        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Giới tính");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Email");

        lblanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        lblanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblanhMouseClicked(evt);
            }
        });

        jLabel3.setText("ẢNH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtvaitro)
                        .addGap(404, 404, 404))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txttentaikhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgioitinh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttennd, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(jButton4)
                                        .addGap(49, 49, 49)
                                        .addComponent(jButton5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(183, 183, 183)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(70, 70, 70)))))))
                        .addContainerGap(58, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txttennd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdnam)
                                .addComponent(rdnu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
=======
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
>>>>>>> 4150a79c52317b541a4cb44e9b65e7beb7dc1fbb
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttentaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/data/icons8_edit_35px_1.png")), jPanel2); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
<<<<<<< HEAD
        jLabel1.setText("Quản Lý Tài Khoản");
=======
        jLabel1.setText("Quản lý bài hát");
>>>>>>> 4150a79c52317b541a4cb44e9b65e7beb7dc1fbb
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbtkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtkMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tbtk.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.index >= 0) {
                this.editTable();
                tabs.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_tbtkMouseClicked
   
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        updateND();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
        deleteND();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        FillToTable();
    }//GEN-LAST:event_formInternalFrameOpened

    private void lblanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblanhMouseClicked
        // TODO add your handling code here:
        this.selectImage();
    }//GEN-LAST:event_lblanhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbtk;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtgioitinh;
    private javax.swing.JTextField txttennd;
    private javax.swing.JTextField txttentaikhoan;
    private javax.swing.JTextField txtvaitro;
    // End of variables declaration//GEN-END:variables
}

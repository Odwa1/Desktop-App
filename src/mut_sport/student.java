/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mut_sport;


import java.awt.event.KeyEvent;
import static java.lang.System.in;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cash
 */
public class student extends javax.swing.JFrame {

    /**
     * Creates new form student
     */
    public student() {
        initComponents();
                 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         this.setLocationRelativeTo(null);
    }
String residence;
String medical;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField_nextname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_Register_ = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jLabelLogin = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_surname = new javax.swing.JTextField();
        jTextField_phone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_studentnumber = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPasswordField_password = new javax.swing.JPasswordField();
        jPasswordField_confirm = new javax.swing.JPasswordField();
        jTextField_username = new javax.swing.JTextField();
        jTextField_nextofkinnumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Register");

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        jTextField_nextname.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_nextname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_nextname.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_nextname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nextnameActionPerformed(evt);
            }
        });
        jTextField_nextname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_nextnameKeyPressed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(236, 240, 241));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("next of kin name:");

        jLabel7.setBackground(new java.awt.Color(236, 240, 241));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Next of kin number:");

        jButton_Register_.setBackground(new java.awt.Color(24, 127, 240));
        jButton_Register_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_.setText("Register");
        jButton_Register_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Register_ActionPerformed(evt);
            }
        });

        jButton_cancel.setBackground(new java.awt.Color(242, 28, 19));
        jButton_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_cancel.setForeground(new java.awt.Color(255, 255, 255));
        jButton_cancel.setText("Cancel");
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogin.setText("Click here to login");
        jLabelLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(236, 240, 241));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Student number:");

        jTextField_name.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_name.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });
        jTextField_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_nameKeyReleased(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(236, 240, 241));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Surname:");

        jTextField_surname.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_surname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_surname.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_surnameActionPerformed(evt);
            }
        });
        jTextField_surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_surnameKeyPressed(evt);
            }
        });

        jTextField_phone.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_phone.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_phoneActionPerformed(evt);
            }
        });
        jTextField_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_phoneKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(236, 240, 241));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Phone:");

        jLabel11.setBackground(new java.awt.Color(236, 240, 241));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Residence:");

        jLabel12.setBackground(new java.awt.Color(236, 240, 241));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("username:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mut_sport/images/mut_logo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jTextField_studentnumber.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_studentnumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_studentnumber.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_studentnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_studentnumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_studentnumberKeyReleased(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(236, 240, 241));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("First Name:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barnard Close ", "Gale Street ", "Grand Lodge ", "Ark Royal ", "Plaza Hotel", "ShaJahan Res ", "FessiFern ", "Palmerston ", "Durban House", "Seapoint Towers", "Berea Court", "Poynton House", "Victoria Embankment", "Carmel Court", "Colonial", "Botanic Bliss" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(236, 240, 241));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(236, 240, 241));
        jLabel14.setText("password:");

        jLabel15.setBackground(new java.awt.Color(236, 240, 241));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(236, 240, 241));
        jLabel15.setText("confirmpassword:");

        jPasswordField_password.setBackground(new java.awt.Color(108, 112, 137));
        jPasswordField_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordField_password.setForeground(new java.awt.Color(228, 241, 254));

        jPasswordField_confirm.setBackground(new java.awt.Color(108, 112, 137));
        jPasswordField_confirm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordField_confirm.setForeground(new java.awt.Color(228, 241, 254));

        jTextField_username.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_username.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usernameActionPerformed(evt);
            }
        });
        jTextField_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_usernameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_usernameKeyReleased(evt);
            }
        });

        jTextField_nextofkinnumber.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_nextofkinnumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_nextofkinnumber.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_nextofkinnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nextofkinnumberActionPerformed(evt);
            }
        });
        jTextField_nextofkinnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_nextofkinnumberKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton_cancel)
                        .addGap(20, 20, 20)
                        .addComponent(jButton_Register_))
                    .addComponent(jLabelLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_studentnumber)
                    .addComponent(jTextField_surname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_nextname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_phone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_name)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField_password)
                    .addComponent(jPasswordField_confirm)
                    .addComponent(jTextField_username)
                    .addComponent(jTextField_nextofkinnumber))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_studentnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_nextname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_nextofkinnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jPasswordField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPasswordField_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Register_, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelLogin)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Register_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_ActionPerformed
        String PhoneNumber = jTextField_phone.getText();
                String studentNumber = jTextField_studentnumber.getText();

        int length = PhoneNumber.length();
         String nextofkin = jTextField_nextofkinnumber.getText();
        String name = jTextField_name.getText();
        String surname =  jTextField_surname.getText();
        String phone =  jTextField_phone.getText();
        String nextofkinname =  jTextField_nextname.getText();
        String username =  jTextField_username.getText();
        String pass = String.valueOf(jPasswordField_password.getPassword());
        String confirm = String.valueOf(jPasswordField_confirm.getPassword());
         residence = jComboBox1.getSelectedItem().toString();
         
         
          int yes_no = JOptionPane.showConfirmDialog(this, "Do you have the medical aid ?","confirm",JOptionPane.YES_NO_OPTION);
            if(studentNumber.equals("")){
            JOptionPane.showMessageDialog(null,"Insert student number");
        }
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Insert name");
        }
        else if(surname.equals("")){
            JOptionPane.showMessageDialog(null,"insert surname");
        }
        else if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"insert a phone number");
        }

        else if(nextofkinname.equals("")){
            JOptionPane.showMessageDialog(null,"Insert the next of kin name");
        }
        
        else if(nextofkin.equals("")){
            JOptionPane.showMessageDialog(null,"Insert the next of kin number");
        }

        else if(username.equals("")){
            JOptionPane.showMessageDialog(null,"Insert username");
        }
        else if(pass.equals("")){
            JOptionPane.showMessageDialog(null,"Insert password");
        }
        else if(!pass.equals(confirm)){
            JOptionPane.showMessageDialog(null,"cofirm the password");
        }

        // else if(checkusername(use)){
            // JOptionPane.showMessageDialog(null,"This username already exist");

            //}

      
        if(yes_no == JOptionPane.YES_OPTION)
    {
        medical = JOptionPane.showInputDialog("Input medical number");
    }
        if (yes_no == JOptionPane.NO_OPTION) {
    JOptionPane.showMessageDialog(null,"Thanks for response");
    medical = "No medical aid";
    }
        else{
            PreparedStatement ps;
            String query ="INSERT INTO `students`(`StudentId`, `name`, `surname`, `phone`, `residence`, `nextOfKinName`, `nextOfKinNumber`, `medicalAid`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?,?,?)";

            try {
                ps = MyConnection.getconection().prepareStatement(query);

                ps.setString(1,studentNumber);
                ps.setString(2,name);
                ps.setString(3,surname);
                ps.setString(4,phone);
                ps.setString(5,residence);
                ps.setString(6,nextofkinname);
                 ps.setString(7,nextofkin);
                ps.setString(8,medical);
                ps.setString(9,username);
                ps.setString(10,pass);
            

                if(ps.executeUpdate()> 0){

                    JOptionPane.showMessageDialog(null,"Sucessful registered");

                }
            } catch (SQLException ex) {
                Logger.getLogger(Register_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_Register_ActionPerformed

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jLabelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseClicked
        login_student lg =  new  login_student();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelLoginMouseClicked

    private void jTextField_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nameKeyPressed
        char c = evt.getKeyChar();

        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))
        {
            jTextField_name.setEditable(true);
        }
        else
        {

            jTextField_name.setEditable(false);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameKeyPressed

    private void jTextField_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nameKeyReleased

    }//GEN-LAST:event_jTextField_nameKeyReleased

    private void jTextField_surnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_surnameKeyPressed
        char c = evt.getKeyChar();

        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))
        {
            jTextField_surname.setEditable(true);
        }
        else
        {

            jTextField_surname.setEditable(false);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTextField_surnameKeyPressed

    private void jTextField_phoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_phoneKeyPressed
        String PhoneNumber = jTextField_phone.getText();
        int length = PhoneNumber.length();
        char c =evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if(length<10  ){

                jTextField_phone.setEditable(true);
            }
            else{
                jTextField_phone.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE)
            {
                jTextField_phone.setEditable(true);
            }
            else{
                jTextField_phone.setEditable(false);
            }
        }
    }//GEN-LAST:event_jTextField_phoneKeyPressed

    private void jTextField_studentnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_studentnumberKeyPressed
  String PhoneNumber = jTextField_studentnumber.getText();
        int length = PhoneNumber.length();
        char c =evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if(length<8  ){

                jTextField_studentnumber.setEditable(true);
            }
            else{
                jTextField_studentnumber.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE)
            {
                jTextField_studentnumber.setEditable(true);
            }
            else{
                jTextField_studentnumber.setEditable(false);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_studentnumberKeyPressed

    private void jTextField_studentnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_studentnumberKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_studentnumberKeyReleased

    private void jTextField_nextnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nextnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nextnameActionPerformed

    private void jTextField_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_phoneActionPerformed

    private void jTextField_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_surnameActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jTextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameActionPerformed

    private void jTextField_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_usernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameKeyPressed

    private void jTextField_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_usernameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameKeyReleased

    private void jTextField_nextofkinnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nextofkinnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nextofkinnumberActionPerformed

    private void jTextField_nextofkinnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nextofkinnumberKeyPressed
   String PhoneNumber = jTextField_nextofkinnumber.getText();
        int length = PhoneNumber.length();
        char c =evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if(length<10  ){

                jTextField_nextofkinnumber.setEditable(true);
            }
            else{
                jTextField_nextofkinnumber.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE)
            {
                jTextField_nextofkinnumber.setEditable(true);
            }
            else{
                jTextField_nextofkinnumber.setEditable(false);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nextofkinnumberKeyPressed

    private void jTextField_nextnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nextnameKeyPressed
char c = evt.getKeyChar();

        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))
        {
            jTextField_nextname.setEditable(true);
        }
        else
        {

            jTextField_nextname.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nextnameKeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        residence = jComboBox1.getSelectedItem().toString();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Register_;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField_confirm;
    private javax.swing.JPasswordField jPasswordField_password;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_nextname;
    private javax.swing.JTextField jTextField_nextofkinnumber;
    private javax.swing.JTextField jTextField_phone;
    private javax.swing.JTextField jTextField_studentnumber;
    private javax.swing.JTextField jTextField_surname;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
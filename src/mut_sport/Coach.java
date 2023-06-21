/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mut_sport;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author cash
 */
public class Coach extends javax.swing.JFrame {

    /**
     * Creates new form Coach
     */
    public Coach() {
        initComponents();
                 showuser();
               
    }
    public Connection getConnection()
   {
         Connection con = null;
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Events? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    return con;
   }



public ArrayList<atte> getUsersList()
   {
       ArrayList <atte> usersList = new ArrayList<atte >();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `users` where group_id = 101";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

         atte  user;

           while(rs.next())
           {
user = new atte (rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("phone"),rs.getInt("group_id"));
               usersList.add(user);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }


   public void showuser(){
       
      ArrayList <atte > list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       Object [] row = new Object [6];
       
       for(int i = 0; i< list.size(); i++){
           
           row[0] = list.get(i).getID();
           row[1] = list.get(i).getFirstName();
           row[2] = list.get(i).getLastName();
           row[3] = list.get(i).getEmail();
           row[4] = list.get(i).getPhone();
           row[5] = list.get(i).getGroup_ID();
           
           model.addRow(row);
       
       }

   }
   public void findUsers()
    {
        ArrayList<atte> users = ListUsers( jTextField_search.getText());        

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"id","name","surname","email","phone","group_id"});
        Object[] row = new Object[6];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getID();
            row[1] = users.get(i).getFirstName();
            row[2] = users.get(i).getLastName();
            row[3] = users.get(i).getEmail();
            row[4] = users.get(i).getPhone();
            row[5] = users.get(i).getGroup_ID();
            model.addRow(row);
        }
       jTable1.setModel(model);
       
    }
    
   
 public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               model.setRowCount(0);
                   showuser();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       
       
   }
 
 public ArrayList<atte> ListUsers(String ValToSearch)
    {
        ArrayList<atte> usersList = new ArrayList<atte>();
                  Statement st;
        ResultSet rs;
        
        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `users` WHERE CONCAT(`id`, `name`, `surname`,`email`, `phone`,`group_id`) LIKE '%"+ValToSearch+"%' and group_id = 101";
            rs = st.executeQuery(searchQuery);
            
           atte user;
            
while(rs.next())
           {
user = new atte (rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("phone"),rs.getInt("group_id"));
               usersList.add(user);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
        
        return usersList;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton_Register_1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_surname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jTextField_ID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_phone = new javax.swing.JTextField();
        jTextField_group = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton_Register_2 = new javax.swing.JButton();
        jTextField_search = new javax.swing.JTextField();
        jButton_clear = new javax.swing.JButton();
        jButton_Register_3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton_clear1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Coach");

        jPanel9.setBackground(new java.awt.Color(44, 62, 80));

        jButton_Register_1.setBackground(new java.awt.Color(24, 127, 240));
        jButton_Register_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_1.setText("Update");
        jButton_Register_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_Register_1MouseClicked(evt);
            }
        });
        jButton_Register_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Register_1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Surname", "email", "phone", "Team"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel10.setBackground(new java.awt.Color(44, 62, 80));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panel1.setBackground(new java.awt.Color(44, 62, 80));

        jLabel8.setBackground(new java.awt.Color(236, 240, 241));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("First Name:");

        jTextField_name.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_name.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_nameKeyPressed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(236, 240, 241));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Surname:");

        jTextField_surname.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_surname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_surname.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_surnameKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(236, 240, 241));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Phone:");

        jLabel11.setBackground(new java.awt.Color(236, 240, 241));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Email:");

        jTextField_email.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_email.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailActionPerformed(evt);
            }
        });

        jTextField_ID.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_ID.setForeground(new java.awt.Color(228, 241, 254));

        jLabel12.setBackground(new java.awt.Color(236, 240, 241));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("ID :");

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

        jTextField_group.setBackground(new java.awt.Color(108, 112, 137));
        jTextField_group.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_group.setForeground(new java.awt.Color(228, 241, 254));
        jTextField_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_groupActionPerformed(evt);
            }
        });
        jTextField_group.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_groupKeyPressed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(236, 240, 241));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("Team:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_group, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton_Register_2.setBackground(new java.awt.Color(204, 0, 0));
        jButton_Register_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_2.setText("Delete");
        jButton_Register_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_Register_2MouseClicked(evt);
            }
        });
        jButton_Register_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Register_2ActionPerformed(evt);
            }
        });

        jTextField_search.setBackground(new java.awt.Color(108, 112, 137));

        jButton_clear.setBackground(new java.awt.Color(24, 127, 240));
        jButton_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_clear.setForeground(new java.awt.Color(255, 255, 255));
        jButton_clear.setText("Back");
        jButton_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_clearMouseClicked(evt);
            }
        });
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });

        jButton_Register_3.setBackground(new java.awt.Color(24, 127, 240));
        jButton_Register_3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_3.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_3.setText("Search");
        jButton_Register_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_Register_3MouseClicked(evt);
            }
        });
        jButton_Register_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Register_3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mut_sport/images/mut_logo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton_clear1.setBackground(new java.awt.Color(24, 127, 240));
        jButton_clear1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_clear1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_clear1.setText("Clear");
        jButton_clear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_clear1MouseClicked(evt);
            }
        });
        jButton_clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_clear)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_clear1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Register_1)
                        .addGap(34, 34, 34)
                        .addComponent(jButton_Register_2)
                        .addGap(30, 30, 30)
                        .addComponent(jButton_Register_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Register_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Register_3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Register_2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel6)
                .addContainerGap(1023, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Register_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_1MouseClicked
        String PhoneNumber = jTextField_phone.getText();
        int length = PhoneNumber.length();

        String nm = jTextField_name.getText();
        String se =  jTextField_surname.getText();

        String ph =  jTextField_phone.getText();
        String em = jTextField_email.getText();
        String use =  jTextField_group.getText();

        if(nm.equals("")){
            JOptionPane.showMessageDialog(null,"Insert name");
        }
        else if(se.equals("")){
            JOptionPane.showMessageDialog(null,"insert surname");
        }
        else if(ph.equals("")){
            JOptionPane.showMessageDialog(null,"insert a phone number");
        }
        else if(em.equals("")){
            JOptionPane.showMessageDialog(null,"insert an email");
        }
        else if(use.equals("")){
            JOptionPane.showMessageDialog(null,"insert group");
        }
        else if(length<10  ){

            JOptionPane.showMessageDialog(null,"you number is less than 10 ");
        }

        else if(!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", jTextField_email.getText())))
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{

            String query = "UPDATE `users` SET `name`='"+jTextField_name.getText()+"',`surname`='"+jTextField_surname.getText()+"',`email`='"+jTextField_email.getText()+"',`phone`='"+jTextField_phone.getText()+"',`group_id`="+jTextField_group.getText()+"                                                                                                                                                                                                                                                                                                                       WHERE `id` ="+jTextField_ID.getText()+"";
            executeSQlQuery(query, "Updated");
        }
    }//GEN-LAST:event_jButton_Register_1MouseClicked

    private void jButton_Register_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();

        TableModel model = jTable1.getModel();

        // Display Slected Row In JTexteFields
        jTextField_ID.setText(model.getValueAt(i,0).toString());

        jTextField_name.setText(model.getValueAt(i,1).toString());

        jTextField_surname.setText(model.getValueAt(i,2).toString());
        jTextField_email.setText(model.getValueAt(i,3).toString());
        jTextField_phone.setText(model.getValueAt(i,4).toString());
        jTextField_group.setText(model.getValueAt(i,5).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nameKeyPressed
        char c = evt.getKeyChar();

        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))
        {
            jTextField_name.setEditable(true);
        }
        else
        {

            jTextField_name.setEditable(false);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameKeyPressed

    private void jTextField_surnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_surnameKeyPressed
        char c = evt.getKeyChar();

        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))
        {
            jTextField_surname.setEditable(true);
        }
        else
        {

            jTextField_surname.setEditable(false);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_surnameKeyPressed

    private void jTextField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailActionPerformed

    private void jTextField_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_phoneActionPerformed

    private void jTextField_phoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_phoneKeyPressed
        String PhoneNumber = jTextField_phone.getText();
        int length = PhoneNumber.length();
        char c =evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if(length<10){

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
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_phoneKeyPressed

    private void jButton_Register_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_2MouseClicked
        String search = jTextField_search.getText();

        if(search.equals(""))
        {
            JOptionPane.showMessageDialog(null, "insert the value to search");

        }
        else{
            findUsers();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_2MouseClicked

    private void jButton_Register_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_2ActionPerformed

    private void jButton_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_clearMouseClicked
 Dashboard_admin fg =  new  Dashboard_admin ();
        fg.setVisible(true);
        fg.pack();
        fg.setLocationRelativeTo(null);
        fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_clearMouseClicked

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        jTextField_ID.setText(null);

        jTextField_name.setText(null);

        jTextField_surname.setText(null);
        jTextField_email.setText(null);
        jTextField_phone.setText(null);
        jTextField_group.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jTextField_groupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_groupKeyPressed
        String PhoneNumber = jTextField_group.getText();
        int length = PhoneNumber.length();
        char c =evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if(length<10){

                jTextField_group.setEditable(true);
            }
            else{
                jTextField_group.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE)
            {
                jTextField_group.setEditable(true);
            }
            else{
                jTextField_group.setEditable(false);
            }
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_groupKeyPressed

    private void jTextField_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_groupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_groupActionPerformed

    private void jButton_Register_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_3MouseClicked

    private void jButton_Register_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_3ActionPerformed

    private void jButton_clear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_clear1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_clear1MouseClicked

    private void jButton_clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_clear1ActionPerformed

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
            java.util.logging.Logger.getLogger(Coach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Coach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Coach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Coach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Coach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Register_1;
    private javax.swing.JButton jButton_Register_2;
    private javax.swing.JButton jButton_Register_3;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_clear1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_group;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_phone;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JTextField jTextField_surname;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}

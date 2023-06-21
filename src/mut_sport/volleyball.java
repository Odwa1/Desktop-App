/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mut_sport;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author cash
 */
public class volleyball extends javax.swing.JFrame {
  
    
      Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
    /**
     * Creates new form volleyball
     */
    public volleyball() {
        initComponents();
                   showuser();
               
    }
    public Connection getConnection()
   {
         Connection con = null;
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    return con;
   }



public ArrayList<volleyclass > getUsersList()
   {
       ArrayList <volleyclass > usersList = new ArrayList<volleyclass>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `volleyball`";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

         volleyclass   user;

           while(rs.next())
           {
user = new volleyclass  (rs.getInt("id"),rs.getString("team"),rs.getString("matchPlayed"),rs.getString("wins"),rs.getString("draws"),rs.getString("losses"),rs.getString("points"));
               usersList.add(user);
           }

    
       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }


   public void showuser(){
       
      ArrayList <volleyclass> list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)jTable12.getModel();
       Object [] row = new Object [7];
       
       for(int i = 0; i< list.size(); i++){
           
           row[0] = list.get(i).getID();
           row[1] = list.get(i).getTeam();
           row[2] = list.get(i).getMatchPlayed();
           row[3] = list.get(i).getWins();
           row[4] = list.get(i).getDraws();
           row[5] = list.get(i).getLosses();
           row[6] = list.get(i).getPoints();
       
           
            model.addRow(row);
    }
  
   }
 
   public void findUsers()
    {
        ArrayList<volleyclass> users = ListUsers( team.getText());        

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"id","team","matchPlayed","wins","draws","losses","points"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getID();
            row[1] = users.get(i).getTeam();;
            row[2] = users.get(i).getMatchPlayed();
            row[3] = users.get(i).getWins();
            row[4] = users.get(i).getTeam();;
            row[5] = users.get(i).getMatchPlayed();
            row[6] = users.get(i).getWins();
           
            model.addRow(row);
        }
       jTable12.setModel(model);
       
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
               DefaultTableModel model = (DefaultTableModel)jTable12.getModel();
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
 
 public ArrayList<volleyclass> ListUsers(String ValToSearch)
    {
        ArrayList<volleyclass> usersList = new ArrayList<volleyclass>();
                  Statement st;
        ResultSet rs;
        
        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `volleyball` WHERE CONCAT(`id`, `team`, `matchPlayed`, `wins`,`draws`, `losses`, `points`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);
     
           volleyclass user;
            
while(rs.next())
           {
user = new volleyclass  (rs.getInt("id"),rs.getString("team"),rs.getString("matchPlayed"),rs.getString("wins"),rs.getString("draws"),rs.getString("losses"),rs.getString("points"));
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
        jTable12 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        match = new javax.swing.JTextField();
        wins = new javax.swing.JTextField();
        losses = new javax.swing.JTextField();
        draws = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        points = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        team = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        jButton_clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton_Register_2 = new javax.swing.JButton();
        jButton_Register_3 = new javax.swing.JButton();
        jButton_Register_4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Volleyball tournament");

        jPanel9.setBackground(new java.awt.Color(44, 62, 80));

        jButton_Register_1.setBackground(new java.awt.Color(24, 127, 240));
        jButton_Register_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_1.setText("Back");
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

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Club", "MP", "W", "D", "L", "Pts"
            }
        ));
        jTable12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable12MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable12);

        jPanel10.setBackground(new java.awt.Color(44, 62, 80));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panel1.setBackground(new java.awt.Color(44, 62, 80));

        match.setBackground(new java.awt.Color(108, 112, 137));
        match.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        match.setForeground(new java.awt.Color(228, 241, 254));
        match.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                matchKeyReleased(evt);
            }
        });

        wins.setBackground(new java.awt.Color(108, 112, 137));
        wins.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wins.setForeground(new java.awt.Color(228, 241, 254));
        wins.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                winsKeyReleased(evt);
            }
        });

        losses.setBackground(new java.awt.Color(108, 112, 137));
        losses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        losses.setForeground(new java.awt.Color(228, 241, 254));
        losses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lossesKeyReleased(evt);
            }
        });

        draws.setBackground(new java.awt.Color(108, 112, 137));
        draws.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        draws.setForeground(new java.awt.Color(228, 241, 254));
        draws.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawsActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(236, 240, 241));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("Club:");

        jLabel8.setBackground(new java.awt.Color(236, 240, 241));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Match played:");

        jLabel9.setBackground(new java.awt.Color(236, 240, 241));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Wins:");

        jLabel13.setBackground(new java.awt.Color(236, 240, 241));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("Draws:");

        jLabel29.setBackground(new java.awt.Color(236, 240, 241));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(236, 240, 241));
        jLabel29.setText("Losses:");

        points.setBackground(new java.awt.Color(108, 112, 137));
        points.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        points.setForeground(new java.awt.Color(228, 241, 254));
        points.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointsActionPerformed(evt);
            }
        });
        points.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pointsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pointsKeyReleased(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(236, 240, 241));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(236, 240, 241));
        jLabel31.setText("Points:");

        team.setBackground(new java.awt.Color(108, 112, 137));
        team.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        team.setForeground(new java.awt.Color(228, 241, 254));
        team.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                teamKeyReleased(evt);
            }
        });

        ID.setBackground(new java.awt.Color(108, 112, 137));
        ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ID.setForeground(new java.awt.Color(228, 241, 254));
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(match, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wins, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draws, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(losses, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(team)
                            .addContainerGap()))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(team, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(match, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(draws, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(losses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jButton_clear.setBackground(new java.awt.Color(255, 0, 0));
        jButton_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_clear.setForeground(new java.awt.Color(255, 255, 255));
        jButton_clear.setText("Delete");
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mut_sport/images/mut_logo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton_Register_2.setBackground(new java.awt.Color(24, 127, 240));
        jButton_Register_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_2.setText("Update");
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

        jButton_Register_3.setBackground(new java.awt.Color(24, 127, 240));
        jButton_Register_3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_3.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_3.setText("Reload");
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

        jButton_Register_4.setBackground(new java.awt.Color(24, 127, 240));
        jButton_Register_4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Register_4.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_4.setText("add");
        jButton_Register_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_Register_4MouseClicked(evt);
            }
        });
        jButton_Register_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Register_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton_Register_1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Register_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Register_3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Register_4))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Register_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Register_2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Register_3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Register_4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
       
      
    }//GEN-LAST:event_jButton_Register_1MouseClicked

    private void jButton_Register_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_1ActionPerformed
        sport_codes lg =  new  sport_codes();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();           // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_1ActionPerformed

    private void jTable12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable12MouseClicked
        int i = jTable12.getSelectedRow();

        TableModel model = jTable12.getModel();

        // Display Slected Row In JTexteFields
         ID.setText(model.getValueAt(i,0).toString());
        team.setText(model.getValueAt(i,1).toString());

        match.setText(model.getValueAt(i,2).toString());

        wins.setText(model.getValueAt(i,3).toString());
        draws.setText(model.getValueAt(i,4).toString());
        losses.setText(model.getValueAt(i,5).toString());
        points.setText(model.getValueAt(i,6).toString());
        
    }//GEN-LAST:event_jTable12MouseClicked

    private void matchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matchKeyReleased

    }//GEN-LAST:event_matchKeyReleased

    private void winsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_winsKeyReleased

    }//GEN-LAST:event_winsKeyReleased

    private void lossesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lossesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lossesKeyReleased

    private void drawsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drawsActionPerformed

    private void pointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pointsActionPerformed

    private void pointsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pointsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pointsKeyPressed

    private void pointsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pointsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pointsKeyReleased

    private void teamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teamKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_teamKeyReleased

    private void jButton_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_clearMouseClicked
int p = JOptionPane.showConfirmDialog(null,"Do really want to delete?","Delete",JOptionPane.YES_NO_OPTION);

        if(p == 0){

            String query = "DELETE FROM `volleyball` WHERE team = '"+team.getText()+"'";
            executeSQlQuery(query, "Deleted");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_clearMouseClicked

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        team.setText(null);

        match.setText(null);

        wins.setText(null);
        draws.setText(null);
        losses.setText(null);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jButton_Register_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_2MouseClicked
        // TODO add your handling code here:
        
        String teams = team.getText();
        String played = match.getText();
        String win =  wins.getText();
        String draw =  draws.getText();
        String loss = losses.getText();
         String point= points.getText();

        if(teams.equals("")){
            JOptionPane.showMessageDialog(null,"Insert name of the team");
        }
        else if(played.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of match played");
        }
        else if(win.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of wins");
        }

        else if(draw.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of draws");
        }
        else if(loss.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of losses");
        }
        else if(point.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of points");
        }

             

        else{
            String query = "UPDATE `volleyball` SET `team`='"+team.getText()+"',`matchPlayed`='"+match.getText()+"',`wins`='"+wins.getText()+"',`draws`='"+draws.getText()+"',`losses`='"+losses.getText()+"',`points`='"+points.getText()+"' where `team`='"+team.getText()+"';                                                                                                                                                                                                                                                                                                                               WHERE `id` ="+team.getText()+"";
            executeSQlQuery(query, "Updated");
        } 
    }//GEN-LAST:event_jButton_Register_2MouseClicked

    private void jButton_Register_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_2ActionPerformed

   try{
        String sql = "UPDATE volleyball SET team =?,matchPlayed =?, wins =?, draws =?, losses, points=? WHERE id = ?";
        
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
       pst = con.prepareStatement(sql);
       
       pst.setString(1,team.getText());
       pst.setString(2,match.getText());
       pst.setString(3,wins.getText());
       pst.setString(4, draws.getText());
       pst.setString(5,losses.getText());
       pst.setString(6,points.getText());
       pst.setString(7,ID.getText());
       pst.executeUpdate();
       
      JOptionPane.showMessageDialog(null, "Successful updated");
        }
        catch(HeadlessException | SQLException ex){
         JOptionPane.showMessageDialog(null, ex);
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_2ActionPerformed

    private void jButton_Register_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_3MouseClicked

    private void jButton_Register_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_3ActionPerformed
 volleyball lg =  new  volleyball();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_3ActionPerformed

    private void jButton_Register_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_4MouseClicked
  
        String teams = team.getText();
        String played = match.getText();
        String win =  wins.getText();
        String draw =  draws.getText();
        String loss = losses.getText();
         String point= points.getText();

        if(team.equals("")){
            JOptionPane.showMessageDialog(null,"Insert name of the team");
        }
        else if(played.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of match played");
        }
        else if(wins.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of wins");
        }

        else if(draws.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of draws");
        }
        else if(losses.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of losses");
        }
        else if(points.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of points");
        }
       else{
            PreparedStatement ps;
            String query ="INSERT INTO `volleyball`(`team`, `matchPlayed`,`wins`, `draws`, `losses`, `points`) VALUES (?,?,?,?,?,?)";

            try {
                ps = MyConnection.getconection().prepareStatement(query);
               
                ps.setString(1,teams);
                ps.setString(2,played);
                ps.setString(3,win);
                ps.setString(4,draw);
                ps.setString(5,loss);
                 ps.setString(6,point);

                if(ps.executeUpdate()> 0){

                    JOptionPane.showMessageDialog(null,"Sucessful registered");

                }
            } catch (SQLException ex) {
                Logger.getLogger(Register_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
                  // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_4MouseClicked

    private void jButton_Register_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_4ActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDKeyPressed

    private void IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_IDKeyReleased

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
            java.util.logging.Logger.getLogger(volleyball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(volleyball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(volleyball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(volleyball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new volleyball().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField draws;
    private javax.swing.JButton jButton_Register_1;
    private javax.swing.JButton jButton_Register_2;
    private javax.swing.JButton jButton_Register_3;
    private javax.swing.JButton jButton_Register_4;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable12;
    private javax.swing.JTextField losses;
    private javax.swing.JTextField match;
    private java.awt.Panel panel1;
    private javax.swing.JTextField points;
    private javax.swing.JTextField team;
    private javax.swing.JTextField wins;
    // End of variables declaration//GEN-END:variables
}

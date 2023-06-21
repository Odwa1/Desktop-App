/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mut_sport;

import eventify.iterms;
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
public class Tournament extends javax.swing.JFrame {
   Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
    /** Creates new form Sponsors */
    public Tournament() {
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



public ArrayList<company > getUsersList()
   {
       ArrayList <company > usersList = new ArrayList<company  >();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `soccer`";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

         company   user;

           while(rs.next())
           {
user = new company  (rs.getInt("id"),rs.getString("team"),rs.getInt("matchPlayed"),rs.getInt("wins"),rs.getInt("draws"),rs.getInt("losses"),rs.getInt("goalFor"),rs.getInt("goalAgainst"),rs.getInt("goalDifference"),rs.getInt("points"));

               usersList.add(user);
           }
        } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }


   public void showuser(){
       
      ArrayList <company> list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)jTable12.getModel();
       Object [] row = new Object [11];
       
       for(int i = 0; i< list.size(); i++){
           
          row[0] = list.get(i).ID();
           row[1] = list.get(i).Team();
           row[2] = list.get(i).MatchPlayed();
           row[3] = list.get(i).Wins();
           row[4] = list.get(i).Draws();
           row[5] = list.get(i).Losses();
           row[6] = list.get(i).GoalFor();
           row[7] = list.get(i).GoalAgainst();
           row[8] = list.get(i).GoalDifference();
           row[9] = list.get(i).Points();
           
           model.addRow(row);
      

       }

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

 public ArrayList<company > ListUsers(String ValToSearch)
    {
        ArrayList<company > usersList = new ArrayList<company >();
                  Statement st;
        ResultSet rs;
        
        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `soccer` WHERE CONCAT(`id`, `team`, `matchPlayed`,`wins`, `draws`,`losses``wins`, `goalFor`,`goalDifference`,`points`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);
            
           company  user;
            
while(rs.next())
           {
user = new company  (rs.getInt("id"),rs.getString("team"),rs.getInt("matchPlayed"),rs.getInt("wins"),rs.getInt("draws"),rs.getInt("losses"),rs.getInt("goalFor"),rs.getInt("goalAgainst"),rs.getInt("goalDifference"),rs.getInt("points"));
               usersList.add(user);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
        
        return usersList;
    }
 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        goalAgainst = new javax.swing.JTextField();
        draws = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        goalFor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        GoalDifference = new javax.swing.JTextField();
        Points = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        team = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        jButton_clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton_Register_2 = new javax.swing.JButton();
        jButton_Register_3 = new javax.swing.JButton();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Soccer tournament");

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
                "ID", "Club", "MP", "W", "D", "L", "GF", "GA", "GD", "Pts"
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

        goalAgainst.setBackground(new java.awt.Color(108, 112, 137));
        goalAgainst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        goalAgainst.setForeground(new java.awt.Color(228, 241, 254));
        goalAgainst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goalAgainstActionPerformed(evt);
            }
        });
        goalAgainst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                goalAgainstKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                goalAgainstKeyReleased(evt);
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

        goalFor.setBackground(new java.awt.Color(108, 112, 137));
        goalFor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        goalFor.setForeground(new java.awt.Color(228, 241, 254));
        goalFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                goalForKeyReleased(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(236, 240, 241));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Gaols For:");

        jLabel10.setBackground(new java.awt.Color(236, 240, 241));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Goal Against:");

        GoalDifference.setBackground(new java.awt.Color(108, 112, 137));
        GoalDifference.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GoalDifference.setForeground(new java.awt.Color(228, 241, 254));
        GoalDifference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoalDifferenceActionPerformed(evt);
            }
        });
        GoalDifference.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GoalDifferenceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GoalDifferenceKeyReleased(evt);
            }
        });

        Points.setBackground(new java.awt.Color(108, 112, 137));
        Points.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Points.setForeground(new java.awt.Color(228, 241, 254));
        Points.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PointsActionPerformed(evt);
            }
        });
        Points.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PointsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PointsKeyReleased(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(236, 240, 241));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(236, 240, 241));
        jLabel30.setText("Goal Difference:");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Points, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GoalDifference, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(match, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wins, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(draws, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(losses, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goalFor, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goalAgainst, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(team)
                        .addContainerGap())))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                    .addContainerGap(123, Short.MAX_VALUE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(goalFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goalAgainst, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GoalDifference, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Points, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                    .addContainerGap(349, Short.MAX_VALUE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jButton_Register_2.setText("Reload");
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
        jButton_Register_3.setText("Add");
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

        update.setBackground(new java.awt.Color(24, 127, 240));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
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
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton_Register_1)
                                .addGap(11, 11, 11)
                                .addComponent(update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Register_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Register_3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Register_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Register_3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Register_2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(260, Short.MAX_VALUE))
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
                .addGap(0, 69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
  team.setEditable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void jButton_Register_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_1MouseClicked
     sport_codes lg =  new  sport_codes();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        
    }//GEN-LAST:event_jButton_Register_1MouseClicked

    private void jButton_Register_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_1ActionPerformed
           // TODO add your handling code here:
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
         goalFor.setText(model.getValueAt(i,6).toString());
        goalAgainst.setText(model.getValueAt(i,7).toString());
        GoalDifference.setText(model.getValueAt(i,8).toString());
        Points.setText(model.getValueAt(i,9).toString());
        
    
    }//GEN-LAST:event_jTable12MouseClicked

    private void matchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matchKeyReleased

    }//GEN-LAST:event_matchKeyReleased

    private void winsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_winsKeyReleased

    }//GEN-LAST:event_winsKeyReleased

    private void lossesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lossesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lossesKeyReleased

    private void goalAgainstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goalAgainstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goalAgainstActionPerformed

    private void goalAgainstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_goalAgainstKeyPressed
       
    }//GEN-LAST:event_goalAgainstKeyPressed

    private void goalAgainstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_goalAgainstKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_goalAgainstKeyReleased

    private void drawsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drawsActionPerformed

    private void goalForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_goalForKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_goalForKeyReleased

    private void GoalDifferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoalDifferenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoalDifferenceActionPerformed

    private void GoalDifferenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GoalDifferenceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoalDifferenceKeyPressed

    private void GoalDifferenceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GoalDifferenceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_GoalDifferenceKeyReleased

    private void PointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PointsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PointsActionPerformed

    private void PointsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PointsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PointsKeyPressed

    private void PointsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PointsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PointsKeyReleased

    private void jButton_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_clearMouseClicked
        

          try{
        String sql = "DELETE FROM soccer WHERE id =?";
        
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
       pst = con.prepareStatement(sql);
       
      pst.setString(1,ID.getText());
       pst.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Successful deleted");
        }
        catch(HeadlessException | SQLException ex){
         JOptionPane.showMessageDialog(null, ex);
        }

        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton_clearMouseClicked

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        team.setText(null);
       ID.setText(null);
        match.setText(null);

        wins.setText(null);
        draws.setText(null);
        losses.setText(null);
        goalAgainst.setText(null);
        goalFor.setText(null);
        GoalDifference.setText(null);
        Points.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void teamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teamKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_teamKeyReleased

    private void jButton_Register_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_2MouseClicked
                  // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_2MouseClicked

    private void jButton_Register_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_2ActionPerformed
   Tournament lg =  new  Tournament();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();  
    }//GEN-LAST:event_jButton_Register_2ActionPerformed

    private void jButton_Register_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Register_3MouseClicked
         String teams = team.getText();
        String matches = match.getText();
        String win =  wins.getText();
        String draw =  draws.getText();
        String loss = losses.getText();
         String ga =  goalAgainst.getText();
         String goal_for =  goalFor.getText();
        String goal_difference = GoalDifference.getText();
         String points =  Points.getText();

      if(teams.equals("")){
            JOptionPane.showMessageDialog(null,"Insert the team");
        }
        if(matches.equals("")){
            JOptionPane.showMessageDialog(null,"Insert number of match played");
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
         else if(ga.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of goal against");
           
        } else if(goal_for.equals("")){
            JOptionPane.showMessageDialog(null,"insert number of goals for");
           
        }  
        else if(goal_difference.equals("")){
            JOptionPane.showMessageDialog(null,"insert  goal difference");
           
        }
         else if(points.equals("")){
            JOptionPane.showMessageDialog(null,"insert the number of points");
           
        }
        else{
            PreparedStatement ps;
            String query ="INSERT INTO `soccer`(`team`, `matchPlayed`, `wins`, `draws`, `losses`, `goalFor`, `goalAgainst`, `goalDifference`, `points`) VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                ps = MyConnection.getconection().prepareStatement(query);
               
                ps.setString(1,teams);
                ps.setString(2,matches);
                ps.setString(3,win);
                ps.setString(4,draw);
                ps.setString(5,loss);
                 ps.setString(6,goal_for);
                ps.setString(7,ga);
                ps.setString(8,goal_difference);
                 ps.setString(9,points);

                if(ps.executeUpdate()> 0){

                    JOptionPane.showMessageDialog(null,"Sucessful registered");

                }
            } catch (SQLException ex) {
                Logger.getLogger(Register_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_3MouseClicked

    private void jButton_Register_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Register_3ActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     

   try{
        String sql = "UPDATE soccer SET team =?,matchPlayed =?, wins =?, draws =?, losses = ?, goalFor =?, goalAgainst=?, goalDifference = ?, points=? WHERE id = ?";
        
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
       pst = con.prepareStatement(sql);
       
       pst.setString(1,team.getText());
       pst.setString(2,match.getText());
       pst.setString(3,wins.getText());
       pst.setString(4, draws.getText());
       pst.setString(5,losses.getText());
       pst.setString(6,goalFor.getText());
       pst.setString(7,goalAgainst.getText());
       pst.setString(8,GoalDifference.getText());
       pst.setString(9,Points.getText());
       pst.setString(10,ID.getText());
       pst.executeUpdate();
       
      JOptionPane.showMessageDialog(null, "Successful updated");
        }
        catch(HeadlessException | SQLException ex){
         JOptionPane.showMessageDialog(null, ex);
        }       // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(Tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tournament().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GoalDifference;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Points;
    private javax.swing.JTextField draws;
    private javax.swing.JTextField goalAgainst;
    private javax.swing.JTextField goalFor;
    private javax.swing.JButton jButton_Register_1;
    private javax.swing.JButton jButton_Register_2;
    private javax.swing.JButton jButton_Register_3;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JTextField team;
    private javax.swing.JButton update;
    private javax.swing.JTextField wins;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos_predict;


//import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class MainForma extends javax.swing.JFrame {
Connection con1;
Vector<Vector<String>> data=new Vector<>();
Vector<Vector<String>> dataHistory=new Vector<>();
 DefaultTableModel modTable;
 DefaultTableModel modelHistory;
 UpdatePrediction editform;
 public JPopupMenu popup=new JPopupMenu();
{
    
   for(BetToday temp:BetToday.testSpisok){

      Vector<String> vec=new Vector<>();
       vec.add(String.valueOf(temp.id));
       vec.add(temp.time.getHour()+" : "+temp.time.getMinute());
       vec.add(temp.country);
       vec.add(temp.teamOwner);
       vec.add(String.valueOf(temp.resultMatchOwner));
       vec.add(temp.teamGuest);
       vec.add(String.valueOf(temp.resultMatchGuest));
       vec.add(temp.betPrediction);
       vec.add(String.valueOf(temp.keff));
       vec.add(temp.state);
       if(temp.resultMatchGuest>-1){
         dataHistory.add(vec);
      }else{
        data.add(vec);
      }
            
   }
    
}
    /**
     * Creates new form MainForma
     */
    public MainForma() {
        initComponents();
   jTable2.setDefaultRenderer(Object.class, new TableInfoRenderer());
        
       // Vector<String> name_column=new Vector<>();
       Vector<String> nameH_column=new Vector<>();
       
        createRecords();
        nameH_column.add("ID");
        nameH_column.add("Time game");
        nameH_column.add("Place game");
        nameH_column.add("Team owner");
       nameH_column.add("Result 1");
        nameH_column.add("Team guest");
        nameH_column.add("Result 2");
        nameH_column.add("Prediction");
        nameH_column.add("Koef");
        nameH_column.add("State");
        this.modTable=new DefaultTableModel(data, nameH_column);
        jTable1.setModel(modTable);
    jTable1.getSelectionModel().addListSelectionListener(new RowListener());
        this.modelHistory=new DefaultTableModel(dataHistory,nameH_column);
        jTable2.setModel(modelHistory);
    
    }
    private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            System.out.println(jTable1.getSelectedRow());
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_flag = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("История");

        jButton1.setText("Push");

        jLabel_flag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repos_predict/image/no_flag.jpg"))); // NOI18N
        jLabel_flag.setToolTipText("");
        jLabel_flag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_flagMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_flagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_flagMouseClicked
    JFileChooser fc = new JFileChooser();
    int returnVal = fc.showOpenDialog(this); 
    if (returnVal == JFileChooser.APPROVE_OPTION) {
               File  file = fc.getSelectedFile();
               Image img=null;
        try {
            img=ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
        }
               img=getScaledImage(img, jLabel_flag.getWidth(),jLabel_flag.getHeight());
                 jLabel_flag.setIcon(new ImageIcon(img));
                
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException ex) {
//            Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
//        }
            } 
     
        
        
    }//GEN-LAST:event_jLabel_flagMouseClicked

     
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
            java.util.logging.Logger.getLogger(MainForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForma().setVisible(true);
            }
        });
    }
 private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }    
//    void one(){
//    try {
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//   con1 = DriverManager.getConnection("jdbc:mysql://localhost/predictiontotoday?"
//           + "verifyServerCertificate=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Kiev&useSSL=false&allowPublicKeyRetrieval=true","user","useruser");
//       Statement  st=con1.createStatement();
//        ResultSet rs=st.executeQuery("SELECT * FROM predictiontotoday.country");
//        while(rs.next()){
//            System.out.println(rs.getString(2)); 
//        }
//        rs.close();
//        st.close();
//   // Do something with the Connection
////   DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila?" +
////                 "useLegacyDatetimeCode=false&serverTimezone=Europe/Kiev&useSSL=false","root","gen");
////verifyServerCertificate=false&amp;autoReconnect=false&amp;useSSL=false
//} catch (SQLException ex) {
//    // handle any errors
//    System.out.println("SQLException: " + ex.getMessage());
//    System.out.println("SQLState: " + ex.getSQLState());
//    System.out.println("VendorError: " + ex.getErrorCode());
//}   catch (ClassNotFoundException ex) {
//        Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
//    } catch (InstantiationException ex) {
//        Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
//    } catch (IllegalAccessException ex) {
//        Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
//    }
   // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_flag;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    private void createRecords() {
      ActionListener menuListener = new ActionListener() {
      

          @Override
          public void actionPerformed(ActionEvent e) {
              int currentRecords=jTable1.getSelectedRow();
              Vector temp;
              Vector temp1;
              if(currentRecords==-1& (!e.getActionCommand().equals("Add new")) ){
                          JOptionPane.showInternalMessageDialog(getContentPane(), "Выберите запись для редактирования .");
                          return;
                      }
               
              switch(e.getActionCommand()){
                  case "Edit":
                      temp=(Vector) modTable.getDataVector().elementAt(jTable1.getSelectedRow());                       
                      editform=new UpdatePrediction("edit",temp,MainForma.this);
                      editform.setVisible(true);
                      
                      jTable1.revalidate();
                      break;
                  case "Move to History": 
                      temp=(Vector) modTable.getDataVector().elementAt(jTable1.getSelectedRow());                       
                      editform=new UpdatePrediction("move",temp,MainForma.this);
                              editform.setVisible(true);
                       //temp1=UpdatePrediction.currentPredict;
                      
                      break;                   
                  case "Add new":
                      editform=new UpdatePrediction("add",null,MainForma.this);
                      editform.setVisible(true);
                      break;
                     
              }
                          
          }
    };
    JMenuItem item;
    popup.add(item = new JMenuItem("Edit", new ImageIcon("edit.gif")));
    item.setHorizontalTextPosition(JMenuItem.RIGHT);
    item.addActionListener(menuListener);
    popup.addSeparator();
   popup.add(item = new JMenuItem("Move to History", new ImageIcon("2.gif")));
   item.setHorizontalTextPosition(JMenuItem.RIGHT);
   item.addActionListener(menuListener);
    popup.addSeparator();
    popup.add(item = new JMenuItem("Add new", new ImageIcon("2.gif")));
   item.setHorizontalTextPosition(JMenuItem.RIGHT);
   item.addActionListener(menuListener);
    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
   jTable1.addMouseListener(new MousePopupListener());
    //jTable1.addMouseWheelListener(new MousePopupListener());
    }
    class MousePopupListener extends MouseAdapter {
    
        public void mousePressed(MouseEvent e) {
            if(e.getButton()==MouseEvent.BUTTON3){
                popup.show(jTable1, e.getX(), e.getY());
            }
          }

   

   
  }
    class TableInfoRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
 
        if(column==1) c.setHorizontalAlignment(CENTER);
        else  c.setHorizontalAlignment(LEFT);
        
        
        if(c.getText().equals("Positive")){
            c.setBackground(Color.green);
        }
        if(c.getText().equals("Negative")){
            c.setBackground(Color.red);
        }
         if(c.getText().equals("Perenos")){
            c.setBackground(Color.yellow);
        }
        
        return c;
    }
}
}

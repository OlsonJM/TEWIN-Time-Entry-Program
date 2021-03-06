/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DBManager.java
 *
 * Created on Feb 13, 2010, 5:06:42 PM
 */

package tewin;
import java.io.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author E0051024
 */
public class DBManager extends javax.swing.JFrame {

    private Utilities u;
    private SettingsForm sf;
    private String dbLocation;
    private String progLocation;
    private DBExportHistorical dbExport;
    private Integer timeRecords;
    private Integer otRecords;
    private Integer expenseRecords;

    /** Creates new form DBManager */
    public DBManager() {
        this.u = new Utilities();
        this.sf = new SettingsForm();
        this.progLocation = this.sf.getProgramLocation();
        this.dbLocation = this.sf.getDBLoation();
        initComponents();
        getFileSizes();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc = new javax.swing.JFileChooser();
        jLabel5 = new javax.swing.JLabel();
        bRestoreDB = new javax.swing.JButton();
        bBackupDB = new javax.swing.JButton();
        bCreateDB = new javax.swing.JButton();
        bTKClear = new javax.swing.JButton();
        lTimeSize = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bExit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lTimeRecords = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lOTRecords = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lExpenseRecords = new javax.swing.JLabel();
        bManageCustomers = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lTimeKeeper = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lCustomers = new javax.swing.JLabel();
        lDistributer = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bManageDistributers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TEWin - Database Management");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel5.setText("Database Size:");

        bRestoreDB.setText("Restore Database");
        bRestoreDB.setToolTipText("Restore database from backup file");
        bRestoreDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRestoreDBActionPerformed(evt);
            }
        });

        bBackupDB.setText("Backup Database");
        bBackupDB.setToolTipText("Backup Database to seperate file");
        bBackupDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackupDBActionPerformed(evt);
            }
        });

        bCreateDB.setText("Create Database");
        bCreateDB.setToolTipText("Create a new blank Database");
        bCreateDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateDBActionPerformed(evt);
            }
        });

        bTKClear.setText("Clear TimeKeeper");
        bTKClear.setToolTipText("Erases Time Keeper records >1year old");
        bTKClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTKClearActionPerformed(evt);
            }
        });

        lTimeSize.setFont(new java.awt.Font("Tahoma", 0, 18));
        lTimeSize.setText("0");
        lTimeSize.setToolTipText("Size (in KB) of the main database file");
        lTimeSize.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("TEWIN Database Management");

        bExit.setText("Close");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel6.setText("Time Records:");

        lTimeRecords.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lTimeRecords.setText("0");
        lTimeRecords.setToolTipText("Number of Time Records in Database");
        lTimeRecords.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel7.setText("OT Records:");

        lOTRecords.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lOTRecords.setText("0");
        lOTRecords.setToolTipText("Number of OT Records in Database");
        lOTRecords.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel8.setText("Expense Records:");

        lExpenseRecords.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lExpenseRecords.setText("0");
        lExpenseRecords.setToolTipText("Number of Expense Records in Database");
        lExpenseRecords.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        bManageCustomers.setText("Customer Records");
        bManageCustomers.setToolTipText("Manage Database");
        bManageCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bManageCustomersActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("TimeKeeper Records:");

        lTimeKeeper.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lTimeKeeper.setText("0");
        lTimeKeeper.setToolTipText("Number of TimeKeeper Records");
        lTimeKeeper.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Customers:");

        lCustomers.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lCustomers.setText("0");
        lCustomers.setToolTipText("Number of Customers in Database");
        lCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lDistributer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lDistributer.setText("0");
        lDistributer.setToolTipText("Number of Distributers in Database");
        lDistributer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Distributers:");

        bManageDistributers.setText("Distributer Records");
        bManageDistributers.setToolTipText("Manage Database");
        bManageDistributers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bManageDistributersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bManageDistributers, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(bManageCustomers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(bCreateDB, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(bBackupDB, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(bRestoreDB, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(bTKClear, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lExpenseRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lOTRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lTimeRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lTimeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lTimeKeeper, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(bExit)
                .addGap(188, 188, 188))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(lDistributer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel4)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bCreateDB)
                    .addComponent(jLabel5)
                    .addComponent(lTimeSize))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lTimeRecords)
                            .addComponent(jLabel6)
                            .addComponent(bBackupDB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lOTRecords))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(bRestoreDB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel8)
                        .addComponent(bTKClear))
                    .addComponent(lExpenseRecords))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bManageCustomers)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lTimeKeeper)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lCustomers)
                        .addComponent(jLabel10))
                    .addComponent(bManageDistributers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lDistributer)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(bExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getFileSizes(){
        DataConnection dc = new DataConnection();
        ResultSet rs;
        //GET Main DB Size in KB
        try{
            File dbT = new File(sf.getDBFile());
            this.lTimeSize.setText(dbT.length()/1000 + " KB");

        }catch(Exception e)
        {
            System.out.println(e);
        }

        //Count the number of Time Records
        dc.connect();
        rs = dc.getRecordCount("TimeData");
        try{
            if(rs.next())
            {
                timeRecords = rs.getInt("rowcount");
                this.lTimeRecords.setText(Integer.toString(timeRecords));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        //Count the number of OT Records
        rs = dc.getRecordCount("OT");
        try{
            if(rs.next())
            {
                otRecords = rs.getInt("rowcount");
                this.lOTRecords.setText(Integer.toString(otRecords));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        //Count the number of OT Records
        rs = dc.getRecordCount("Expense");
        try{
            if(rs.next())
            {
                expenseRecords = rs.getInt("rowcount");
                this.lExpenseRecords.setText(Integer.toString(expenseRecords));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        dc.closeConnection();
    }

    private void bRestoreDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRestoreDBActionPerformed
        
        boolean success = true;
        boolean abort = false;
        String TMrestoreFile;
        

        int response = JOptionPane.showConfirmDialog(this,
                "Restoring the database will perminantly erase existing\n"+
                "database. Backup database before restoring. Do you wish to\n" +
                "continue with database restoration?",
                "Confirm DB Restoration",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response != JOptionPane.YES_OPTION)
            abort = true;

        if(!abort) {
            this.fc.setDialogTitle("Select DATABASE backup file");
            this.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if(this.fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
                TMrestoreFile = this.fc.getSelectedFile().toString();
            }else {
                success=false;
                return;
            }

         
            if(!TMrestoreFile.endsWith(".mdb")){
                JOptionPane.showMessageDialog(this, "Time Restore file must be a .mdb file");
                return;
            }


            File TMresFile = new File(TMrestoreFile);
            File TMdbFile = new File(this.dbLocation + "\\TE.mdb");
            File newTMDbFile = new File(this.dbLocation + "\\tempTM.mdb");

            if(!TMdbFile.exists()){
                JOptionPane.showMessageDialog(this, "Database file not found");
                return;
            }

            try{
                if(success)
                {
                    success=false;
                    newTMDbFile.createNewFile();
                    TMdbFile.delete();
                    this.u.copy(TMresFile,newTMDbFile);
                    newTMDbFile.renameTo(TMdbFile);
                    success = true;
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error Restoring Database");
                success=false;
                return;
            }

            if(success){
                JOptionPane.showMessageDialog(this, "Database Restore Successfull!");
                getFileSizes();
            }
        }
    }//GEN-LAST:event_bRestoreDBActionPerformed

    private void bBackupDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackupDBActionPerformed
        boolean success = false;
        boolean abort = false;
        File buFileTM;

        Object result = JOptionPane.showInputDialog(this,
                "Enter filename for backup database\n" +
                "(without extention .MDB): ");

        if(result!=null) {
            buFileTM = new File(this.progLocation + "\\" + result+ "_TIME" + ".mdb");
            if(buFileTM.exists()) {
                int response = JOptionPane.showConfirmDialog(this,
                        "Backup file already exists\n"+
                        "Do you wish to overwrite?", "Database Backup",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response != JOptionPane.YES_OPTION){
                    abort = true;
                }
            }

            if(!abort) {

                File dbFile = new File(this.dbLocation + "\\TE.mdb");

                if(!dbFile.exists()){
                    JOptionPane.showMessageDialog(this, "Database file not found");
                    return;
                }

                try{
                    buFileTM.createNewFile();
                    this.u.copy(dbFile,buFileTM);
                    success = true;

                }catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error Backing up Database");
                    return;
                }

                if(success)
                    JOptionPane.showMessageDialog(this, "Database Backup Successfull!\n"+
                            "Location: " + buFileTM.toString());
            }
        }
}//GEN-LAST:event_bBackupDBActionPerformed

    private void bCreateDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateDBActionPerformed

        File template = new File(this.progLocation + "\\template.mdb");
        File holder1 = new File(this.progLocation + "\\holderTM.mdb");
        File dbTM = new File(this.dbLocation + "\\TE.mdb");

        boolean template1 = (template.exists());

        if(!template1){
            JOptionPane.showMessageDialog(this, "Template File missing from " + this.progLocation);
            return;
        }

        int response = JOptionPane.showConfirmDialog(this,
                "Creating a database will perminantly erase existing\n"+
                "database. Backup database before creating. Do you wish to\n" +
                "continue with database creation?",
                "Confirm DB Creation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            try{
                this.u.copy(template,holder1);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error Creating DB.. ");
                return;
            }
            DataConnection dc = new DataConnection(holder1.getPath());
            boolean delSucess1 = false;
            boolean renSucess1 = false;
            dc.connect();
            if(dc.createBaseTables()&&dc.createOTtablesInMDB())
            {
                dc.closeConnection();
                delSucess1 = dbTM.delete();
                renSucess1 = holder1.renameTo(dbTM);
            }
            
            
            if(delSucess1&&renSucess1){
                dc.closeConnection();
                JOptionPane.showMessageDialog(this, "Database Creation Sucessful\n"+
                        "Location: " + this.dbLocation);
                this.bRestoreDB.setEnabled(true);
                getFileSizes();
            }

        } else
            return;
    }//GEN-LAST:event_bCreateDBActionPerformed

    private void bTKClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTKClearActionPerformed
        if(this.dbExport==null||!this.dbExport.isShowing()){
            this.dbExport = new DBExportHistorical();
            this.dbExport.setVisible(true);
        }else
            return;
    }//GEN-LAST:event_bTKClearActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed

        this.dispose();
    }//GEN-LAST:event_bExitActionPerformed

    private void bManageCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bManageCustomersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bManageCustomersActionPerformed

    private void bManageDistributersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bManageDistributersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bManageDistributersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBackupDB;
    private javax.swing.JButton bCreateDB;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bManageCustomers;
    private javax.swing.JButton bManageDistributers;
    private javax.swing.JButton bRestoreDB;
    private javax.swing.JButton bTKClear;
    private javax.swing.JFileChooser fc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lCustomers;
    private javax.swing.JLabel lDistributer;
    private javax.swing.JLabel lExpenseRecords;
    private javax.swing.JLabel lOTRecords;
    private javax.swing.JLabel lTimeKeeper;
    private javax.swing.JLabel lTimeRecords;
    private javax.swing.JLabel lTimeSize;
    // End of variables declaration//GEN-END:variables

}

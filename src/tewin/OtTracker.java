/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OtTracker.java
 *
 * Created on Dec 24, 2009, 3:12:40 PM
 */
package tewin;

import javax.swing.tree.*;
import javax.swing.table.*;
import java.sql.*;
import java.text.*;
import javax.swing.JOptionPane;


/**
 *
 * @author E0051024
 */
public class OtTracker extends javax.swing.JFrame {
    private int lastOTYear;
    private int lastOTweek;
    private int lastPayYear;
    private int lastPayMonth;
    private Double sumST;
    private Double sumTH;
    private Double sumDT;
    private Double sumPayST;
    private Double sumPayTH;
    private Double sumPayDT;

    /** Creates new form OtTracker */
    public OtTracker() {
        cleanOTdb();
        this.sumST=0.0;
        this.sumTH=0.0;
        this.sumDT=0.0;
        this.sumPayST=0.0;
        this.sumPayTH=0.0;
        this.sumPayDT=0.0;
        initComponents();
        this.tblPay.setRowSelectionAllowed(true);
        createOtTree();
        createPayTree();
        this.pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ttOT = new javax.swing.JScrollPane();
        treeOT = new javax.swing.JTree();
        ttPay = new javax.swing.JScrollPane();
        treePay = new javax.swing.JTree();
        scpOT = new javax.swing.JScrollPane();
        tblOT = new javax.swing.JTable();
        scpPay = new javax.swing.JScrollPane();
        tblPay = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lOT_TH = new javax.swing.JLabel();
        lOT_DT = new javax.swing.JLabel();
        lOT_ST = new javax.swing.JLabel();
        lPayST = new javax.swing.JLabel();
        lPayDT = new javax.swing.JLabel();
        lPayTH = new javax.swing.JLabel();
        bExit = new javax.swing.JButton();
        lNetDT = new javax.swing.JLabel();
        lNetTH = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lNetST = new javax.swing.JLabel();
        bAddPayRow = new javax.swing.JButton();
        bDelPayRow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Overtime Tracker");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        treeOT.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeOTValueChanged(evt);
            }
        });
        ttOT.setViewportView(treeOT);

        treePay.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treePayValueChanged(evt);
            }
        });
        ttPay.setViewportView(treePay);

        tblOT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "(Week) Starting", "ST", "R", "TH", "R", "DT", "R"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOTMouseClicked(evt);
            }
        });
        scpOT.setViewportView(tblOT);
        tblOT.getColumnModel().getColumn(0).setMinWidth(0);
        tblOT.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblOT.getColumnModel().getColumn(0).setMaxWidth(2);
        tblOT.getColumnModel().getColumn(1).setMinWidth(5);
        tblOT.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblOT.getColumnModel().getColumn(1).setMaxWidth(125);
        tblOT.getColumnModel().getColumn(2).setMinWidth(2);
        tblOT.getColumnModel().getColumn(2).setPreferredWidth(23);
        tblOT.getColumnModel().getColumn(2).setMaxWidth(50);
        tblOT.getColumnModel().getColumn(3).setMinWidth(2);
        tblOT.getColumnModel().getColumn(3).setPreferredWidth(8);
        tblOT.getColumnModel().getColumn(3).setMaxWidth(15);
        tblOT.getColumnModel().getColumn(4).setMinWidth(2);
        tblOT.getColumnModel().getColumn(4).setPreferredWidth(23);
        tblOT.getColumnModel().getColumn(4).setMaxWidth(50);
        tblOT.getColumnModel().getColumn(5).setMinWidth(2);
        tblOT.getColumnModel().getColumn(5).setPreferredWidth(8);
        tblOT.getColumnModel().getColumn(5).setMaxWidth(15);
        tblOT.getColumnModel().getColumn(6).setMinWidth(2);
        tblOT.getColumnModel().getColumn(6).setPreferredWidth(23);
        tblOT.getColumnModel().getColumn(6).setMaxWidth(50);
        tblOT.getColumnModel().getColumn(7).setMinWidth(2);
        tblOT.getColumnModel().getColumn(7).setPreferredWidth(8);
        tblOT.getColumnModel().getColumn(7).setMaxWidth(15);

        tblPay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pay Day", "ST", "A", "TH", "A", "DT", "A"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPayMouseClicked(evt);
            }
        });
        scpPay.setViewportView(tblPay);
        tblPay.getColumnModel().getColumn(0).setMinWidth(0);
        tblPay.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblPay.getColumnModel().getColumn(0).setMaxWidth(2);
        tblPay.getColumnModel().getColumn(1).setMinWidth(2);
        tblPay.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblPay.getColumnModel().getColumn(1).setMaxWidth(100);
        tblPay.getColumnModel().getColumn(2).setMinWidth(2);
        tblPay.getColumnModel().getColumn(2).setPreferredWidth(25);
        tblPay.getColumnModel().getColumn(2).setMaxWidth(50);
        tblPay.getColumnModel().getColumn(3).setMinWidth(2);
        tblPay.getColumnModel().getColumn(3).setPreferredWidth(8);
        tblPay.getColumnModel().getColumn(3).setMaxWidth(15);
        tblPay.getColumnModel().getColumn(4).setMinWidth(2);
        tblPay.getColumnModel().getColumn(4).setPreferredWidth(25);
        tblPay.getColumnModel().getColumn(4).setMaxWidth(50);
        tblPay.getColumnModel().getColumn(5).setMinWidth(2);
        tblPay.getColumnModel().getColumn(5).setPreferredWidth(8);
        tblPay.getColumnModel().getColumn(5).setMaxWidth(15);
        tblPay.getColumnModel().getColumn(6).setMinWidth(2);
        tblPay.getColumnModel().getColumn(6).setPreferredWidth(25);
        tblPay.getColumnModel().getColumn(6).setMaxWidth(50);
        tblPay.getColumnModel().getColumn(7).setMinWidth(2);
        tblPay.getColumnModel().getColumn(7).setPreferredWidth(8);
        tblPay.getColumnModel().getColumn(7).setMaxWidth(15);

        jLabel1.setText("Total OT - Not Recieved");

        jLabel2.setText("Total Pay - Not Accounted");

        jLabel3.setText("ST");

        jLabel4.setText("TH");

        jLabel5.setText("DT");

        lOT_TH.setText("0.0");
        lOT_TH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lOT_DT.setText("0.0");
        lOT_DT.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lOT_ST.setText("0.0");
        lOT_ST.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lPayST.setText("0.0");
        lPayST.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lPayDT.setText("0.0");
        lPayDT.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lPayTH.setText("0.0");
        lPayTH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        lNetDT.setText("0.0");
        lNetDT.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lNetTH.setText("0.0");
        lNetTH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel20.setText("Net Difference");

        lNetST.setText("0.0");
        lNetST.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        bAddPayRow.setText("Add Pay Data");
        bAddPayRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddPayRowActionPerformed(evt);
            }
        });

        bDelPayRow.setText("Delete Pay Row");
        bDelPayRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelPayRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ttOT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scpOT, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scpPay, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel20)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lPayST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lNetST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lOT_ST, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lPayTH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lNetTH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addComponent(lOT_TH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lNetDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lOT_DT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bDelPayRow, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bAddPayRow, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lPayDT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(358, 358, 358)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ttPay, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ttPay, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(bExit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ttOT, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scpPay, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addComponent(scpOT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lPayST)
                                                    .addComponent(jLabel2)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lOT_ST)
                                                .addComponent(jLabel1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lNetST)
                                            .addComponent(jLabel20)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lOT_TH)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lPayTH)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lNetTH))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lOT_DT)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lPayDT)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lNetDT))))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bAddPayRow)
                                    .addComponent(bDelPayRow))))
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed

        saveTableChanges();
        this.dispose();
    }//GEN-LAST:event_bExitActionPerformed

    private void treeOTValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeOTValueChanged

        saveTableChanges();
        TreePath o = this.treeOT.getSelectionPath();
        DefaultTableModel model = (DefaultTableModel)this.tblOT.getModel();
        Object[] objects = new Object[8];
        model.setRowCount(0);
        String query = "";
        DateFormat formatter;
        formatter = new SimpleDateFormat("MMM dd, yyyy");
        java.util.Calendar now = java.util.Calendar.getInstance();
        int yr,wk;

        int path = o.getPathCount();

        if(path< 2){
            return;
        }else if(path==2){
            String year = o.getPathComponent(1).toString();
            query = "SELECT * FROM OT WHERE (Year = " + year + " ) ORDER BY Year,Week ASC";
        }else if(path==3){
            String year = o.getPathComponent(1).toString();
            String week[] = o.getLastPathComponent().toString().split(" ");
            query = "SELECT * FROM OT WHERE ((Year = " + year + " AND " +
                    "Week >= " + week[1] + ") OR (Year > " + year + " )) ORDER BY Year,Week ASC";
        }else
            return;

        DataConnection dc = new DataConnection();
        dc.connect();

        try{
            
            ResultSet rs = dc.dbQuery(query);
            while(rs.next()){
                objects[0] = rs.getInt(1);
                yr = rs.getInt(2);
                wk = rs.getInt(3);
                now.set(java.util.Calendar.YEAR, yr);
                now.set(java.util.Calendar.WEEK_OF_YEAR, wk);
                now.set(java.util.Calendar.DAY_OF_WEEK,1);
                //objects[1] = Integer.toString(rs.getInt(2)) + "-" +
                //        Integer.toString(rs.getInt(3));
                objects[1] = "(" + Integer.toString(wk) + ") " + formatter.format(now.getTime()).toString();
                objects[2] = rs.getDouble(4);
                objects[3] = rs.getBoolean(7);
                objects[4] = rs.getDouble(5);
                objects[5] = rs.getBoolean(8);
                objects[6] = rs.getDouble(6);
                objects[7] = rs.getBoolean(9);

                model.addRow(objects);
            }
            this.tblOT.setModel(model);
            
        }catch (Exception e)
        {
            System.out.println(e);
        }

        dc.closeConnection();
        setTotals();

    }//GEN-LAST:event_treeOTValueChanged

    private void setTotals(){
        this.sumPayST=0.0;
        this.sumPayTH=0.0;
        this.sumPayDT=0.0;
        this.sumST=0.0;
        this.sumTH=0.0;
        this.sumDT=0.0;
        int rowCount;

        DefaultTableModel model = (DefaultTableModel)this.tblPay.getModel();
        rowCount = model.getRowCount();

        for(int i=0;i<rowCount;i++){
            if(!(Boolean)model.getValueAt(i,3))
                this.sumPayST+=(Double)model.getValueAt(i, 2);
            if(!(Boolean)model.getValueAt(i,5))
                this.sumPayTH+=(Double)model.getValueAt(i, 4);
            if(!(Boolean)model.getValueAt(i,7))
                this.sumPayDT+=(Double)model.getValueAt(i, 6);
        }

        model = (DefaultTableModel)this.tblOT.getModel();
        rowCount = model.getRowCount();

        for(int i=0;i<rowCount;i++){
            if(!(Boolean)model.getValueAt(i,3))
                this.sumST+=(Double)model.getValueAt(i, 2);
            if(!(Boolean)model.getValueAt(i,5))
                this.sumTH+=(Double)model.getValueAt(i, 4);
            if(!(Boolean)model.getValueAt(i,7))
                this.sumDT+=(Double)model.getValueAt(i, 6);
        }


        this.lOT_ST.setText(Double.toString(this.sumST));
        this.lOT_TH.setText(Double.toString(this.sumTH));
        this.lOT_DT.setText(Double.toString(this.sumDT));
        this.lPayST.setText(Double.toString(this.sumPayST));
        this.lPayTH.setText(Double.toString(this.sumPayTH));
        this.lPayDT.setText(Double.toString(this.sumPayDT));
        this.lNetST.setText(Double.toString(this.sumST-this.sumPayST));
        this.lNetTH.setText(Double.toString(this.sumTH-this.sumPayTH));
        this.lNetDT.setText(Double.toString(this.sumDT-this.sumPayDT));

    }

    private void treePayValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treePayValueChanged

        saveTableChanges();
        TreePath o = this.treePay.getSelectionPath();
        DefaultTableModel model = (DefaultTableModel)this.tblPay.getModel();
        Object[] objects = new Object[8];
        model.setRowCount(0);
        String query = "";
        int path = o.getPathCount();

        if(path< 2){
            return;
        }else if(path==2){
            String year = o.getPathComponent(1).toString();
            query = "SELECT * FROM PayHistory WHERE (PayYear = " + year + 
                    " ) ORDER BY PayYear,PayMonth,PayDay ASC";
        }else if(path==3){
            String year = o.getPathComponent(1).toString();
            String month[] = o.getPathComponent(2).toString().split(" ");
            query = "SELECT * FROM PayHistory WHERE ((PayYear = " + year + " AND " +
                    "PayMonth >= " + Integer.toString(getMonth(month[0])) +  " ) OR (" +
                    "PayYear > " + year + " )) ORDER BY PayYear,PayMonth,PayDay ASC";
        }else
            return;

        DataConnection dc = new DataConnection();
        dc.connect();

        try{
           
            ResultSet rs = dc.dbQuery(query);
            while(rs.next()){
                objects[0] = rs.getInt(1);
                objects[1] = Integer.toString(rs.getInt(3)+1) + "/" +
                        Integer.toString(rs.getInt(4)) + "/" +
                        Integer.toString(rs.getInt(2));
                objects[2] = rs.getDouble(5);
                objects[3] = rs.getBoolean(8);
                objects[4] = rs.getDouble(6);
                objects[5] = rs.getBoolean(9);
                objects[6] = rs.getDouble(7);
                objects[7] = rs.getBoolean(10);

                model.addRow(objects);
            }
            this.tblPay.setModel(model);

        }catch (Exception e)
        {
            System.out.println(e);
        }

        dc.closeConnection();
        setTotals();

    }//GEN-LAST:event_treePayValueChanged

    private void bAddPayRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddPayRowActionPerformed

        String s = (String)JOptionPane.showInputDialog(this,"Enter date of pay in MM/dd/yyyy format\n",
                "Enter Pay Date", JOptionPane.PLAIN_MESSAGE);
        if((s!=null) && (s.length()>=8)){
            DataConnection dc = new DataConnection();
            dc.connect();
            DateFormat formatter;
            formatter = new SimpleDateFormat("MM/dd/yyyy");
            try{
                java.util.Date temp = formatter.parse(s);
                java.util.Calendar now = java.util.Calendar.getInstance();
                now.setTime(temp);

                dc.addPayHrs(now.get(java.util.Calendar.YEAR),now.get(java.util.Calendar.MONTH),
                    now.get(java.util.Calendar.DAY_OF_MONTH),0.0,0.0,0.0,false,false,false);
            }catch (Exception e)
            {
                System.out.println(e);
            }

            //Update Tree

            dc.closeConnection();
            treePayValueChanged(null);
            this.validate();
        }
      

    }//GEN-LAST:event_bAddPayRowActionPerformed

    private void tblOTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOTMouseClicked

        saveTableChanges();
        setTotals();

    }//GEN-LAST:event_tblOTMouseClicked

    private void tblPayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPayMouseClicked

        saveTableChanges();
        setTotals();
    }//GEN-LAST:event_tblPayMouseClicked

    private void bDelPayRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelPayRowActionPerformed
        int row = this.tblPay.getSelectedRow();
        if(row>=0)
        {
            int ID = (Integer)this.tblPay.getModel().getValueAt(row, 0);
            String date = (String)this.tblPay.getModel().getValueAt(row,1);

            DataConnection dc = new DataConnection();
            dc.connect();
            dc.delPayHrs(ID);
            dc.closeConnection();
            DefaultTableModel model = (DefaultTableModel)this.tblPay.getModel();
            model.removeRow(row);

            treePayValueChanged(null);
        }
    }//GEN-LAST:event_bDelPayRowActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void createOtTree(){
        DataConnection dc = new DataConnection ();
        ResultSet rs;
        dc.connect();

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Overtime");
        String query1 = "SELECT * FROM OT ORDER BY Year,Week ASC";
        try{
            rs = dc.dbQuery(query1);
            DefaultMutableTreeNode resultNode=null;

            while(rs.next()){
                this.lastOTYear = rs.getInt(2);
                if(resultNode==null||!(resultNode.toString().equalsIgnoreCase(Integer.toString(this.lastOTYear))))
                {
                    resultNode = new DefaultMutableTreeNode(Integer.toString(rs.getInt(2)));
                    rootNode.add(resultNode);
                }
                this.lastOTweek = rs.getInt(3);
                DefaultMutableTreeNode weekNode = 
                        new DefaultMutableTreeNode("Week " + Integer.toString(this.lastOTweek));
                resultNode.add(weekNode);
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        DefaultTreeModel dataTree = new DefaultTreeModel(rootNode);
        this.treeOT.setModel(dataTree);
        dc.closeConnection();
    }

    private void createPayTree(){
        DataConnection dc = new DataConnection ();
        ResultSet rs;
        dc.connect();
         
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Pay History");
        String query1 = "SELECT * FROM PayHistory ORDER BY PayYear,PayMonth,PayDay ASC";
        try{
            rs = dc.dbQuery(query1);
            DefaultMutableTreeNode resultNode=null;

            while(rs.next()){
                this.lastPayYear = rs.getInt(2);
                if(resultNode==null||!(resultNode.toString().equalsIgnoreCase(Integer.toString(this.lastPayYear))))
                {
                    resultNode = new DefaultMutableTreeNode(Integer.toString(rs.getInt(2)));
                    rootNode.add(resultNode);
                }
                this.lastPayMonth = rs.getInt(3);
                DefaultMutableTreeNode monthNode = 
                        new DefaultMutableTreeNode(getMonth(this.lastPayMonth) + " " + rs.getInt(4));
                resultNode.add(monthNode);

            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        DefaultTreeModel dataTree = new DefaultTreeModel(rootNode);
        
        this.treePay.removeAll();

        this.treePay.setModel(dataTree);
        dc.closeConnection();
    }

    private void saveTableChanges(){
        int otRowCount = this.tblOT.getModel().getRowCount();
        int payRowCount= this.tblPay.getModel().getRowCount();
        DataConnection dc = new DataConnection();
        dc.connect();

        if(otRowCount>0){
            for(int counter = 0; counter<otRowCount; counter++){
                dc.updateOTflags((Integer)this.tblOT.getModel().getValueAt(counter, 0),
                        (Boolean)this.tblOT.getModel().getValueAt(counter,3),
                        (Boolean)this.tblOT.getModel().getValueAt(counter,5),
                        (Boolean)this.tblOT.getModel().getValueAt(counter,7));
            }
        }

        if(payRowCount>0){
            for(int counter = 0; counter<payRowCount; counter++){
                DateFormat formatter;
                formatter = new SimpleDateFormat("MM/dd/yyyy");
                String test = (String)this.tblPay.getModel().getValueAt(counter,1);

                //check if date value has been entered. if not entered skip line
                if(test.length()>7)
                {
                    try{
                        java.util.Date temp = formatter.parse(test);
                        java.util.Calendar now = java.util.Calendar.getInstance();
                        now.setTime(temp);

                        dc.updatePayHrs((Integer)this.tblPay.getModel().getValueAt(counter, 0),
                            now.get(java.util.Calendar.YEAR),now.get(java.util.Calendar.MONTH),
                            now.get(java.util.Calendar.DAY_OF_MONTH),
                            (Double)this.tblPay.getModel().getValueAt(counter, 2),
                            (Double)this.tblPay.getModel().getValueAt(counter, 4),
                            (Double)this.tblPay.getModel().getValueAt(counter, 6),
                            (Boolean)this.tblPay.getModel().getValueAt(counter, 3),
                            (Boolean)this.tblPay.getModel().getValueAt(counter, 5),
                            (Boolean)this.tblPay.getModel().getValueAt(counter, 7));
                        
                    } catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
        }


        dc.closeConnection();

    }

    private String getMonth(int month){
        switch(month){
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return "error";
        }
    }

    private int getMonth(String month){

        if(month.equalsIgnoreCase("January"))
            return 0;
        else if(month.equalsIgnoreCase("February"))
            return 1;
        else if(month.equalsIgnoreCase("March"))
            return 2;
        else if(month.equalsIgnoreCase("April"))
            return 3;
        else if(month.equalsIgnoreCase("May"))
            return 4;
        else if(month.equalsIgnoreCase("June"))
            return 5;
        else if(month.equalsIgnoreCase("July"))
            return 6;
        else if(month.equalsIgnoreCase("August"))
            return 7;
        else if(month.equalsIgnoreCase("September"))
            return 8;
        else if(month.equalsIgnoreCase("October"))
            return 9;
        else if(month.equalsIgnoreCase("November"))
            return 10;
        else if(month.equalsIgnoreCase("December"))
            return 11;
        else
            return 0;


    }
    
    /**
     * remove any 0 hour entries in the OT database
     */

    private void cleanOTdb(){
        DataConnection dc = new DataConnection();
        ResultSet rs;
        int rowID;
        dc.connect();

        try{
            String query = "SELECT * FROM OT";
            rs = dc.dbQuery(query);
            while(rs.next()){
                rowID = rs.getInt(1);
                if(rs.getDouble(4)==0&&rs.getDouble(5)==0&&rs.getDouble(6)==0)
                    dc.deleteOTrecord(rowID);
            }
            dc.closeConnection();

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddPayRow;
    private javax.swing.JButton bDelPayRow;
    private javax.swing.JButton bExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lNetDT;
    private javax.swing.JLabel lNetST;
    private javax.swing.JLabel lNetTH;
    private javax.swing.JLabel lOT_DT;
    private javax.swing.JLabel lOT_ST;
    private javax.swing.JLabel lOT_TH;
    private javax.swing.JLabel lPayDT;
    private javax.swing.JLabel lPayST;
    private javax.swing.JLabel lPayTH;
    private javax.swing.JScrollPane scpOT;
    private javax.swing.JScrollPane scpPay;
    private javax.swing.JTable tblOT;
    private javax.swing.JTable tblPay;
    private javax.swing.JTree treeOT;
    private javax.swing.JTree treePay;
    private javax.swing.JScrollPane ttOT;
    private javax.swing.JScrollPane ttPay;
    // End of variables declaration//GEN-END:variables

}

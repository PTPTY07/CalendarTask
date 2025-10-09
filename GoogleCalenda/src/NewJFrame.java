import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewJFrame extends javax.swing.JFrame {
    //dichiaro task manager che gestirà le task
    TaskManager taskManager = new TaskManager();
    //showallTS = true -> mostra tutte le task
    boolean showallTS = true;
    
    public NewJFrame() throws IOException {
        initComponents();
        //carichiamo le task da file, path dichiarato in taskManager
        taskManager.caricaDaFile(taskManager.getPathTS());
        //aggiorniamo la visualizzazzione della tabella delle task
        // con quelle caricate da file
        AggiornaTabellaTS();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendar = new com.toedter.calendar.JCalendar();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_task = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        button_showTS = new javax.swing.JButton();
        button_addTS = new javax.swing.JButton();
        button_savechange = new javax.swing.JButton();
        button_completTS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_evt = new javax.swing.JTable();
        button_addEV = new javax.swing.JButton();
        button_deleteEV = new javax.swing.JButton();
        button_changeEV = new javax.swing.JButton();
        button_sq = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textarea_showTS = new javax.swing.JTextArea();
        combobox_priorita = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calendar.setTodayButtonText("");
        calendar.setTodayButtonVisible(true);
        getContentPane().add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 460));

        table_task.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        table_task.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "task", "priorità", "completata"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_task.setRowHeight(30);
        table_task.setShowGrid(false);
        table_task.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_taskMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_task);
        // Colonna 0 = "task" → più larga
        table_task.getColumnModel().getColumn(0).setPreferredWidth(220);

        // Colonna 1 = "priorità" → più stretta
        table_task.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_task.getColumnModel().getColumn(2).setPreferredWidth(60);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 360, 470));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 10, 430));

        button_showTS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_showTS.setText("show all/none");
        button_showTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_showTSMouseClicked(evt);
            }
        });
        getContentPane().add(button_showTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 600, 360, 50));

        button_addTS.setText("add task");
        button_addTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_addTSMouseClicked(evt);
            }
        });
        getContentPane().add(button_addTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 660, 120, 40));

        button_savechange.setText("save change");
        button_savechange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_savechangeMouseClicked(evt);
            }
        });
        getContentPane().add(button_savechange, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 660, 120, 40));

        button_completTS.setText("complet task");
        button_completTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_completTSMouseClicked(evt);
            }
        });
        getContentPane().add(button_completTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 120, 40));

        table_evt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ora", "cosa fare", "dove"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_evt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_evtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_evt);
        table_evt.getColumnModel().getColumn(0).setPreferredWidth(40);

        // Colonna 1 = "priorità" → più stretta
        table_evt.getColumnModel().getColumn(1).setPreferredWidth(420);
        table_evt.getColumnModel().getColumn(2).setPreferredWidth(60);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 670, 170));

        button_addEV.setText("add event");
        button_addEV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_addEVMouseClicked(evt);
            }
        });
        getContentPane().add(button_addEV, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 130, 60));

        button_deleteEV.setText("delete event");
        getContentPane().add(button_deleteEV, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 640, 130, 60));

        button_changeEV.setText("save change");
        getContentPane().add(button_changeEV, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, 130, 60));

        button_sq.setText("save and quit");
        button_sq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_sqMouseClicked(evt);
            }
        });
        getContentPane().add(button_sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 710, 510, -1));

        textarea_showTS.setColumns(20);
        textarea_showTS.setLineWrap(true);
        textarea_showTS.setRows(5);
        textarea_showTS.setWrapStyleWord(true);
        jScrollPane3.setViewportView(textarea_showTS);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 310, 100));

        combobox_priorita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        getContentPane().add(combobox_priorita, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 530, 50, 20));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane4.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 670, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_addTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addTSMouseClicked
        //Jtext dove verranno aggiunti i dettagli delle task                       
        JTextField taskField = new JTextField();
        // JComboBox con valori da 1 a 10
        Integer[] prioritaOptions = {1,2,3,4,5,6,7,8,9,10};
        JComboBox<Integer> priorityCombo = new JComboBox<>(prioritaOptions);
        
        //inizializzo variabili locali
        String str_task = null;
        Integer priorita = null;
        boolean taskValido = false;

        //finche non si inserisce un task valido si rimane nella
        //schermata, a meno che non si schiaccia annula
        while (!taskValido) {
            Object[] message = {
                "Task:", taskField,
                "Priorità:", priorityCombo
            };

            int option = JOptionPane.showConfirmDialog(
                this,
                message,
                "Inserisci nuova task",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (option != JOptionPane.OK_OPTION) {
                // Annulla: esci senza fare nulla
                return;
            }
            
            //attribuisce a str_task i dettagli della task
            str_task = taskField.getText().trim();
            //verifica che sia valido l'input
            if (str_task.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inserisci un task valido.");
            } else {
                taskValido = true;
            }
        }

        // Leggi la priorità selezionata dal JComboBox
        priorita = (Integer) priorityCombo.getSelectedItem();

        // Aggiungi i dati alla JTable
        
        TS task_tmp = new TS(str_task, priorita);
        //inserisce la task direttamente in ordine di priorità
        taskManager.addTask(task_tmp);
        AggiornaTabellaTS();
    }//GEN-LAST:event_button_addTSMouseClicked

    private void table_taskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_taskMouseClicked
        //prendo la riga selezionata dalla tabella TS
        int selectedRow = table_task.getSelectedRow();
        // se non è selezionata nessuna riga non faccio nulla
        if (selectedRow != -1) 
        {
            // salvo il contenuto della task selezionata in una variabile (colonna 0 della tabella)
            String taskStr = (String) table_task.getValueAt(selectedRow, 0);

            // leggo il valore della priorità (colonna 1 della tabella)
            Object val = table_task.getValueAt(selectedRow, 1);

            // controllo se il valore è già un intero o una stringa, e lo converto in int
            int priorita = (val instanceof Integer) ? (Integer) val : Integer.parseInt(val.toString());

            // mostro il testo della task nel campo di testo
            textarea_showTS.setText(taskStr);

            // imposto nella combobox la priorità corrispondente
            // (sottraggo 1 perché gli indici della combo partono da 0)
            combobox_priorita.setSelectedIndex(priorita - 1);

            // salvo la task selezionata come temporanea nel task manager
            // utile per modifiche o aggiornamenti successivi
            taskManager.setTemp_TS(taskManager.getTSIndex(selectedRow));
        }
    }//GEN-LAST:event_table_taskMouseClicked

    private void button_savechangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_savechangeMouseClicked
        int selectedRow = table_task.getSelectedRow(); // ottengo la riga selezionata

        // se c'è una riga selezionata e la task temporanea non è completata
        if (selectedRow != -1 && taskManager.getTemp_TS() != null && !taskManager.getTemp_TS().complet) {

            taskManager.removeTask(taskManager.getTemp_TS()); // rimuovo la task temporanea

            String descrizione = textarea_showTS.getText(); // leggo la descrizione aggiornata
            int priorita = Integer.parseInt((String) combobox_priorita.getSelectedItem()); // leggo la priorità selezionata

            TS task_tmp = new TS(descrizione, priorita); // creo una nuova task con i dati aggiornati
            taskManager.addTask(task_tmp); // la aggiungo al task manager
            AggiornaTabellaTS(); // aggiorno la visualizzazione della tabella

            // resetto i campi e selezioni
            textarea_showTS.setText("");
            combobox_priorita.setSelectedIndex(0);
            table_task.clearSelection();
            taskManager.setTemp_TS(null);

        } else {
            // messaggio se nessuna riga selezionata o task completata
            JOptionPane.showMessageDialog(this, "Seleziona prima una riga da modificare che non sia completata.");
        }

    }//GEN-LAST:event_button_savechangeMouseClicked

    private void button_completTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_completTSMouseClicked
        int selectedRow = table_task.getSelectedRow(); // ottengo la riga selezionata
        if (selectedRow != -1) {
            taskManager.markCompleted(taskManager.getTaskList().get(selectedRow));
            AggiornaTabellaTS();
        } else {
            // messaggio se nessuna riga selezionata
            JOptionPane.showMessageDialog(this, "Seleziona prima una riga da modificare.");
        }

    }//GEN-LAST:event_button_completTSMouseClicked

    private void button_showTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_showTSMouseClicked
        showallTS = !showallTS;
        if (showallTS)
            button_showTS.setText("Mostra solo non completate");
        else
            button_showTS.setText("Mostra tutte");
        AggiornaTabellaTS();
    }//GEN-LAST:event_button_showTSMouseClicked

    private void button_sqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_sqMouseClicked
        try {
            taskManager.salvaSuFile(taskManager.getPathTS());
            System.out.println("Salvataggio su file: " + taskManager.getPathTS());
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_button_sqMouseClicked

    private void button_addEVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addEVMouseClicked
        JTextField luogoField = new JTextField();
        JTextField oraField = new JTextField();
        JTextField dettagliField = new JTextField();

        boolean valido = false;
        EVT nuovoEvento = null;

        while (!valido) {
            Object[] message = {
                "Luogo:", luogoField,
                "Ora (HH:mm):", oraField,
                "Dettagli evento:", dettagliField
            };

            int option = JOptionPane.showConfirmDialog(
                this,
                message,
                "Inserisci nuovo evento",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (option != JOptionPane.OK_OPTION) {
                return; // Annullato
            }

            String luogo = luogoField.getText().trim();
            String ora = oraField.getText().trim();
            String dettagli = dettagliField.getText().trim();

            if (luogo.isEmpty() || ora.isEmpty() || dettagli.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Compila tutti i campi.");
            } else {
                nuovoEvento = new EVT(dettagli, luogo, ora);
                valido = true;
            }
        }

        // 🔹 Aggiungi riga nella tabella
        var model = (javax.swing.table.DefaultTableModel) table_evt.getModel();
        model.addRow(new Object[]{nuovoEvento.getOraFormattata(), nuovoEvento.dettagli_evt, nuovoEvento.luogo});

        // 🔹 Riordina le righe in base all'ora (stringa)
        ArrayList<EVT> eventi = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            String ora = (String) model.getValueAt(i, 0);
            String dettagli = (String) model.getValueAt(i, 1);
            String luogo = (String) model.getValueAt(i, 2);
            eventi.add(new EVT(dettagli, luogo, ora));
        }

        EVT.ordinaPerOra(eventi);

        // 🔹 Aggiorna tabella ordinata
        model.setRowCount(0);
        for (EVT e : eventi) {
            model.addRow(new Object[]{e.getOraFormattata(), e.dettagli_evt, e.luogo});
        }
    }//GEN-LAST:event_button_addEVMouseClicked

    private void table_evtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_evtMouseClicked
        table_evt.getSelectedRow();
    }//GEN-LAST:event_table_evtMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    private void AggiornaTabellaTS() {
        var model = (javax.swing.table.DefaultTableModel) table_task.getModel();
        model.setRowCount(0);

        // Aggiungi i task alla JTable rispettando il flag "show"
        for (TS t : taskManager.getTaskList()) {
            if (!t.complet || showallTS) {
                model.addRow(new Object[]{t.str, t.priorita, t.complet});
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_addEV;
    private javax.swing.JButton button_addTS;
    private javax.swing.JButton button_changeEV;
    private javax.swing.JButton button_completTS;
    private javax.swing.JButton button_deleteEV;
    private javax.swing.JButton button_savechange;
    private javax.swing.JButton button_showTS;
    private javax.swing.JButton button_sq;
    private com.toedter.calendar.JCalendar calendar;
    private javax.swing.JComboBox<String> combobox_priorita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable table_evt;
    private javax.swing.JTable table_task;
    private javax.swing.JTextArea textarea_showTS;
    // End of variables declaration//GEN-END:variables
}

package todolistmanager;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Tyler Cromwell
 */
public class TodoListManager extends javax.swing.JFrame {
    private static final String PROGRAM_DIR = "todo";
    private final DefaultListModel listModel;
    private final ArrayList<Task> tasks;

    /**
     * Creates new form TodoListManager
     */
    public TodoListManager() {
        initComponents();

        /* Set the Submit button to react to the "Enter" key */
        this.getRootPane().setDefaultButton(this.taskSubmitButton);

        /* Finish priority initalization */
        for (Priority p : Priority.values()) {
            String name = p.name().toLowerCase();
            this.taskPriorityComboBox.addItem(name.substring(0, 1).toUpperCase() + name.substring(1));
        }
        this.taskPriorityComboBox.setSelectedIndex(Priority.NORMAL.ordinal());

        /* Finish task list initialization */
        this.listModel = (DefaultListModel) this.taskList.getModel();

        /* Finish notes initialization */
        this.taskDetailsArea.setWrapStyleWord(true);
        this.taskDetailsArea.setLineWrap(true);

        /* Initialize task array */
        this.tasks = new ArrayList();

        /* Create list folder */
        File dir = new File(System.getProperty("user.home") +"\\"+ TodoListManager.PROGRAM_DIR);
        dir.mkdir();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        taskListPanel = new javax.swing.JPanel();
        taskListLabel = new javax.swing.JLabel();
        taskButtonPanel = new javax.swing.JPanel();
        addTaskButton = new javax.swing.JButton();
        removeTaskButton = new javax.swing.JButton();
        taskListScrollPane = new javax.swing.JScrollPane();
        taskList = new javax.swing.JList<>();
        taskSubmitButton = new javax.swing.JButton();
        taskDetailsPanel = new javax.swing.JPanel();
        taskDetailsScrollPane = new javax.swing.JScrollPane();
        taskDetailsArea = new javax.swing.JTextArea();
        taskTitleField = new javax.swing.JTextField();
        taskTitleLabel = new javax.swing.JLabel();
        taskNotesLabel = new javax.swing.JLabel();
        taskPriorityLabel = new javax.swing.JLabel();
        taskPriorityComboBox = new javax.swing.JComboBox<>();
        taskDoneCheckBox = new javax.swing.JCheckBox();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        printMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("To-Do List Manager");
        setMinimumSize(new java.awt.Dimension(440, 300));
        setPreferredSize(new java.awt.Dimension(440, 300));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWeights = new double[] {0.0, 1.0};
        layout.rowWeights = new double[] {1.0};
        getContentPane().setLayout(layout);

        java.awt.GridBagLayout taskListPanelLayout = new java.awt.GridBagLayout();
        taskListPanelLayout.columnWeights = new double[] {1.0};
        taskListPanelLayout.rowWeights = new double[] {0.0, 1.0, 0.0, 0.0};
        taskListPanel.setLayout(taskListPanelLayout);

        taskListLabel.setText("Tasks");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        taskListPanel.add(taskListLabel, gridBagConstraints);

        taskButtonPanel.setLayout(new java.awt.GridLayout(1, 0));

        addTaskButton.setText("+");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });
        taskButtonPanel.add(addTaskButton);

        removeTaskButton.setText("-");
        removeTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTaskButtonActionPerformed(evt);
            }
        });
        taskButtonPanel.add(removeTaskButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        taskListPanel.add(taskButtonPanel, gridBagConstraints);

        taskList.setModel(new DefaultListModel());
        taskList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        taskList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                taskListValueChanged(evt);
            }
        });
        taskListScrollPane.setViewportView(taskList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        taskListPanel.add(taskListScrollPane, gridBagConstraints);

        taskSubmitButton.setText("Submit");
        taskSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskSubmitButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        taskListPanel.add(taskSubmitButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        getContentPane().add(taskListPanel, gridBagConstraints);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWeights = new double[] {0.0, 1.0};
        jPanel1Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 1.0};
        taskDetailsPanel.setLayout(jPanel1Layout);

        taskDetailsArea.setColumns(20);
        taskDetailsArea.setRows(5);
        taskDetailsScrollPane.setViewportView(taskDetailsArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        taskDetailsPanel.add(taskDetailsScrollPane, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        taskDetailsPanel.add(taskTitleField, gridBagConstraints);

        taskTitleLabel.setText("Title:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        taskDetailsPanel.add(taskTitleLabel, gridBagConstraints);

        taskNotesLabel.setText("Notes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        taskDetailsPanel.add(taskNotesLabel, gridBagConstraints);

        taskPriorityLabel.setText("Priority:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        taskDetailsPanel.add(taskPriorityLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        taskDetailsPanel.add(taskPriorityComboBox, gridBagConstraints);

        taskDoneCheckBox.setText("Is Done?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        taskDetailsPanel.add(taskDoneCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        getContentPane().add(taskDetailsPanel, gridBagConstraints);

        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        printMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printMenuItem.setText("Print");
        printMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(printMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        /* Clear the fields */
        this.taskTitleField.setText("");
        this.taskDoneCheckBox.setSelected(false);
        this.taskPriorityComboBox.setSelectedIndex(Priority.NORMAL.ordinal());
        this.taskDetailsArea.setText("");

        /* Add and select the new item */
        this.tasks.add(new Task("New Item"));
        this.listModel.addElement("New Item");
        this.taskList.setSelectedIndex(this.listModel.getSize()-1);
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void removeTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTaskButtonActionPerformed
        int selected = this.taskList.getSelectedIndex();

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "You must select a task", "Remove Task", JOptionPane.WARNING_MESSAGE);
        }
        else {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure?");

            if (choice == JOptionPane.YES_OPTION) {
                this.tasks.remove(selected);
                this.listModel.remove(selected);
            }
        }
    }//GEN-LAST:event_removeTaskButtonActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        File root = new File(System.getProperty("user.home") +"\\"+ TodoListManager.PROGRAM_DIR);
        FileSystemView cfsv = new CustomFileSystemView(root);
        JFileChooser chooser = new JFileChooser(cfsv);
        int option = chooser.showSaveDialog(this);

        switch (option) {
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Failed to save file", "Save", JOptionPane.WARNING_MESSAGE);
                return;
            case JFileChooser.CANCEL_OPTION:
                return;
            default:
                break;
        }

        PrintWriter pr;
        try {
            pr = new PrintWriter(chooser.getSelectedFile());
            for(int i = 0; i < this.listModel.getSize(); i++) {
                pr.println("\u2022" + this.tasks.get(i).getTitle());
                //pr.println("\t" + taskDetailsArea.getText());
            }
            pr.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        File root = new File(System.getProperty("user.home") +"\\"+ TodoListManager.PROGRAM_DIR);
        FileSystemView cfsv = new CustomFileSystemView(root);
        JFileChooser chooser = new JFileChooser(cfsv);
        int option = chooser.showOpenDialog(this);

        switch (option) {
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Failed to open file", "Open", JOptionPane.WARNING_MESSAGE);
                return;
            case JFileChooser.CANCEL_OPTION:
                return;
            default:
                break;
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void taskListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_taskListValueChanged
        int index = this.taskList.getSelectedIndex();

        if (index > -1) {
            Task task = this.tasks.get(index);

            /* Update fields */
            this.taskTitleField.setText(task.getTitle());
            this.taskPriorityComboBox.setSelectedIndex(task.getPriority());
            this.taskDoneCheckBox.setSelected(task.getIsDone());
            this.taskDetailsArea.setText(task.getNotes());
        }
        else {
            /* Clear the fields */
            this.taskTitleField.setText("");
            this.taskDoneCheckBox.setSelected(false);
            this.taskPriorityComboBox.setSelectedIndex(Priority.NORMAL.ordinal());
            this.taskDetailsArea.setText("");
        }
    }//GEN-LAST:event_taskListValueChanged

    private void taskSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskSubmitButtonActionPerformed
        int index = this.taskList.getSelectedIndex();

        if (index > -1) {
            Task task = this.tasks.get(index);

            /* Update task */
            task.setTitle(this.taskTitleField.getText());
            task.setPriority(this.taskPriorityComboBox.getSelectedIndex());
            task.setIsDone(this.taskDoneCheckBox.isSelected());
            task.setNotes(this.taskDetailsArea.getText());

            /* Sort based on task Priority */
            this.sortTaskList();
        }
        else {
            /* Either add new item or display warning */
        }
    }//GEN-LAST:event_taskSubmitButtonActionPerformed

    private void printMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printMenuItemActionPerformed
        File root = new File(System.getProperty("user.home") +"\\"+ TodoListManager.PROGRAM_DIR);
        FileSystemView cfsv = new CustomFileSystemView(root);
        JFileChooser chooser = new JFileChooser(cfsv);
        int option = chooser.showOpenDialog(this);

        switch (option) {
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Failed to print file", "Print", JOptionPane.WARNING_MESSAGE);
                return;
            case JFileChooser.CANCEL_OPTION:
                return;
            case JFileChooser.APPROVE_OPTION:
                if (chooser.getSelectedFile().getAbsoluteFile().exists() == false) {
                    JOptionPane.showMessageDialog(this, "File does not exist", "Print", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                break;
            default:
                break;
        }

        File file = chooser.getSelectedFile().getAbsoluteFile();
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new TaskListPrinter(file));

        try {
            if (job.printDialog()) {
                job.print();
            }
        }
        catch(PrinterException pe) {
            if (pe.getMessage() != null) {
                JOptionPane.showMessageDialog(this, pe.getMessage(), "Print", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_printMenuItemActionPerformed

    private void sortTaskList() {
        Collections.sort(this.tasks);
        this.listModel.removeAllElements();

        for (Task task : this.tasks) {
            String selected = task.getTitle();

            if (task.getIsDone() && !selected.matches(".+ \u2713")) {
                selected += " \u2713";
            }
            else if (!task.getIsDone() && selected.matches(".+ \u2713")) {
                int length = selected.length();
                selected = selected.substring(0, length-2);
            }

            this.listModel.addElement(selected);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Use the operating systems Look & Feel */
        String className = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(className);
        }
        catch (ClassNotFoundException | InstantiationException |
               IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TodoListManager main = new TodoListManager();
                main.pack();
                main.setVisible(true);
                main.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JButton removeTaskButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JPanel taskButtonPanel;
    private javax.swing.JTextArea taskDetailsArea;
    private javax.swing.JPanel taskDetailsPanel;
    private javax.swing.JScrollPane taskDetailsScrollPane;
    private javax.swing.JCheckBox taskDoneCheckBox;
    private javax.swing.JList<String> taskList;
    private javax.swing.JLabel taskListLabel;
    private javax.swing.JPanel taskListPanel;
    private javax.swing.JScrollPane taskListScrollPane;
    private javax.swing.JLabel taskNotesLabel;
    private javax.swing.JComboBox<String> taskPriorityComboBox;
    private javax.swing.JLabel taskPriorityLabel;
    private javax.swing.JButton taskSubmitButton;
    private javax.swing.JTextField taskTitleField;
    private javax.swing.JLabel taskTitleLabel;
    // End of variables declaration//GEN-END:variables
}
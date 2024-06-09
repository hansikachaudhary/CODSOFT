 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem extends JFrame {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        setTitle("Student Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Roll Number:"));
        JTextField rollField = new JTextField();
        inputPanel.add(rollField);
        inputPanel.add(new JLabel("Grade:"));
        JTextField gradeField = new JTextField();
        inputPanel.add(gradeField);
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent(nameField.getText(), Integer.parseInt(rollField.getText()), gradeField.getText());
            }
        });
        inputPanel.add(addButton);
        JButton displayButton = new JButton("Display All Students");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllStudents();
            }
        });
        inputPanel.add(displayButton);
        add(inputPanel, BorderLayout.NORTH);

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void addStudent(String name, int rollNumber, String grade) {
        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        displayAllStudents();
    }

    private void displayAllStudents() {
        JTextArea displayArea = (JTextArea) ((JScrollPane) getContentPane().getComponent(1)).getViewport().getView();
        displayArea.setText("");
        for (Student student : students) {
            displayArea.append(student.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementSystem().setVisible(true);
            }
        });
    }
}

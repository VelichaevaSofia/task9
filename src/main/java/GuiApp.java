import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiApp {

    private DefaultListModel<Integer> listModel;

    public GuiApp() {
        JFrame frame = new JFrame("Array Reverser");
        listModel = new DefaultListModel<>();
        JList<Integer> numberList = new JList<>(listModel);
        JButton loadButton = new JButton("Загрузить");
        JButton saveButton = new JButton("Сохранить");
        JButton reverseButton = new JButton("Перевернуть");

        loadButton.addActionListener(e -> loadFromFile());
        saveButton.addActionListener(e -> saveToFile());
        reverseButton.addActionListener(e -> reverseList());

        JPanel panel = new JPanel();
        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(reverseButton);

        frame.add(panel, "North");
        frame.add(new JScrollPane(numberList), "Center");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                List<Integer> list = ArrayProcessor.readFromFile(fileChooser.getSelectedFile().getAbsolutePath());
                listModel.clear();
                for (Integer num : list) {
                    listModel.addElement(num);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ошибка: " + e.getMessage());
            }
        }
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < listModel.size(); i++) {
                    list.add(listModel.get(i));
                }
                ArrayProcessor.writeToFile(fileChooser.getSelectedFile().getAbsolutePath(), list);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ошибка: " + e.getMessage());
            }
        }
    }

    private void reverseList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listModel.size(); i++) {
            list.add(listModel.get(i));
        }
        ArrayProcessor.reverse(list);

        listModel.clear();
        for (Integer num : list) {
            listModel.addElement(num);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiApp::new);
    }
}

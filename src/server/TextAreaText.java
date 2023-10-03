package server;

import javax.swing.*;
import java.awt.*;

public class TextAreaText extends JFrame {
    public TextAreaText()
    {
        super("Пример JTextArea");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Cоздание многострочных полей
        JTextArea area1 = new JTextArea("Многострочное поле", 8, 10);
        // Шрифт и табуляция
        area1.setFont(new Font("Dialog", Font.PLAIN, 14));
        area1.setTabSize(10);

        JTextArea area2 = new JTextArea(15, 10);
        area2.setText("Второе многострочное поле");
        // Параметры переноса слов
        area2.setLineWrap(true);
        area2.setWrapStyleWord(true);

        // Добавим поля в окно
        JPanel contents = new JPanel();
        contents.add(new JScrollPane(area1));
        contents.add(new JScrollPane(area2));
        setContentPane(contents);

        // Выводим окно на экран
        setSize(400, 300);
        setVisible(true);
    }
}

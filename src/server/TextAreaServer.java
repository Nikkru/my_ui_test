package server;

import javax.swing.*;
import java.awt.*;

public class TextAreaServer extends JFrame {
    private static final String MSG_IS_ON = "Сервер уже включен!";
    private static final String MSG_IS_OUT = "Сервер уже выключен!";

    public TextAreaServer()
    {
        super("Сообщение от сервера");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea area1 = new JTextArea(MSG_IS_ON, 0, 0);
        // Шрифт и табуляция
        area1.setFont(new Font("Dialog", Font.PLAIN, 14));
        area1.setTabSize(10);

        // Добавим поля в окно
        JPanel contents = new JPanel();
        contents.add(new JScrollPane(area1));
        setContentPane(contents);

        // Выводим окно на экран
        setSize(400, 300);
//        setVisible(true);
    }
    void msgServer(boolean isOn) {
        TextAreaServer text1;
        text1 = new TextAreaServer();

        if (isOn) {
             text1.setTitle(MSG_IS_ON);
        } else {
            text1.setTitle(MSG_IS_OUT);
        }
        setVisible(true);
    }
}

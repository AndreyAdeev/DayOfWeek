import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;     //подключаем нужные классы и пакеты


public class DayOfWeek implements ActionListener {
    JFrame frame;     // задаем обхект "поле"
    JLabel label, label2, label3, label4;     // задаем объекты для подписи текстовых окон
    JTextField text, text2, text3, text4;     // задаем объект для текстовых окон
    JButton b1;      // задаем объекты для кнопок
    static int x, y, z;     // задаем переменные чисел


    DayOfWeek() {
        frame = new JFrame("Получить день недели.");   // присваеваем объекту "поле" название
        label = new JLabel("Введите день своего рождения, в формате ДД.");   // присваеваем объектам лейбл название
        label2 = new JLabel("Введите месяц своего рождения, в формате ММ.");
        label3 = new JLabel("Введите год своего рождения, в формате ГГГГ.");
        label4 = new JLabel("День недели, в который вы родились:");
        text = new JTextField();   // присваиваем название текстовым полям
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        b1 = new JButton("Нажмите, для получения результата.");     // присваеваем кнопке название
        label.setBounds(40,30,350,25);
        text.setBounds(350,30,80,25);
        label2.setBounds(40,60,350,25);
        text2.setBounds(350,60,80,25);
        label3.setBounds(40,90,350,25);
        text3.setBounds(350,90,80,25);
        b1.setBounds(50,140,270,25);
        label4.setBounds(40,190,350,25);
        text4.setBounds(350,190,80,25);    // указываем размер и расположение объектов на "поле"



        frame.add(label);
        frame.add(text);
        frame.add(label2);
        frame.add(text2);
        frame.add(label3);
        frame.add(text3);
        frame.add(b1);
        frame.add(label4);
        frame.add(text4);     // размещаем объекты на поле


        frame.setLayout(null);      // ставим для "поля" абсалюное позиционирование
        frame.setVisible(true);      // отображаем окно "поля"
        frame.setSize(500,300);     // устанавливаем размер поля
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // остановка программы при закрытии "поля"
        frame.setResizable(false);     // запрет на изменение размера "поля"
        b1.addActionListener(this);    // регистрируем кнопки как источник событий(слушатели действия)
    }

    public void actionPerformed(ActionEvent e) {   // метод для работы с объектами событий

        if(e.getSource() == b1) {         // ссылка на объект события
            x = Integer.parseInt(text.getText());   // присвоение переменным значения из текстовых полей
            y = Integer.parseInt(text2.getText());
            z = Integer.parseInt(text3.getText());

            LocalDate date = LocalDate.of(z, y, x);   // получение даты на основании переменных
            text4.setText("" + date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru")));
            // присвоение значения событию, вывод дня недели в текстовое поле
        }
    }

    public static void main(String[] args) {
        new DayOfWeek();   // вызов конструктора
    }
}

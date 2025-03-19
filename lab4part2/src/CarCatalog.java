import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarCatalog extends JFrame {
    private JComboBox<String> carList;
    private JLabel carImage;
    private JTextArea carDetails;

    public CarCatalog() {
        setTitle("GorillaCars");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель с выпадающим списком
        JPanel topPanel = new JPanel();
        carList = new JComboBox<>();
        topPanel.add(new JLabel("Выберите машину:"));
        topPanel.add(carList);
        add(topPanel, BorderLayout.NORTH);

        // **Основная панель с Фото + Описание**
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Панель с фото машины
        carImage = new JLabel();
        carImage.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(carImage);

        // Панель с характеристиками (Описание справа)
        carDetails = new JTextArea();
        carDetails.setEditable(false);
        carDetails.setLineWrap(true);
        carDetails.setWrapStyleWord(true);
        mainPanel.add(new JScrollPane(carDetails));

        // Добавляем основную панель в центр
        add(mainPanel, BorderLayout.CENTER);

        // Загружаем данные из БД
        loadCars();

        // **Добавляем обработчик событий через `ActionListener`**
        carList.addActionListener(new CarSelectionListener());

        setVisible(true);
    }

    private void loadCars() {
        try {
            ResultSet rs = DataBase.getCars();
            while (rs.next()) {
                carList.addItem(rs.getString("brand") + " " + rs.getString("model"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // **Реализация ActionListener в отдельном классе**
    private class CarSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showCarDetails();
        }
    }

    private void showCarDetails() {
        try {
            ResultSet rs = DataBase.getCars();
            while (rs.next()) {
                String selectedCar = (String) carList.getSelectedItem();
                if (selectedCar.equals(rs.getString("brand") + " " + rs.getString("model"))) {
                    // Показываем характеристики (ОПИСАНИЕ СПРАВА)
                    carDetails.setText(
                            "Марка: " + rs.getString("brand") + "\n" +
                                    "Модель: " + rs.getString("model") + "\n" +
                                    "Год выпуска: " + rs.getInt("year") + "\n" +
                                    "Цена: " + rs.getString("price") + " руб." + "\n" +
                                    "Описание: " + rs.getString("description")
                    );

                    // Загружаем картинку
                    String imageKey = rs.getString("image_key"); // Ключ Active Storage
                    String fileName = rs.getString("filename"); // Оригинальное имя файла

                    // Active Storage кладёт файлы по первым 2 символам ключа
                    String subPath = imageKey.substring(0, 2) + "/" + imageKey.substring(2, 4) + "/";
                    String imagePath = "/Users/kozzze/Desktop/Учеба/5 семестр/Паттерны_проектирования/labs/GorillaCars/storage/"
                            + subPath + imageKey;
                    System.out.println("Используемый путь к файлу: " + imagePath);

                    // Проверяем, существует ли файл
                    File imageFile = new File(imagePath);
                    if (imageFile.exists()) {
                        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage()
                                .getScaledInstance(350, 250, Image.SCALE_SMOOTH)); // Увеличил размер фото
                        carImage.setIcon(icon);
                    } else {
                        System.out.println("Файл не найден: " + imagePath);
                        carImage.setIcon(null);
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CarCatalog();
    }
}
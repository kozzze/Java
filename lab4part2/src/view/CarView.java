package view;

import controller.CarController;
import model.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarView extends JFrame {
    private JComboBox<String> carList;
    private JLabel carImage;
    private JTextArea carDetails;
    private CarController controller;

    public CarView() {
        setTitle("Каталог автомобилей");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        carList = new JComboBox<>();
        topPanel.add(new JLabel("Выберите машину:"));
        topPanel.add(carList);
        add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        carImage = new JLabel();
        carImage.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(carImage);

        carDetails = new JTextArea();
        carDetails.setEditable(false);
        carDetails.setLineWrap(true);
        carDetails.setWrapStyleWord(true);
        mainPanel.add(new JScrollPane(carDetails));

        add(mainPanel, BorderLayout.CENTER);

        carList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                    controller.onCarSelected((String) carList.getSelectedItem());
                }
            }
        });

        setVisible(true);
    }

    public void setController(CarController controller) {
        this.controller = controller;
    }

    public void setCarList(List<Car> cars) {
        carList.removeAllItems();
        for (Car car : cars) {
            carList.addItem(car.getBrand() + " " + car.getModel());
        }
        if (carList.getItemCount() > 0) {
            carList.setSelectedIndex(0);
        }
    }

    public void updateCarDetails(Car car) {
        carDetails.setText("Марка: " + car.getBrand() + "\n" +
                "Модель: " + car.getModel() + "\n" +
                "Год выпуска: " + car.getYear() + "\n" +
                "Цена: " + car.getPrice() + " руб." + "\n" +
                "Описание: " + car.getDescription());

        carImage.setIcon(new ImageIcon(new ImageIcon(car.getImagePath()).getImage()
                .getScaledInstance(350, 250, Image.SCALE_SMOOTH)));
    }
}
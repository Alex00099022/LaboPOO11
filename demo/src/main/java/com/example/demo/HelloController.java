package com.example.demo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Comparator;

public class HelloController {
    @FXML
    private ListView<Empleados> listView;

    private ObservableList<Empleados> empleados;

    @FXML
    public void initialize() {
        empleados = FXCollections.observableArrayList(
                new Empleados("Julio", 32, 5000.0),
                new Empleados("Marcelo", 35, 800.0),
                new Empleados("Danilo", 65, 250.0),
                new Empleados("Ronaldo", 48, 1000.0),
                new Empleados("Messi", 24, 1900.0),
                new Empleados("Neymar", 31, 7000.0),
                new Empleados("Rudi", 50, 300.0),
                new Empleados("Sofia", 29, 1800.0)
        );
        listView.setItems(empleados);
    }

    @FXML
    private void sortByName() {
        FXCollections.sort(empleados, Comparator.comparing(Empleados::getNombre));
    }


    @FXML
    private void sortBySalary() {
        FXCollections.sort(empleados, Comparator.comparingDouble(Empleados::getSalario));
    }


    @FXML
    public void onOrderByNameClick(ActionEvent actionEvent) {
        sortByName();
    }

    @FXML
    public void onOrderByNameClick() {
        sortByName();
    }

    @FXML
    public void onOrderBySalaryClick(ActionEvent actionEvent) {
        sortBySalary();
    }

    @FXML
    public void onOrderBySalaryClick() {
        sortBySalary();
    }

    public static class Empleados {
        private String nombre;
        private int edad;
        private double salario;

        public Empleados(String nombre, int edad, double salario) {
            this.nombre = nombre;
            this.edad = edad;
            this.salario = salario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        @Override
        public String toString() {
            return nombre + " - edad: " + edad + ", Salario: " + salario;
        }
    }
}
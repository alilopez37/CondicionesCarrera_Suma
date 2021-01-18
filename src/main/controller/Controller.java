package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.model.Suma;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnIniciar;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnLimpiar;

    @FXML
    void btnIniciarOnMouseClicked(MouseEvent event) {
        Suma suma;

        suma = new Suma();
        suma.addObserver(this);
        new Thread(suma).start();

        suma = new Suma();
        suma.addObserver(this);
        new Thread(suma).start();

    }

    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        String resultado = (String)arg;

        txtResult.setText( txtResult.getText() + "\n" + resultado);
    }

    @FXML
    void btnLimpiarOnMouseClicked(MouseEvent event) {
        txtResult.clear();
        Suma.valor = 0;
    }
}

package com.resonance.view.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Estrato;
import com.resonance.model.usuarios.NivelEstudio;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

/**
 * Proyecto de programaci�n - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class ControladorRegistro {

	private StageR stage;
	private ResonanceHome resonance;
	private File fileFoto;
	@FXML
	private Text btnAtras;
	@FXML
	private ComboBox<String> cbNivelEstudio;

	@FXML
	private ComboBox<String> cbEstatro;
	
	@FXML
	private ComboBox<String> comboTipoCuenta;
	
	 private ObservableList<String> items = FXCollections.observableArrayList();
	
	@FXML
	private ImageView picPerfil;
	@FXML
	private Button btnSubirFoto;

	@FXML
	private TextField textNombreUsuario;

	@FXML
	private Button quitarFoto;

	@FXML
	private PasswordField textPasswordUsuario;

	@FXML

	private ImageView fotoPerfil;

	@FXML
	private Rectangle rectanguloFoto;

	@FXML
	private Label interrogacionFoto;

	@FXML
	private Button btnContinuar;

	@FXML
	private DatePicker dateFechaNacimiento;

	@FXML
	private TextArea textBiografia;

	@FXML
	private TextField textEmail;

	@FXML
	private TextField textDireccion;

	@FXML
	private TextField textNombreCompleto;

	public void inicializar() {
		cbEstatro.getItems().addAll("Estrato 1", "Estrato 2", "Estrato 3", "Estrato 4", "Estrato 5", "Estrato 6");
		cbNivelEstudio.getItems().addAll("Ninguno", "Bachiller", "Tecnico", "Tecnologo", "Pregrado", "Maestria",
				"Doctorado");
		comboTipoCuenta.valueProperty().addListener((obs, oldItem, newItem) -> {
			if (newItem != null) {
				if (newItem.equalsIgnoreCase("huesped")) {
					cbEstatro.setVisible(true);
					cbNivelEstudio.setVisible(true);
				} else {
					cbEstatro.setVisible(false);
					cbNivelEstudio.setVisible(false);
				}
			}
		});

		inicializarCombo();
		continuar();
		atras();
	}
	public void subirFoto() {

		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

		);

		File selectedFile = fileChooser.showOpenDialog(stage);
		fileFoto = selectedFile;

		if (selectedFile != null) {
			rectanguloFoto.setVisible(false);
			interrogacionFoto.setVisible(false);
			quitarFoto.setVisible(true);

			Image image = new Image(selectedFile.toURI().toString());
			picPerfil.setImage(image);

		} else {
			rectanguloFoto.setVisible(true);
			interrogacionFoto.setVisible(true);
		}

	}

	public void quitarFoto() {

		quitarFoto.setVisible(false);
		picPerfil.setImage(null);

		rectanguloFoto.setVisible(true);
		interrogacionFoto.setVisible(true);

	}
	
	public void inicializarCombo() {
		
		items.add("Huesped");
		items.add("Anfitrion");
		
    	comboTipoCuenta.getItems().addAll(items);
	}
	

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	private void continuar() {
		btnContinuar.setOnMouseClicked((e) -> {
			String nombre = textNombreCompleto.getText();
			LocalDate fecha = dateFechaNacimiento.getValue();
			String email = textEmail.getText();
			String direccion = textDireccion.getText();
			String nametag = textNombreUsuario.getText();
			String clave = textPasswordUsuario.getText();
			String biografia = textBiografia.getText();
			String urlFoto = "";
			String estrato = cbEstatro.getValue();
			String nivelE = cbNivelEstudio.getValue();
			Date date = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
			if (fileFoto != null)
				urlFoto = fileFoto.getAbsolutePath();
			if (comboTipoCuenta.getValue().equals("Anfitrion")) {
				resonance.agregarAnfitrion(nombre, email, urlFoto, direccion, date, clave, biografia, nametag);

					stage.setAnfitrionLogin(resonance.obtenerAnfitrion(nametag));

			} else {
				resonance.agregarHuesped(nombre, email, urlFoto, direccion, date, clave, biografia, nametag,
						Estrato.getValue(estrato), NivelEstudio.getValue(nivelE));
					stage.setHuespedLogeado(resonance.obtenerHuesped(nametag));

			}
			
			String datos = nombre + "\n" + "Correo: " + email + "\n" + "Nametag: " + nametag + "\n" + "Contrase�a: "
					+ clave;
			resonance.enviarCorreoBienvenida(datos, stage.getUsuarioLogeado().getEmail());
			showConfirmation("Hospedaje creado", "Se�or/a su cuenta ha sido creada con exito!");
			abrirVentanaPrincipal();

		});
	}

	public static void showConfirmation(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("Warning");
		alert.setHeaderText(title);
		alert.setContentText(message);

		alert.showAndWait();
	}

	private void atras() {
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();

		});
	}

	public void abrirVentanaPrincipal() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		try {
			Parent root = loader.load();
			limpiarCampos();
			ControladorPrincipal control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
			stage.getScene().setRoot(root);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		try {
			Parent root = loader.load();
			Util.updateController(loader, stage, resonance);
			stage.getScene().setRoot(root);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void limpiarCampos() {
		textNombreCompleto.setText("");
		textEmail.setText("");
		textDireccion.setText("");
		textDireccion.setText("");
		textNombreUsuario.setText("");
		textPasswordUsuario.setText("");
		textBiografia.setText("");
	}

}

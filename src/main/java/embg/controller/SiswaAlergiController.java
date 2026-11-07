/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package embg.controller;

import embg.model.SiswaAlergi;
import embg.service.SiswaAlergiService;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author lenovo
 */
public class SiswaAlergiController {
    private final SiswaAlergiService service = new SiswaAlergiService();
 
    private static final int SEKOLAH_ID = 1;
 
    @FXML private TextField inputNama;
    @FXML private TextField inputAlergi;
    @FXML private VBox listSiswaContainer;
    @FXML private Label emptyStateLabel;
 
    @FXML
    private void initialize() {
        muatDaftar();
    }
 
    @FXML
    private void handleSimpanSiswa() {
        String nama = inputNama.getText().trim();
        String alergi = inputAlergi.getText().trim();
 
        if (nama.isEmpty() || alergi.isEmpty()) {
            tampilPesan(Alert.AlertType.WARNING, "Nama dan alergi wajib diisi.");
            return;
        }
        try {
            service.tambahDataAlergi(SEKOLAH_ID, nama, alergi);
            inputNama.clear();
            inputAlergi.clear();
            muatDaftar();
        } catch (Exception e) {
            tampilPesan(Alert.AlertType.ERROR, "Gagal menyimpan: " + penyebab(e));
        }
    }
 
    private void muatDaftar() {
        listSiswaContainer.getChildren().clear();
        try {
            List<SiswaAlergi> daftar = service.daftarAlergiSekolah(SEKOLAH_ID);
            boolean kosong = daftar.isEmpty();
            emptyStateLabel.setVisible(kosong);
            emptyStateLabel.setManaged(kosong);
            for (SiswaAlergi s : daftar) {
                listSiswaContainer.getChildren().add(buatBaris(s));
            }
        } catch (Exception e) {
            tampilPesan(Alert.AlertType.ERROR, "Gagal memuat data: " + penyebab(e));
        }
    }
 
    private HBox buatBaris(SiswaAlergi s) {
        Label nama = new Label(s.getNamaSiswa());
        nama.getStyleClass().add("text-primary");
        Label alergi = new Label("Alergi: " + s.getJenisAlergi());
        alergi.getStyleClass().add("text-secondary");
 
        VBox teks = new VBox(2, nama, alergi);
        HBox.setHgrow(teks, Priority.ALWAYS);
 
        Button hapus = new Button("Hapus");
        hapus.getStyleClass().add("btn-hapus");
        hapus.setAccessibleText("Hapus data " + s.getNamaSiswa());
        hapus.setOnAction(e -> hapusSiswa(s));
 
        HBox baris = new HBox(8, teks, hapus);
        baris.getStyleClass().add("list-item");
        baris.setAlignment(Pos.CENTER_LEFT);
        return baris;
    }
 
    private void hapusSiswa(SiswaAlergi s) {
        ButtonType ya = new ButtonType("Hapus", ButtonBar.ButtonData.OK_DONE);
        ButtonType batal = new ButtonType("Batal", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert tanya = new Alert(Alert.AlertType.CONFIRMATION,
                "Hapus data " + s.getNamaSiswa() + "?", ya, batal);
        tanya.setHeaderText(null);
 
        Optional<ButtonType> jawab = tanya.showAndWait();
        if (jawab.isEmpty() || jawab.get() != ya) {
            return;
        }
        try {
            service.hapusDataAlergi(s.getId());
            muatDaftar();
        } catch (Exception e) {
            tampilPesan(Alert.AlertType.ERROR, "Gagal menghapus: " + penyebab(e));
        }
    }
 
    private void tampilPesan(Alert.AlertType tipe, String isi) {
        Alert a = new Alert(tipe, isi);
        a.setHeaderText(null);
        a.showAndWait();
    }
 
    private String penyebab(Exception e) {
        Throwable t = e;
        while (t.getCause() != null) {
            t = t.getCause();
        }
        return t.getMessage();
    }
}

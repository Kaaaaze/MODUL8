/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package embg.model;

/**
 *
 * @author lenovo
 */
public class SiswaAlergi {
    private int id;
    private int sekolahId;
    private String namaSiswa;
    private String jenisAlergi;

    public SiswaAlergi(int id, int sekolahId, String namaSiswa, String jenisAlergi) {
        this.id = id;
        this.sekolahId = sekolahId;
        this.namaSiswa = namaSiswa;
        this.jenisAlergi = jenisAlergi;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSekolahId() { return sekolahId; }
    public void setSekolahId(int sekolahId) { this.sekolahId = sekolahId; }

    public String getNamaSiswa() { return namaSiswa; }
    public void setNamaSiswa(String namaSiswa) { this.namaSiswa = namaSiswa; }

    public String getJenisAlergi() { return jenisAlergi; }
    public void setJenisAlergi(String jenisAlergi) { this.jenisAlergi = jenisAlergi; }
}
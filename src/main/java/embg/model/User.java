/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package embg.model;

/**
 *
 * @author lenovo
 */
public class User {
    private int id;
    private String npsn;
    private String namaSekolah;
    private String role;
    
    public User(int id, String npsn, String namaSekolah, String role){
        this.id = id;
        this.npsn = npsn;
        this.namaSekolah = namaSekolah;
        this.role = role;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getnpsn() { return npsn; }
    public void setNpsn(String npsn) { this.npsn = npsn; }
    
    public String getnamaSekolah() { return namaSekolah; }
    public void setNamaSekolah(String namaSekolah) { this.namaSekolah = namaSekolah; }
    
    public String getrole() { return role; }
    public void setRole(String role) { this.role = role; }
}

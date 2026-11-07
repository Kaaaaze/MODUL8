/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package embg.service;

import embg.model.SiswaAlergi;
import embg.interfaces.SiswaAlergiRepositoryInterface;
import embg.repository.SiswaAlergiRepository;
import java.util.List;
/**
 *
 * @author lenovo
 */
public class SiswaAlergiService {
    private final SiswaAlergiRepositoryInterface repository;
 
    public SiswaAlergiService(SiswaAlergiRepositoryInterface repository) {
        this.repository = repository;
    }
 
    public void tambahDataAlergi(int sekolahId, String nama, String jenisAlergi) {
        if (nama == null || nama.trim().isEmpty() || jenisAlergi == null || jenisAlergi.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama dan jenis alergi tidak boleh kosong");
        }
        
        SiswaAlergi siswaBaru = new SiswaAlergi(0, sekolahId, nama, jenisAlergi);
        repository.tambahSiswa(siswaBaru);
    }
 
    public List<SiswaAlergi> daftarAlergiSekolah(int sekolahId) {
        return repository.ambilBySekolah(sekolahId);
    }
 
    public void hapusDataAlergi(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Data yang mau dihapus tidak valid");
        }
        repository.hapusSiswa(id);
    }
}

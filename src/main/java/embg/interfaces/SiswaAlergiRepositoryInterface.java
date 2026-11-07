/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package embg.interfaces;

import java.util.List;
import embg.model.SiswaAlergi;
/**
 *
 * @author lenovo
 */
public interface SiswaAlergiRepositoryInterface {
    void tambahSiswa(SiswaAlergi siswa);
    List<SiswaAlergi> ambilBySekolah(int sekolahId);
    void hapusSiswa(int id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package embg.controller;

import embg.model.SiswaAlergi;
import embg.service.SiswaAlergiService;
import java.util.List;
/**
 *
 * @author lenovo
 */
public class SiswaAlergiController {
    private final SiswaAlergiService service;

    public SiswaAlergiController() {
        this.service = new SiswaAlergiService();
    }

    public void simpanSiswaAlergi(int sekolahId, String nama, String alergi) {
        try {
            service.tambahDataAlergi(sekolahId, nama, alergi);
        } catch (Exception e) {
            throw new RuntimeException("Controller gagal menyimpan: " + e.getMessage());
        }
    }

    public List<SiswaAlergi> muatDaftarAlergi(int sekolahId) {
        return service.daftarAlergiSekolah(sekolahId);
    }
}
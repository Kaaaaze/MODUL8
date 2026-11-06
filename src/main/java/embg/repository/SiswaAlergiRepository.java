/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package embg.repository;

import embg.model.SiswaAlergi;
import embg.util.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class SiswaAlergiRepository {

    public void tambahSiswa(SiswaAlergi siswa) {
        String sql = "INSERT INTO siswa_alergi (sekolah_id, nama_siswa, jenis_alergi) VALUES (?, ?, ?)";
        
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, siswa.getSekolahId());
            stmt.setString(2, siswa.getNamaSiswa());
            stmt.setString(3, siswa.getJenisAlergi());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Gagal menyimpan data siswa alergi", e);
        }
    }

    public List<SiswaAlergi> ambilBySekolah(int sekolahId) {
        List<SiswaAlergi> list = new ArrayList<>();
        String sql = "SELECT * FROM siswa_alergi WHERE sekolah_id = ?";
        
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, sekolahId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                list.add(new SiswaAlergi(
                    rs.getInt("id"),
                    rs.getInt("sekolah_id"),
                    rs.getString("nama_siswa"),
                    rs.getString("jenis_alergi")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data siswa alergi", e);
        }
        
        return list;
    }
}
package apap.sisdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import apap.sisdm.model.SertifikasiKaryawanModel;

import java.util.List;

@Repository
public interface SertifikasiKaryawanDb extends JpaRepository <SertifikasiKaryawanModel,String> {
@Query(value = "SELECT * \n" +
        "FROM sertifikasi S \n" +
        "JOIN sertifikasikaryawan SK ON S.id_sertifikasi = SK.sertifikasi_id_sertifikasi \n" +
        "JOIN karyawan K ON SK.karyawan_id_karyawan = K.id_karyawan \n" +
        "WHERE S.id_sertifikasi = :idSertifikasi", nativeQuery = true)
    List<SertifikasiKaryawanModel> findAllBySertifikasi (Long idSertifikasi);

@Query(value = "SELECT * \n" +
            "FROM sertifikasi S \n" +
            "JOIN sertifikasikaryawan SK ON S.id_sertifikasi = SK.sertifikasi_id_sertifikasi \n" +
            "JOIN karyawan K ON SK.karyawan_id_karyawan = K.id_karyawan \n" +
            "WHERE K.id_karyawan = :idKaryawan", nativeQuery = true)
    List<SertifikasiKaryawanModel> findAllByKaryawan (Long idKaryawan);
}
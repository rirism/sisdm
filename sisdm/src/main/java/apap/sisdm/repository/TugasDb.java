package apap.sisdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import apap.sisdm.model.TugasModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface TugasDb extends JpaRepository<TugasModel, String> {
    // JPA
    Optional<TugasModel> findAllByPresensi_IdPresensi(Long idPresensi);

    @Query(value = "SELECT *\n" +
            "FROM presensi P\n" +
            "JOIN karyawan K ON P.id_karyawan = K.id_karyawan\n" +
            "JOIN tugas T ON P.id_presensi = T.id_presensi\n" +
            "WHERE K.id_karyawan = :idKaryawan AND T.status_tugas = :statusTugas", nativeQuery = true)
    List<TugasModel> findAllByKaryawanAndStatusTugas (Long idKaryawan, Integer statusTugas);
}
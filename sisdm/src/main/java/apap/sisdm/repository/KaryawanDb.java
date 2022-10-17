package apap.sisdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.sisdm.model.KaryawanModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface KaryawanDb extends JpaRepository<KaryawanModel, String> {
    // JPA
    Optional<KaryawanModel> findByIdKaryawan(Long idKaryawan);
    List<KaryawanModel> findAllBySertifikasiKaryawan(Long idSertifikasi);
}

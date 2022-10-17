package apap.sisdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.sisdm.model.PresensiModel;

import java.util.Optional;

@Repository
public interface PresensiDb extends JpaRepository<PresensiModel, String> {
    // JPA
    Optional<PresensiModel> findByIdPresensi(Long idPresensi);
}

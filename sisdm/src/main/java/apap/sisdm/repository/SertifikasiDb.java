package apap.sisdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.sisdm.model.SertifikasiModel;

@Repository
public interface SertifikasiDb extends JpaRepository <SertifikasiModel, String> {
}

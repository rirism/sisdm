package apap.sisdm.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SertifikasiKaryawanKey implements Serializable{
    @Column(name = "idSertifikasi")
    Long idSertifikasi;

    @Column(name = "idKaryawan")
    Long idKaryawan;
}

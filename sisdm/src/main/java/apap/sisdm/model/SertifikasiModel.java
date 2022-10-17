package apap.sisdm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sertifikasi")

public class SertifikasiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSertifikasi;

    @NotNull
    @Size(max=255)
    @Column(name = "nama_sertifikasi", nullable = false)
    private String namaSertifikasi;

    @OneToMany(mappedBy = "sertifikasi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SertifikasiKaryawanModel> sertifikasiKaryawan;

//    // Relasi dengan DokterPasien
//    @OneToMany(mappedBy = "karyawan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<SertifikasiKaryawanModel> listSertifikasiKaryawan;
}

package apap.sisdm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sertifikasikaryawan")

public class SertifikasiKaryawanModel {

    @EmbeddedId
    SertifikasiKaryawanKey id;

    @ManyToOne
    @MapsId("idSertifikasi")
    private SertifikasiModel sertifikasi;

    @ManyToOne
    @MapsId("idKaryawan")
    private KaryawanModel karyawan;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalPengambilan;

    @NotNull
    @Size(min = 14,max = 14)
    @Column(name = "noSertifikasi", nullable = false)
    private String noSertifikasi;
}

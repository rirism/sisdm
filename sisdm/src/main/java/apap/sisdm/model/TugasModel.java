package apap.sisdm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tugas")

public class TugasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTugas;

    @NotNull
    @Size(max=255)
    @Column(name = "nama_tugas", nullable = false)
    private String namaTugas;

    @NotNull
    @Size(max=255)
    @Column(name = "deskripsi_tugas", nullable = false)
    private String deskripsiTugas;

    @NotNull
    @Column(name = "story_point", nullable = false)
    private Integer storyPoint;

    @NotNull
    @Column(name = "status_tugas", nullable = false)
    private Integer statusTugas;

    // Relasi dengan Presensi
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "idPresensi", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PresensiModel presensi;
}

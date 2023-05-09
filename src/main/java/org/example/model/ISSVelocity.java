package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "iss_velocity")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ISSVelocity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private int measurementId;
    @Column(name = "velocity")
    private int velocity;

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "iss_location_id")
    private ISSLocation issLocation;

    public ISSVelocity(int velocity) {
        this.velocity = velocity;
    }

}

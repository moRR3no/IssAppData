package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "iss_location")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ISSLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iss_id")
    private int issId;
    @Column(name = "timestamp")
    private int timestamp;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "issLocation")
    @JoinColumn(name = "velocity_id")
    private ISSVelocity velocity;

    public ISSLocation(int timestamp, double latitude, double longitude) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

package org.example.utils;

import org.example.model.ISSLocation;
import org.example.model.ISSVelocity;

public class SpeedCalculator {

    public ISSVelocity calculateSpeed(ISSLocation location1, ISSLocation location2) {


        double distance = distanceOnGeoidInMeters(location1.getLatitude(), location1.getLongitude(),
                location2.getLatitude(), location2.getLongitude());
        double timestampsDifference = (location2.getTimestamp() - location1.getTimestamp());
        double speed_mps = distance/timestampsDifference;

        // value in kph
        double speed_kph = (speed_mps*3600.0) / 1000.0;

        return new ISSVelocity((int)speed_kph);
    }

    private double distanceOnGeoidInMeters (double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        lat1 = degreesToRadians(lat1);
        lon1 = degreesToRadians(lon1);
        lat2 = degreesToRadians(lat2);
        lon2 = degreesToRadians(lon2);

        // radius of earth in metres
        double r = 6378100 + 408000;

        // P
        double rho1 = r * Math.cos(lat1);
        double z1 = r * Math.sin(lat1);
        double x1 = rho1 * Math.cos(lon1);
        double y1 = rho1 * Math.sin(lon1);

        //Q
        double rho2 = r * Math.cos(lat2);
        double z2 = r * Math.sin(lat2);
        double x2 = rho2 * Math.cos(lon2);
        double y2 = rho2 * Math.sin(lon2);

        //Dot product
        double dot = (x1 * x2 + y1 * y2 + z1 * z2);
        double cos_theta = dot / (r * r);
        double theta = Math.acos(cos_theta);

        //Distance in meters
        return r * theta;
    }

    private double degreesToRadians (double degrees) {
        return degrees * Math.PI/180;
    }
}

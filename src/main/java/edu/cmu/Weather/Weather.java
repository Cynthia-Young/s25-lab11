package edu.cmu.Weather;

public class Weather {
    private WeatherService weatherService;
    // private boolean inches;

    /**
     * Enumeration of possible length units for rainfall measurements.
     */
    public enum LengthUnit {
        INCHES,
        MILLIMETERS
    }

    private LengthUnit unit = LengthUnit.MILLIMETERS; // Default to millimeters

    /**
     * Sets the length units for rainfall.
     *
     * @param unit The unit to use for rainfall measurements (INCHES or MILLIMETERS)
     */
    public void setLengthScale(LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Length unit cannot be null");
        }
        this.unit = unit;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     * 
     * @return the rainfall amount in the preferred unit (as set by setLengthUnit).
     *         The weather service provides data in millimeters, so conversion is performed
     *         if INCHES is selected as the unit.
     */
    public double getRainfall() {
        double rainfallInMillimeters = weatherService.getRainfall();
        if (unit == LengthUnit.INCHES) {
            return rainfallInMillimeters / 25.4; // Convert millimeters to inches
        } else {
            return rainfallInMillimeters; // Return as is (in millimeters)
        }
    }
}

// U2. Be consistent
// Q3. Make it easy for user to do what's preferable
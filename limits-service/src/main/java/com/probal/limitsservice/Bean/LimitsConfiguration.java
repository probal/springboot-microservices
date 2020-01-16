package com.probal.limitsservice.Bean;

public class LimitsConfiguration {

    private int maximum;

    private int minimum;

    public LimitsConfiguration(int maximum, int minimum) {
        super();
        this.maximum = maximum;
        this.minimum = minimum;
    }

    protected LimitsConfiguration() {
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }

}

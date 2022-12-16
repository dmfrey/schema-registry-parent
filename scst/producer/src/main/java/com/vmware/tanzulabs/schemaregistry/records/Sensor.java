package com.vmware.tanzulabs.schemaregistry.records;

import java.util.Objects;

public final class Sensor {
    private final String id;
    private final float temperature;
    private final float acceleration;
    private final float velocity;

    public Sensor(String id, float temperature, float acceleration, float velocity) {
        this.id = id;
        this.temperature = temperature;
        this.acceleration = acceleration;
        this.velocity = velocity;
    }

    public String id() {
        return id;
    }

    public float temperature() {
        return temperature;
    }

    public float acceleration() {
        return acceleration;
    }

    public float velocity() {
        return velocity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Sensor) obj;
        return Objects.equals(this.id, that.id) &&
                Float.floatToIntBits(this.temperature) == Float.floatToIntBits(that.temperature) &&
                Float.floatToIntBits(this.acceleration) == Float.floatToIntBits(that.acceleration) &&
                Float.floatToIntBits(this.velocity) == Float.floatToIntBits(that.velocity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, acceleration, velocity);
    }

    @Override
    public String toString() {
        return "Sensor[" +
                "id=" + id + ", " +
                "temperature=" + temperature + ", " +
                "acceleration=" + acceleration + ", " +
                "velocity=" + velocity + ']';
    }


}

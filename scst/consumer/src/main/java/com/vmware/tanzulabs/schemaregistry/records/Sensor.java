package com.vmware.tanzulabs.schemaregistry.records;

import java.util.Objects;

public final class Sensor {
    private String id;
    private float temperature;
    private float acceleration;
    private float velocity;

    public Sensor() { }

    public String getId() {

        return id;
    }

    public void setId( String id ) {

        this.id = id;

    }

    public float getTemperature() {

        return temperature;
    }

    public void setTemperature( float temperature ) {

        this.temperature = temperature;

    }

    public float getAcceleration() {

        return acceleration;
    }

    public void setAcceleration( float acceleration ) {

        this.acceleration = acceleration;

    }

    public float getVelocity() {

        return velocity;
    }

    public void setVelocity( float velocity ) {

        this.velocity = velocity;

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

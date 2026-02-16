package org.vaadin.addons.maplibre.dto;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Point;
import tools.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = LngLatSerializer.class)
public record LngLat(double lng, double lat) {

    public static LngLat of(Point p) {
        return new LngLat(p.getX(), p.getY());
    }

    public static LngLat of(Coordinate c) {
        return new LngLat(c.getX(),c.getY());
    }
}

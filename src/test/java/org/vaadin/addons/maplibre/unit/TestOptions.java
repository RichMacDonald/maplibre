package org.vaadin.addons.maplibre.unit;

import org.junit.jupiter.api.Test;
import org.vaadin.addons.maplibre.dto.FlyToOptions;
import org.vaadin.addons.maplibre.dto.LngLat;

public class TestOptions {

    @Test
    void testFlyTyOptions() {
        FlyToOptions flyToOptions = new FlyToOptions();
        flyToOptions.setBearing(33.3);
        System.out.println(flyToOptions);

        flyToOptions.setBearing(null);
        System.out.println(flyToOptions);

        flyToOptions.setCenter(new LngLat(62, 22));
        System.out.println(flyToOptions);

    }

}

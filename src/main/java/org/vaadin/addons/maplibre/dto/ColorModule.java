package org.vaadin.addons.maplibre.dto;

import tools.jackson.databind.module.SimpleModule;

public class ColorModule extends SimpleModule {
    public ColorModule() {
        addSerializer(new ColorSerializer());
    }
}

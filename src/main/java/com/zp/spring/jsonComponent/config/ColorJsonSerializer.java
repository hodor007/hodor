/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.spring.jsonComponent.config;


import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javafx.scene.paint.Color;

/**
 * Description:
 * Date: 2019-01-08
 *
 * @author zhengpeng
 */
@JsonComponent
public class ColorJsonSerializer extends JsonSerializer<Color> {

    @Override
    public void serialize(Color color, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(
                "favoriteColor",
                getColorAsWebColor(color));
        jsonGenerator.writeEndObject();
    }

    private String getColorAsWebColor(Color color) {
        int r = (int) Math.round(color.getRed() * 255.0);
        int g = (int) Math.round(color.getGreen() * 255.0);
        int b = (int) Math.round(color.getBlue() * 255.0);
        return String.format("#%02x%02x%02x", r, g, b);
    }
}

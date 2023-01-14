package com.daviddorado.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Archivo de configuración para ir indicando los archivos de propiedades ajenos a application.properties
 * @author CursosDavid
 *
 */

@Configuration
@PropertySources({
	@PropertySource("classpath:strings.properties")
})
public class TextosPropertiesConfig {

}

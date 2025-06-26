package com.aluracursos.literalura_latina.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}

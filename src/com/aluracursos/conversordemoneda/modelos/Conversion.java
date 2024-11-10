package com.aluracursos.conversordemoneda.modelos;

import com.google.gson.annotations.SerializedName;

public class Conversion {
    @SerializedName("conversion_result")
    private String resultado;

    public Conversion(String resultado){
        this.resultado = resultado;
    }


    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return
                "$" + resultado;
    }
}

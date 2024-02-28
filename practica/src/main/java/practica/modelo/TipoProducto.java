package practica.modelo;

public enum TipoProducto {
    ALIMENTO(0), BEBIDA(1), PAPELERIA(2), HIGIENE(3);


    /**
     * atributos
     */
    private int numTipo;

    /**
     * Constructor
     * @param tipo
     */
    private TipoProducto(int tipo) {
        numTipo = tipo;
    }

    /**
     * Metodo Get
     * @return
     */
    public int getNumTipo() {
        return numTipo;
    }
}

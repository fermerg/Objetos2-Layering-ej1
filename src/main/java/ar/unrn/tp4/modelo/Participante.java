package ar.unrn.tp4.modelo;

public class Participante {
    private final String nombre;
    private final String telefono;
    private final String region;

    public Participante(String nombre, String telefono, String region) {
        if (validarDato(nombre)) {
            throw new RuntimeException("Debe cargar un nombre");
        }
        if (validarDato(telefono)) {
            throw new RuntimeException("Debe cargar un telefono");
        }
        if (validarDato(region)) {
            throw new RuntimeException("Debe cargar una region");
        }
        if (!validarTelefono(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (validarRegion(region)) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private boolean validarDato(String dato) {
        return dato.equals("");
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    private boolean validarRegion(String region) {
        return (!region.equals("China") && !region.equals("US") && !region.equals("Europa"));
    }

    public String nombre() {
        return nombre;
    }

    public String telefono() {
        return telefono;
    }

    public String region() {
        return region;
    }
}

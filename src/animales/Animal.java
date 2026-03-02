package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * Clase abstracta que representa un Animal.
 */
public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

    /**
     * Constructor de la clase Animal.
     * Crea un nuevo objeto Animal con un código identificativo, fecha de nacimiento, sexo y peso.
     * Realiza validaciones sobre los parámetros:
     * El código debe tener exactamente 5 caracteres que sean dígitos (0-9) o letras minúsculas (a-z)
     * El sexo debe ser 'M' (hembra) o 'H' (macho).
     * El peso debe ser un valor positivo mayor que cero.
     * La fecha de nacimiento debe estar en formato ISO-8601 (yyyy-MM-dd) válido.
     * Si algún parámetro no cumple estas condiciones, se lanza una excepción IllegalArgumentException
     * @param codigo el código identificativo del animal, compuesto por 5 caracteres alfanuméricos en minúscula
     * @param fechaNacimiento la fecha de nacimiento del animal en formato "yyyy-MM-dd"
     * @param sexo el sexo del animal, 'M' para hembra o 'H' para macho
     * @param peso el peso del animal en kilogramos, debe ser mayor que 0
     * @throws IllegalArgumentException si el código no cumple el patrón, el sexo es incorrecto, el peso no es positivo o la fecha no tiene un formato válido
     */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    /**
     * Devuelve el código del animal.
     * @return el código identificativo del animal
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del animal.
     * @param codigo el nuevo código del animal
     * @throws IllegalArgumentException si el código no tiene 5 caracteres alfanuméricos en minúscula
     */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    /**
     * Devuelve la fecha de nacimiento del animal.
     * @return la fecha de nacimiento del animal
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del animal.
     * @param fechaNacimiento la nueva fecha de nacimiento en formato "yyyy-MM-dd"
     * @throws IllegalArgumentException si la fecha no tiene un formato válido
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    /**
     * Devuelve el sexo del animal.
     * @return el sexo del animal
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del animal.
     * @param sexo el nuevo sexo del animal ('M' o 'H')
     * @throws IllegalArgumentException si el sexo no es 'M' o 'H'
     */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    /**
     * Devuelve el peso del animal.
     * @return el peso del animal
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del animal.
     * @param peso el nuevo peso del animal
     * @throws IllegalArgumentException si el peso es menor o igual a 0
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    /**
     * Devuelve el código hash del objeto.
     * @return el código hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    /**
     * Compara el objeto actual con otro objeto para ver si son iguales.
     * @param obj el objeto con el que comparar
     * @return true si los objetos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en formato cadena del animal.
     * @return una cadena con los datos del animal
     */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    /**
     * Produce el sonido característico del animal.
     * @return el sonido del animal
     */
    public abstract String hacerSonido();

    /**
     * Muestra el comportamiento del animal al alegrarse.
     * @return la reacción de alegría
     */
    public abstract String alegrarse();

    /**
     * Muestra el comportamiento del animal al enfadarse.
     * @return la reacción de enfado
     */
    public abstract String enfadarse();

    /**
     * Devuelve el tipo de animal.
     * @return el tipo de animal
     */
    public abstract String queSoy();

}
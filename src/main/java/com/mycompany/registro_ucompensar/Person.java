package com.mycompany.registro_ucompensar;

/**
 * Clase que representa a una persona con información básica para crear un registro.
 */
public class Person {
    private String name;
    private String id;
    private short age;
    private char membershipCategory;
    private double entryValue;

    /**
     * Constructor de la clase Person.
     * @param name Nombre de la persona.
     * @param id Identificación de la persona.
     * @param age Edad de la persona.
     * @param membershipCategory Categoría de afiliación de la persona.
     */
    public Person(String name, String id, short age, char membershipCategory){
        this.name = name;
        this.id = id;
        this.age = age;
        this.membershipCategory = membershipCategory;
        calculateEntryValue();
    }

    // Métodos getters y setters para los atributos

    String getName(){
        return this.name;
    }
    String getId(){
        return this.id;
    }
    short getAge(){
        return this.age;
    }
    char getMembershipCategory(){
        return this.membershipCategory;
    }
    double getEntryValue(){ return this.entryValue; }
    void setName(String name){
        this.name = name;
    }
    void setId(String id){
        this.id = id;
    }
    void setAge(short age){
        this.age = age;
    }
    void setMembershipCategory(char membershipCategory){
        this.membershipCategory = membershipCategory;
    }
    private void setEntryValue(double entreValue){ this.entryValue = entreValue; }

    /**
     * Método para calcular el valor de la entrada según la edad y la categoría de afiliación.
     */
    void calculateEntryValue() {
        // Valor de entrada general
        final double GENERAL_ENTRY_VALUE = 30000.0;

        // Valores de membresía según la letra de categoría de afiliación en código ASCII
        final double[][] MEMBERSHIP_VALUE = {
                {65.0, GENERAL_ENTRY_VALUE * 0.85},
                {66.0, GENERAL_ENTRY_VALUE * 0.7},
                {67.0, GENERAL_ENTRY_VALUE * 0.5},
                {78.0, GENERAL_ENTRY_VALUE}
        };

        if (this.getAge() < 18) {
            // Si es menor de 18 años, el valor de entrada es fijo en 5000
            this.setEntryValue(5000);
        } else if (this.getAge() >= 18) {
            // Si es mayor o igual a 18 años, busca el valor de membresía correspondiente
            for (double[] value : MEMBERSHIP_VALUE) {
                if (value[0] == this.getMembershipCategory()) {
                    this.setEntryValue(value[1]);
                    break;
                }
            }
        }
    }

    String showInformation(){
        return String.format("%s\t| %s\t| %d\t| %s\t| %.2f$", this.getName(), this.getId(), this.getAge(), (this.getMembershipCategory() == 'N') ? "No Afiliado" : this.getMembershipCategory(), this.getEntryValue() );
    }

}


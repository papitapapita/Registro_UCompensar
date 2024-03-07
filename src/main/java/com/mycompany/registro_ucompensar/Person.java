package com.mycompany.registro_ucompensar;

/**
 * Clase que representa a una persona con información básica para crear un registro.
 */
public class Person {
    private String name;
    private int id;
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
    public Person(String name, int id, short age, char membershipCategory){
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
    int getId(){
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
    void setId(int id){
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
    void calculateEntryValue(){
        final double GENERAL_ENTRY_VALUE = 30000.0;
        final double[][] MEMBERSHIP_VALUE = {
                {65.0, GENERAL_ENTRY_VALUE * .85},
                {66.0, GENERAL_ENTRY_VALUE * .7},
                {67.0, GENERAL_ENTRY_VALUE * .5},
                {78.0, GENERAL_ENTRY_VALUE}
        };
        if(this.getAge() < 18){
            this.setEntryValue(5000);
        }else if(this.getAge() >= 18){
            for(double[] value : MEMBERSHIP_VALUE){
                if(value[0] == this.getMembershipCategory()){
                    this.setEntryValue(value[1]);
                    break;
                }
            }
        }
    }

    String showInformation(){
        return String.format("%s\t| %d\t| %d\t| %s\t| %.2f$", this.getName(), this.getId(), this.getAge(), (this.getMembershipCategory() == 'N') ? "No Afiliado" : this.getMembershipCategory(), this.getEntryValue() );
    }

}


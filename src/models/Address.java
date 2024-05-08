package models;

public class Address {

    private String street;
    private String zipcode;
    private String city;

    public Address(AddressViaCepAPI addressViaCepAPI) {
        street = addressViaCepAPI.logradouro();
        zipcode = addressViaCepAPI.cep();
        city = addressViaCepAPI.localidade();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Endereço {" +
                "Rua = '" + street + '\'' +
                ", CEP = '" + zipcode + '\'' +
                ", Cidade = '" + city + '\'' +
                '}';
    }
}

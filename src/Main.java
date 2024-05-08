import functions.CreateFileCepJson;
import functions.FindCEP;
import models.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner reader = new Scanner(System.in);
        List<Address> addressList = new ArrayList<>();

        while (true){

            System.out.print("Informe um CEP: ");
            String cep = reader.nextLine();

            if (cep.equals("*")){
                break;
            }

            try {
                FindCEP findCEP = new FindCEP();
                Address newAddress = findCEP.findAddress(cep);
                addressList.add(newAddress);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Endereço não encontrado.");
            }
        }

        if (!addressList.isEmpty()){
            for (Address item: addressList){
                CreateFileCepJson createFileCepJson = new CreateFileCepJson();
                createFileCepJson.createFile(item);
            }

        }

    }

}
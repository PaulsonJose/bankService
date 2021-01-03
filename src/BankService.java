import com.thomas_bayer.blz.BLZService;
import com.thomas_bayer.blz.BLZServicePortType;
import com.thomas_bayer.blz.DetailsType;

import java.util.Scanner;

public class BankService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean again = true;
        char result;
        while(again) {
            System.out.println("Please enter BKZ number: ");
            String bkz = scanner.next();
            BLZService blzService = new BLZService();
            BLZServicePortType blzServicePortType = blzService.getBLZServiceSOAP11PortHttp();
            DetailsType detailsType = blzServicePortType.getBank(bkz);
            System.out.println("Bank Name: " + detailsType.getBezeichnung());
            System.out.println("     City: " + detailsType.getOrt());
            System.out.println("     post: " + detailsType.getPlz() + "\nDo you want to continue? (y/n)");
            result = scanner.next(".").charAt(0);
            again = (result == 'y')? true: false;
        }
    }
}

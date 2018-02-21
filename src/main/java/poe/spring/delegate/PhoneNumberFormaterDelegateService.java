package poe.spring.delegate;

public class PhoneNumberFormaterDelegateService {

    /**
     *
     * @param number un numéro qui ne respecte pas de format précis
     * @return String numéro au format 0600000000
     */
    public static String format(String number) {
        String formatedNumber;
        // gestion du cas +33600000000
        formatedNumber = number.replaceAll("\\+3[3|9]", "0");
        return formatedNumber;
    }

}

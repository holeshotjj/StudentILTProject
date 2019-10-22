import java.awt.desktop.SystemEventListener;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        boolean loop = true;
        Scanner input = new Scanner(System.in);

            System.out.println("How many students would you like to enter?");
            int number = input.nextInt();
            Student[] sArray = new Student[number];
            input.nextLine();
            for(int i = 0; i < number; i++)
            {
                createStudents(sArray, i);
            }

            System.out.println("Student Details, Department of ILT");
            System.out.println("----------------------------------");
            for(int i = 0; i < number; i++)
            {
                sArray[i].displayInfo();
                System.out.println("\n");
            }
            System.out.println("Number of students: " + sArray[0].getCount());


    }

    public static boolean nameValidate(String x)
    {
        int length = x.length();
        boolean result = true;
        for(int i = 0; i < length; i++) {
            Character c = x.charAt(i);
            boolean digitCheck = Character.isDigit(c);
            if (digitCheck == true) {
                result = false;
                i = length;
            }

        }
        return result;
    }

    public static boolean numValidate(String x)
    {
        int length = x.length();
        boolean result = true;
        for(int i = 0; i < length; i++) {
            Character c = x.charAt(i);
            boolean digitCheck = Character.isDigit(c);
            if (!digitCheck) {
                result = false;
                i = length;
            }

        }
        return result;
    }

    public static boolean emailValidate(String x)
    {
        boolean check = x.contains("@");
        if(check)
        {
            check = x.contains(".");
            if(check)
            {
                int tldpos = x.indexOf('.');
                String tldCheck = x.substring(tldpos);
                if((tldCheck.equals(".com")) || (tldCheck.equals(".org")) || (tldCheck.equals(".edu")))
                {
                    return true;
                }
                else
                {
                    System.out.println("Make sure your email includes a top level domain (.com, .org. or .edu).");
                    return false;
                }

            }
            else
            {
                System.out.println("Did your email have a \".\" before the top level domain?");
                return false;
            }

        }
        else
        {
            System.out.println("Did your email include an \"@\" symbol?");
            return false;
        }
    }

    public static boolean addressValidate(String x)
    {
        int length = x.length();
        int firstspacepos = 0;
        int numberInStreet = 0;
        boolean digitCheck = true;
        boolean result = true;
        int count = 0;
        for(int i = 0; i < length; i++) {
            Character c = x.charAt(i);
             digitCheck = Character.isDigit(c);
            if (!digitCheck) {
                firstspacepos = (i+1);
                i = length;
            }
            else
            {
                if(count == (length-1))
                {
                    result = false;
                }
                else
                {
                    count++;
                }
            }

        }

            String streetName = x.substring(firstspacepos);
                    boolean check = nameValidate(streetName);
                    if(!check) {
                        length = streetName.length();
                        for (int n = 0; n < length; n++) {
                            Character v = streetName.charAt(n);
                            digitCheck = Character.isDigit(v);
                            if (digitCheck) {
                                numberInStreet = n;
                                String posCheck = streetName.substring(numberInStreet);
                                if (!(posCheck.contains("nd") || posCheck.contains("st") || posCheck.contains("rd") || posCheck.contains("th"))) {
                                    result = false;
                                    System.out.println("Please make sure that you entered your street name properly.");
                                    n = length;
                                }
                                else
                                {
                                    n =length;
                                }
                            }
                        }

                    }
        return result;
    }

    public static boolean stateValidate(String x)
    {
        String stateArray[] = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN",
                "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT",
                "WA", "WI", "WV", "WY" };
        for(int i = 0; i<50; i++)
        {
            if(x.equals(stateArray[i]))
            {
                return true;
            }
        }

        return false;

    }

    public static boolean lengthCheck(int x, Integer y)
    {
        int check = y.toString().length();
        if(check != x)
        {
            return false;
        }
        else
        { return true;}
    }

    public static void createStudents(Student[] x, int y)
    {
        boolean cont = true;
        Scanner inputTemp = new Scanner(System.in);
        String fnameTemp ="", lnameTemp = "", gradeTemp = "", emailTemp = "", addressTemp ="", cityTemp="", stateTemp ="";
        Integer psTemp = 0, zipTemp = 0;
        System.out.println("Please enter the following information for student number " + (y+1) + ":");

        while(cont) {
            System.out.println("First Name:");
            fnameTemp = inputTemp.nextLine();
            boolean check = nameValidate(fnameTemp);
            if(!check)
            {
                System.out.println("This field cannot contain any numbers.");
            }
            else
            {cont = false;}
        }
        cont = true;

        while(cont) {
            System.out.println("Last Name:");
            lnameTemp = inputTemp.nextLine();
            boolean check = nameValidate(lnameTemp);
            if(!check)
            {
                System.out.println("This field cannot contain any numbers.");
            }
            else
            {cont = false;}
        }
        cont = true;

        while(cont) {
            System.out.println("Peoplesoft ID:");
            String psTempAsString = inputTemp.nextLine();

            boolean check = numValidate(psTempAsString);
            if(check)
            {
                psTemp = Integer.parseInt(psTempAsString);
                check = lengthCheck(7,psTemp);
                if(check) {
                    cont = false;
                }
                else
                {
                    System.out.println("Please make sure your PSID is 7 digits long.");
                }
            }
            else
            {
                System.out.println("This field cannot contain any letters.");
            }
        }
        cont = true;

        while(cont) {
            System.out.println("Grade:");
            gradeTemp = inputTemp.nextLine();
            boolean check = nameValidate(gradeTemp);
            if(!check)
            {
                System.out.println("This field cannot contain any numbers. (Freshman, Sophomore, Junior, or Senior)");
            }
            else
            {cont = false;}
        }
        cont = true;

        while(cont) {
            System.out.println("Email Address:");
            emailTemp = inputTemp.nextLine();
            boolean check = emailValidate(emailTemp);
            if(!check)
            {
                System.out.println("Please check the format of your email address.");
            }
            else
            {
                cont = false;
            }
        }
        cont = true;

        while(cont) {

            System.out.println("Street Address:");
            addressTemp = inputTemp.nextLine();
            boolean check = addressValidate(addressTemp);
            if(!check)
            {
                System.out.println("Please check the format of your address.");
            }
            else
            {
                cont = false;
            }
        }
        cont = true;

        while(cont) {
            System.out.println("City:");
            cityTemp = inputTemp.nextLine();
            boolean check = nameValidate(cityTemp);
            if(!check)
            {
                System.out.println("This field cannot contain any numbers.");
            }
            else
            {cont = false;}
        }
        cont = true;

        while (cont) {
            System.out.println("State:");
            stateTemp = inputTemp.nextLine();
            boolean check = stateValidate(stateTemp);
            if(check)
            {
                cont = false;
            }
            else
            {
                System.out.println("Please enter one of the 50 states.");
            }
        }
        cont = true;

        while(cont) {
            System.out.println("Zip Code:");
            String zipTempAsString = inputTemp.nextLine();

            boolean check = numValidate(zipTempAsString);
            if(check)
            {
                zipTemp = Integer.parseInt(zipTempAsString);
                check = lengthCheck(5,zipTemp);
                if(check) {
                    cont = false;
                }
                else
                {
                    System.out.println("Please make sure your zip code is 5 digits long.");
                }
            }
            else
            {
                System.out.println("This field cannot contain any letters.");
            }
        }
        cont = true;
        x[y] = new Student(fnameTemp, lnameTemp, psTemp, gradeTemp, emailTemp, addressTemp, cityTemp,stateTemp,zipTemp);
        x[y].incrementCount();
    }


}

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class Collections {

    public static void main(String[] args) {
        //String[] employees = getEmployees();
        //MyArrayList employees = getEmployees();
        ArrayList<String> employees = getEmployees();
        /*
        String[] newArray = new String[employees.length + 1];

        for(int i = 0; i < employees.length; i++){
            newArray[i] = employees[i];
        }
        newArray[newArray.length - 1] = "James";
        employees = newArray;

        //Eliminar un dato de la lista
        employees[0] = null;
        String[] newestArray = new String[employees.length - 1];
        for(int j = 0; j< employees.length;j++){
            String employee = employees[j];
            if(employee != null){
                newestArray[j] = employee;
                j++;
            }
        }
        employees = newestArray;
        for(String employee : employees){
            System.out.println(employee);
        }
         */

        employees.add("James");
        employees.remove("Emma");
        //for(int i = 0; i < employees.getSize(); i ++){
        /*for(int i = 0; i < employees.size(); i ++){
            System.out.println(employees.get(i));
        }
         */
        for(String employee : employees){
            System.out.println(employee);
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            numbers.add(i);
        }


        ArrayList<String> text = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++){
            text.add(numbers.get(i) + " - " + employees.get(i));
        }
        for (String frase : text){
            System.out.println(frase);
        }
    }


    //private static String[] getEmployees(){
    //private static MyArrayList getEmployees(){
    private static ArrayList<String> getEmployees(){
        //String[] employees = new String[5];
        //MyArrayList employees = new MyArrayList();
        ArrayList<String> employees = new ArrayList<>();
        /*
        employees[0] = "John";
        employees[1] = "Olivia";
        employees[2] = "Emma";
        employees[3] = "Max";
        employees[4] = "Nick";
         */
        employees.add("John");
        employees.add("Olivia");
        employees.add("Emma");
        employees.add("Max");
        employees.add("Nick");
        return employees;
    }

}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Student{
    int id;
    String name;
    String gender;
    int age;
    String classroom;
    float score;
    Student(){};
//    Student(int id, String name, String gender, int age, String classroom, float score){
//        this.id= id;
//        this.name= name;
//        this.gender = gender;
//        this.classroom= classroom;
//        this.age =age;
//        this.score = score;
//    }

    public Student(int id, String name, String gender, String classroom, float score) {
        this.id= id;
        this.name= name;
        this.gender = gender;
        this.classroom= classroom;
        this.age =age;
        this.score = score;
    }


    void inputInformation(Scanner input){
//        System.out.println("======================");
//        System.out.println("Enter ID : ");
//        String strId;

        boolean isIDValid =false;
        do {

            String strId;
            System.out.println("Enter ID : ");

            try {

                strId = input.nextLine();
                id = Integer.parseInt(strId);
                isIDValid = true;

            } catch (Exception ex) {
                System.out.println("Invalid ID format! (Integer only!)");
            }
        }while(!isIDValid);

        System.out.println("Enter Name : ");

        name = input.nextLine();
        System.out.println("Enter Gender : ");
        gender = input.nextLine();


        boolean isAgeValid =false;
        do {

            String strAge;
            System.out.println("Enter Age : ");

            try {

                strAge = input.nextLine();
                age = Integer.parseInt(strAge);
                isAgeValid = true;

            } catch (Exception ex) {
                System.out.println("Invalid Age format! (Integer only!)");
            }
        }while(!isAgeValid);

        System.out.println("Enter Student Classroom : ");
        classroom = input.nextLine();

        boolean isScoreValid =false;
        do {

            String strScore;
            System.out.println("Enter Score : ");

            try {

                strScore = input.nextLine();
                score = Float.parseFloat (strScore);
                isScoreValid = true;

            } catch (Exception ex) {
                System.out.println("Invalid Score format! (Integer only!)");
            }
        }while(!isScoreValid);
    }
    void outputInformation(){
//        System.out.println("======= Add Student =======");
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Gender : "+gender);
        System.out.println("Classroom : "+classroom);
        System.out.println("Score : "+ score);

    }

}

public class Main {

    static void pressEnterKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("====Press Enter to continue====");
        scanner.nextLine();
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student obj = new Student();
        Scanner input = new Scanner(System.in);

        int option = 0;
        do{
            System.out.println("===========Student Management System============");
            System.out.println("1. Insert Student to System");
            System.out.println("2. Edit Student Information");
            System.out.println("3. Search Student Information");
            System.out.println("4. Delete Student Information");
            System.out.println("5. Show Student Information");
            System.out.println("6. Exit");
            String strOption;
            System.out.print("Choose your option for 1 - 6 : ");
            strOption = input.nextLine();
            try{
                option = Integer.parseInt(strOption);
            }catch (Exception ex){
                input.nextLine();
                option = 0;
                System.out.println("Invalid option input!!!");
            }


            switch (option){
                case 1 :
                    System.out.println("=======Insert Student to System=======");
                    Student newStudent = new Student();
                    newStudent.inputInformation(input);

                    students.add(newStudent);

                    System.out.println("Successfully insert....!");
                    input.nextLine();
                    break;
                case 2:
                    boolean StudentExist=false;
                    System.out.println("======Edit Student Information====");
                    System.out.println("Enter Id to update  : ");
                    int editID = input.nextInt();
                    for(int i=0; i< students.size();i++){
                        if(editID== students.get(i).id){
                            StudentExist=true;
                            System.out.println("Student Exit in our Classroom ");
                        }
                    }
                    if (!StudentExist){
                        System.out.println("Student with ID = "+editID+"doesn't exist !");
                    }

                    break;
                case 3:
                    int searchOption;
                    System.out.println("=======Search Student Information====");
                    System.out.println("1. Search By ID");
                    System.out.println("2. Search By Name");
                    System.out.println("3. Exit....!");

                    System.out.print("Choose option 1 - 3 : ");
                    searchOption = input.nextInt();
                    switch (searchOption){
                        case 1 :
                            int searchID;
                            boolean isStudentExist=false;
                            System.out.println("Search buy ID");
                            System.out.println("Enter Id to Search : ");
                            searchID= input.nextInt();

                            for(int i=0; i< students.size();i++){
                                if(searchID== students.get(i).id){
                                    students.get(i).outputInformation();
                                }
                            }
                            if (!isStudentExist){
                                System.out.println("Student with ID = "+searchID+"doesn't exist !");
                            }
                            pressEnterKey();
                          break;
                        case 2:
                            boolean isStudentExists=false;
                            System.out.println("Search by Name");
                            String searchName;
                            System.out.println("Enter name to search : ");
                            searchName= input.nextLine();

                            for(int i=0; i< students.size();i++){
                                if(searchName== students.get(i).name){
                                    isStudentExists=true;
                                    students.get(i).outputInformation();
                                }
                            }
                            if (!isStudentExists){
                                System.out.println("Student with Name = "+searchName+"doesn't exist !");
                            }

                    }
                    input.nextLine();
                    break;

                case 4:

                    System.out.println("======Delete Student Information=====");
                    System.out.println("Enter Id to delete : ");
                    int ids = input.nextInt();
                    for (int i =0; i<students.size(); i++){
                        if (students.get(i).id == ids){
                            students.remove(i);
                        }
                    }
                    System.out.println("Success delete!");
                    break;
                case 5:
                    System.out.println("======Show Student information======");
                    for(int i=0; i<students.size();i++){
                        students.get(i).outputInformation();
                    }
                    break;
                case 6:
                    System.out.println("Exit the program....!");
                    break;
//                default:
//                    System.out.println("Wrong option !!"); break;

            }
        }while (option!=6);


    }
}
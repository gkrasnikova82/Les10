package task1;
//Написать программу, которая будет считывать документы (акты и договора) с консоли, сохранять их в массив и выводить конкретный документ по запросу:
// Предусмотреть ввод информации: количество считываемых документов, для каждого документа - тип и необходимую информацию.
// Документы хранить в общем массиве (Подумать про использование полиморфизма)
// Предусмотреть вывод конкретного i-го документа на консоль. Для этого написать перегрузку метода toString().

import java.util.Arrays;
import java.util.Scanner;

class Act extends Polymorphism implements Input{
    public void DocInput(int i){
        System.out.print("Введите номер акта:");
        Polymorphism.Doc[i][1] = sc.next();
        System.out.print("Введите состояние акта:");
        Polymorphism.Doc[i][2] = sc.next();

    }

}
class Contract extends Polymorphism implements Input{
    public void DocInput (int i){
        System.out.print("Введите номер договора:");
        Polymorphism.Doc[i][1] = sc.next();
        System.out.print("Введите дату договора:");
        Polymorphism.Doc[i][2] = sc.next();
    }

}
class Polymorphism {
    public static String [][] Doc;

    @Override
    public String toString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите документ, который необходимо показать:");
        int NumberDoc = sc.nextInt()-1;
       if (Polymorphism.Doc [NumberDoc][0].startsWith("1"))
           return "Тип документа - договор "+"номер договора: "+Polymorphism.Doc[NumberDoc][1]+" дата договора: "+Polymorphism.Doc[NumberDoc][2];
       else
           return "Тип документа - Акт "+"номер Акта: "+Polymorphism.Doc[NumberDoc][1]+" состояние Акта: "+Polymorphism.Doc[NumberDoc][2];
    }
}
interface Input {
    abstract void DocInput (int i);
    Scanner sc = new Scanner(System.in);// режим ввода информации из консоля

}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// режим ввода информации из консоля
        System.out.print("Введите количество документов для ввода:");
Polymorphism PolymorphismI= new Polymorphism();

        int NumberDoc = sc.nextInt();
        Act Acts = new Act();
        Contract Contracts = new Contract();
        Polymorphism.Doc=new String[NumberDoc][3];
        System.out.println("Спасибо! Вы ввели число " + NumberDoc);
        for (int i=0;i<NumberDoc;i++){
            System.out.print("Введите тип документа (1-договор, 2- акт:");
            Polymorphism.Doc [i][0]= sc.next();
            if (Polymorphism.Doc [i][0].startsWith("1")) Contracts.DocInput(i);
            else Acts.DocInput(i);
        }
        System.out.println(Arrays.deepToString(Polymorphism.Doc));
System.out.println(PolymorphismI);
    }
}
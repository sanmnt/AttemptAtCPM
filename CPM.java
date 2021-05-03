package ProgrammingAssignment4;

import javax.print.attribute.IntegerSyntax;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CPM {

    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "C:\\Users\\Administrator\\IdeaProjects\\ProgrammingAssignment4\\src\\ProgrammingAssignment4\\input.txt";
        ArrayList <Node> inputs = new ArrayList();
        Scanner scn = new Scanner(new File(filepath));
        scn.useDelimiter("[,\n]");
        String name = "";
        String time = "";
        while(scn.hasNext()){
            ArrayList <Node> parent= new ArrayList();
            name = scn.next().trim();
            Scanner scn2 = new Scanner(scn.next());
            scn2.useDelimiter(" ");
            while (scn2.hasNext()){
                String checkVariable = scn2.next().trim();
                if (checkVariable== null){
                    break;
                }
                else{
                    for(int i = 0; i < inputs.size(); i++){
                        if(inputs.get(i).getName().equals(checkVariable)){
                            parent.add(inputs.get(i));
                        }
//                        System.out.println(inputs.get(i).getName() + " " + checkVariable);
                    }
                }


            }
            time = (scn.next());

            int time2 = Integer.valueOf(time.trim());
            inputs.add(new Node(name, parent, time2));

        }

//        System.out.println(inputs);
//        for(int i = 0; i < inputs.size(); i++){
//            System.out.println(inputs.get(i).getParent());
//        }
        fillChildren(inputs);
//        for(int i = 0; i < inputs.size(); i++){
//            System.out.println(inputs.get(i).getChild());
//        }
        takeFullArray(inputs);
        for(int i = 0; i < secondlist.size(); i++){
            System.out.println(secondlist.get(i).getEF());
        }

        fillParent(secondlist);
//        int max = 0;
//        Node lastItem = null;
//        for(int i = 0; i < secondlist.size(); i++){
//            if (secondlist.get(i).getEF() > max) {
//                max = secondlist.get(i).getEF();
//                lastItem = secondlist.get(i);
//            }
//        }
//        lastItem.setLF(max);
//        max = max- lastItem.getTime();
//        lastItem.setLS(max);
//        System.out.println(secondlist.get(secondlist.size() - 1).getLF());
//        System.out.println(secondlist.size());
//        backwardpass(secondlist);
//        System.out.println(thirdlist.size());

 //       secondPass();
        for(int i = 0; i < secondlist.size(); i++){
            System.out.println(secondlist.get(i).getEF());
        }







    }
    public static ArrayList<Node> thirdlist = new ArrayList<>();
//    public static void backwardpass(ArrayList<Node> something){
//        for(int i = something.size() - 1; i >= 0; i--){
//            if(something.get(i).getLF() > 0){
//                something.get(i).setLS(something.get(i).getLF() - something.get(i).getTime());
//                System.out.println("lets see this");
//            }
//            if (something.get(i).getLS() >= 0){
//                checker(something.get(i));
//           //     thirdlist.add(something.get(i));
//           //     something.remove(i);
//           //     backwardpass(something);
//          //      break;
//
//            }
//            if (something.get(i).tempLF > 0 ){
//                System.out.println("second");
//                something.get(i).setLF(something.get(i).tempLF);
//                something.get(i).tempLF = 0;
//            }
//        }
//        if (!something.isEmpty()){
//            System.out.println("third");
//         //   backwardpass(something);
//        }
//    }
//
//    public static void checker(Node filtered){
//        for(Node n: filtered.getParent()) {
//            n.removeChild(filtered);
//            if(filtered.getLS() < n.tempLF)
//                n.tempLF = filtered.getLS();
//        }
//    }
    public static void secondPass(){
        int max = 0;
        Node lastItem = null;
        for(int i = 0; i < secondlist.size(); i++){
            if (secondlist.get(i).getEF() > max) {
                max = secondlist.get(i).getEF();
                lastItem = secondlist.get(i);
            }
        }
        lastItem.setLF(max);
        max = max- lastItem.getTime();
        lastItem.setLS(max);

        renameLater(max, lastItem.getParent());




    }
    public static void renameLater(int max, ArrayList<Node> a){
        for(int i = 0; i< a.size(); i ++){
            for(int z = 0; z < a.get(i).getChild().size(); z ++){
                if(max>a.get(i).getChild().get(z).getLS() && a.get(i).getChild().get(z).getLS() != 0)
                    max = a.get(i).getLS();
                else
                    break;
            }
            a.get(i).setLF(max);
            a.get(i).setLS(max - a.get(i).getTime() );
            renameLater(max - a.get(i).getTime(), a.get(i).getParent());


        }

//            n.setLF(max);
//            n.setLS(max-n.getTime());


    }
//    public static void stuff(Node filtered){
//        for(Node n: filtered.getChild()) {
//            n.removeParent(filtered);
//            if(filtered.getEF() > n.tempES)
//                n.tempES = filtered.getEF();
//            System.out.println(filtered.getES() +" " + filtered.getEF());
//        }
//    }
    public static ArrayList<Node> secondlist = new ArrayList<>();
    public static void takeFullArray(ArrayList<Node> something){
        for(int i = 0; i < something.size(); i++){
            if(something.get(i).getES() > 0){
                something.get(i).setEF(something.get(i).getES() + something.get(i).getTime());
            }
            if (something.get(i).getEF() > 0){
                completeRequirement(something.get(i));
                secondlist.add(something.get(i));
                something.remove(i);
                takeFullArray(something);
                break;

            }
            if (something.get(i).tempES > 0 && something.get(i).getParent().isEmpty()){
                something.get(i).setES(something.get(i).tempES);
                something.get(i).tempES = 0;
            }
        }
        if (!something.isEmpty()){
            takeFullArray(something);
        }
    }

    public static void completeRequirement(Node filtered){
        for(Node n: filtered.getChild()) {
            n.removeParent(filtered);
            if(filtered.getEF() > n.tempES)
                n.tempES = filtered.getEF();
            System.out.println(filtered.getES() +" " + filtered.getEF());
            }
    }
    public static void fillChildren(ArrayList<Node> testdata){
        for(int i = 0; i < testdata.size(); i++){
            for(Node n: testdata.get(i).getParent()){
                n.addChild(testdata.get(i));
            }
        }
    }
    public static void fillParent(ArrayList<Node> testdata){
        for(int i = 0; i < testdata.size(); i++){
            for(Node n: testdata.get(i).getChild()){
                n.addParent(testdata.get(i));
            }
        }
    }
}

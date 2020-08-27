package sr.unasat.trafficsim.datastructures;

import sr.unasat.trafficsim.entities.Car;

public class Stack {
    Node top;

    public void push(Car data){

        Node node = new Node();
        node.data = data;
        if (top == null){
            top = node;

            node.next = null;
        }else{
            node.next = top;
            top = node;
        }


    }

    public boolean isEmpty(){
        return  top == null;
    }

    public void pop(){
        if (top == null){
            return;
        }

        top = top.next;
    }

    public void display(){
        if (!isEmpty()){
            Node n = top;
            while (n!= null){
                System.out.println(n.toString());
                System.out.println(n.data.toString());
                n = n.next;
            }
        }
    }

    public Car peek(){
      if (!isEmpty()){
          return  top.data;
      }else{
          return null;
      }
    }
}

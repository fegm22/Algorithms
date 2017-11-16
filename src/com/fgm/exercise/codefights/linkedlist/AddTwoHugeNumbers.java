package com.fgm.exercise.codefights.linkedlist;


public class AddTwoHugeNumbers {

    public static void main(String[] args) {

        ListNode<Integer> listaA = new ListNode<>(9876);
        listaA.next = new ListNode<>(5432);
        listaA.next.next = new ListNode<>(1999);

        ListNode<Integer> listaB = new ListNode<>(1);
        listaB.next = new ListNode<>(8001);

        ListNode<Integer> result = addTwoHugeNumbers(listaA, listaB);

    }
//
//
//  public static void main(String[] args) {
//
//        ListNode<Integer> listaA = new ListNode<>(1);
//
//        ListNode<Integer> listaB = new ListNode<>(9999);
//        listaB.next = new ListNode<>(9999);
//        listaB.next.next = new ListNode<>(9999);
//        listaB.next.next.next = new ListNode<>(9999);
//        listaB.next.next.next.next = new ListNode<>(9999);
//        listaB.next.next.next.next.next = new ListNode<>(9999);
//
//        ListNode<Integer> result = addTwoHugeNumbers(listaA, listaB);
//
//    }

    public static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

        ListNode<Integer> numberA = reverseList(a);
        ListNode<Integer> numberB = reverseList(b);

        return sumList(numberA, numberB);
    }

    private static ListNode<Integer> sumList(ListNode<Integer> numberA, ListNode<Integer> numberB) {
        ListNode<Integer> head = null;
        int rest = 0;

        while (numberA!=null || numberB!=null){
            int sumA = 0;
            int sumB = 0;

            if(numberA!=null){
                sumA = numberA.value;
            }
            if(numberB!=null){
                sumB = numberB.value;
            }

            int sumaAB = sumA + sumB;
            sumaAB += rest;
            rest = sumaAB/10000;
            int elemento  = sumaAB - (10000*rest);

            ListNode<Integer> nuevo = new ListNode<>(elemento);
            nuevo.next = head;
            head = nuevo;

            if(numberA!=null) numberA = numberA.next;
            if(numberB!=null) numberB = numberB.next;
        }
        if(rest>0){
            ListNode<Integer> nuevo = new ListNode<>(rest);
            nuevo.next = head;
            head = nuevo;
        }

        return head;
    }


    public static ListNode<Integer> reverseList(ListNode<Integer> head){
        if(head==null || head.next == null)
            return head;

        //get second node
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;

        ListNode rest = reverseList(second);
        second.next = head;

        return rest;
    }


    //---------------------------------------- first try

    public static ListNode<Integer> addTwoHugeNumbers2(ListNode<Integer> a, ListNode<Integer> b) {

        final int M = 1000000007;
        long numeroA = listToInteger(a)%M;
        long numeroB = listToInteger(b)%M;

        String suma = String.valueOf( numeroA + numeroB );

        return stringToList(suma);

    }

    public static ListNode<Integer> stringToList(String suma) {

        ListNode<Integer> lista = null;
        ListNode<Integer> last = null;
        StringBuilder numero = new StringBuilder();

        for (int i = 1; i <= suma.length(); i++) {
            numero.append(suma.charAt(i-1));
            if (i % 4 == 0 ) {
                ListNode<Integer> newNode = new ListNode<>(Integer.valueOf(numero.toString()));
                if(lista==null){
                    lista = newNode;
                    last = newNode;
                }
                last.next = newNode;
                last = newNode;

                numero.setLength(0);
            }
        }
        return lista;
    }

    public static Long listToInteger(ListNode<Integer> a) {

        StringBuilder number = new StringBuilder();
        final int M = 1000000007;

        while (a != null) {
            if (a.value > 0) {
                number.append(a.value);
            } else {
                number.append("0000");
            }
            a = a.next;
        }

        Long result = Long.valueOf(number.toString());
        return result;
    }

}

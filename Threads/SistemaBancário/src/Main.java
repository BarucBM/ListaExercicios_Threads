public class Main {
    public static void main(String[] args) {
        CustomerThreads Andre = new CustomerThreads("Andre", 5);
        CustomerThreads Baruc = new CustomerThreads("Baruc", 6);
        CustomerThreads Julia = new CustomerThreads("Julia", 3);
        CustomerThreads Maria = new CustomerThreads("Maria", 8);

        Andre.start();
        Baruc.start();
        Julia.start();
        Maria.start();
    }
}
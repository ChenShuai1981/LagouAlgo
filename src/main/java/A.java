public class A {
    @Override protected void finalize() {
        System.out.println(this + " was finalized!");
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        System.out.println("Created " + a);
//        a = null;
        for (int i = 0; i < 1_000_000_000; i++) {
            if (i % 1_000_00 == 0)
                System.gc();
        }
        System.out.println("done.");
//        System.out.println(a);
    }
}

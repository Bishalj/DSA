package binarysearchtree;

class GfG
{
    static int a = 1;
    int a1 = 1;
    static {
        System.out.println("Static");
        System.out.println("a" + a);
    }
    // Instance Initialization Block
    {
        System.out.println("IIB block");
        System.out.println("a" + a);
        System.out.println("a1" + a1);
    }

    // Constructor of GfG class
    GfG()
    {
        System.out.println("Constructor Called");
        System.out.println("a" + a);
        System.out.println("a1" + a1);
    }
    public static void main(String[] args)
    {
        GfG a = new GfG();
    }
}
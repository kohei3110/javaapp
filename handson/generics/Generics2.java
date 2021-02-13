class Generics2<T extends Number> {
    private T value;
    public Generics2(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }    

    public static void main(String... args){
    }
}
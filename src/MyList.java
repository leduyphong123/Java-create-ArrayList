public class MyList<E> {
    private int size = 0;
    static final int DEFAUL_CAPACITY = 10;
    private Object element[];

    MyList() {
        this.element = new Object[DEFAUL_CAPACITY];
    }

    MyList(int capacity) {
        this.element = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0 || index >= this.element.length) {
            ensureCapacity();
        }
        for (int i = size; i > index; i--) {
            this.element[i] = this.element[i - 1];
        }
        this.element[index - 1] = element;
        size += 1;
    }

    private void ensureCapacity() {
        Object[] newElement = new Object[this.element.length * 2 - 1];
        System.arraycopy(this.element, 0, newElement, 0, this.element.length);
        this.element = newElement;
    }

    public E remove(int index) {
        Object result = null;
        if (index < 0 || index >= this.size) {
            throw new ArithmeticException("index =" + index + " size =" + this.size);
        } else {
            for (int i = index - 1; i < this.size - 1; i++) {
                result = this.element[i];
                this.element[i] = this.element[i + 1];
            }
            this.element[size - 1] = 0;
            this.size -= 1;
            return (E) result;
        }

    }
    public int size(){
        return this.size;
    }
    public E clone(){
        return (E) this.element;
    }
    public boolean contains(E e){
        boolean result=false;
        for (int i=0;i<this.size;i++){
            if(this.element[i].equals(e)){
                result =true;
            }
        }
        return result;
    }
    public int indexOf(E e){
        int result=-1;
        for (int i=0;i<this.size;i++){
            if(this.element[i].equals(e)){
                result =i;
                break;
            }
        }
        return result;
    }
    public boolean add(E e){
        if(this.size>=this.element.length){
            return false;
        }else{
            this.element[size]=e;
            this.size += 1;
            return true;
        }
    }
    public E get(int i){
        return (E)this.element[i];
    }
    public void clear(){
        this.element=new Object[DEFAUL_CAPACITY];
        this.size=0;
    }
}

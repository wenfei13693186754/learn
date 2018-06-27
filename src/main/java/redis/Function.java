package redis;

public interface Function<E, T> {

    public T execute(E e);

}
